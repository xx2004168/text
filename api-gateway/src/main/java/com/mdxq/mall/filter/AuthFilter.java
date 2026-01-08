package com.mdxq.mall.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@ConfigurationProperties(prefix = "spring.cloud.gateway.global-filter")
public class AuthFilter implements GlobalFilter {
    List<String> whitePathList;// 白名单是从 bootstrap.yml 主配文件中获取的

    public void setWhitePathList(List<String> whitePathList) {
        this.whitePathList = whitePathList;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 身份认证图中的第2步，先获取当前请求的路径
        ServerHttpRequest request = exchange.getRequest();//获取请求对象
        String path = request.getPath().value();//获取请求路径
        // 如果请求的路径在白名单中，直接跳过身份认证
        if (whitePathList.contains(path)) {
            return chain.filter(exchange);//当前过滤器放行，进入链条中的下一个过滤器
        }
        /*
        Authorization: jwt令牌
         */
        // 从请求头中获取 token令牌
        List<String> list = request.getHeaders().get("Authorization");
        // 未携带令牌
        ServerHttpResponse response = exchange.getResponse();
        if (list == null || list.size() == 0) {
            response.setRawStatusCode(401);//认证失败，返回未授权
            return response.setComplete();
        }
        // 取出令牌
        String token = list.get(0);
        // 判断Redis缓存里是否有这个令牌，如果没有说明令牌已经过期或伪造
        if (!redisTemplate.hasKey(token)) {
            response.setRawStatusCode(401);//认证失败，返回未授权
            return response.setComplete();
        }
        try {
            if (JWTUtil.verify(token, "md-mall-0112".getBytes())) {//令牌认证合法
                JWT jwt = JWTUtil.parseToken(token);
                long iat = Long.valueOf(jwt.getPayload("iat").toString());//签发时间
                long exp = Long.valueOf(jwt.getPayload("exp").toString());//有效时长
                long now = System.currentTimeMillis()/1000;//当前系统时间
                if (iat + exp > now) {
                    return chain.filter(exchange);//认证通过，放行
                } else {//令牌过期了
                    response.setRawStatusCode(401);//认证失败，返回未授权
                }
            } else{//令牌无效
                response.setRawStatusCode(401);//认证失败，返回未授权
            }
        } catch (Exception ex) {
            // 令牌被篡改或伪造，导致令牌认证时出错
            response.setRawStatusCode(401);//认证失败，返回未授权
        }
        // 结束当前的过滤器链，不在往下执行
        return response.setComplete();
    }

}
