import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtTest {
    @Test
    public void testCreateJwt() {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", 10);
        userInfo.put("username", "zhang3");
        userInfo.put("roles", "productAdmin,orderAdmin");
        userInfo.put("expire", 1 * 60 * 60 * 1000);
        // 创建令牌是以用户信息作为载荷
        String token = JWTUtil.createToken(userInfo, "110".getBytes());
        System.out.println("令牌如下：");
        System.out.println(token);
    }

    @Test
    public void testVerifyJwt() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJyb2xlcyI6InByb2R1Y3RBZG1pbixvcmRlckFkbWluIiwiZXhwaXJlIjozNjAwMDAwLCJpZCI6MTAsInVzZXJuYW1lIjoiemhhbmczIn0" +
                ".beIGjoUWiZF9gUHn5pNs0QUUCa7WTXgvA2ZhT5QU-TY";
        if (JWTUtil.verify(token,"110".getBytes())) {// 返回true表示令牌正确
            System.out.println("令牌有效");
        } else {// 返回false表示令牌无效
            System.out.println("令牌无效");
        }
    }
    @Test
    public void testJWTParse() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJyb2xlcyI6InByb2R1Y3RBZG1pbixvcmRlckFkbWluIiwiZXhwaXJlIjozNjAwMDAwLCJpZCI6MTAsInVzZXJuYW1lIjoiemhhbmczIn0" +
                ".beIGjoUWiZF9gUHn5pNs0QUUCa7WTXgvA2ZhT5QU-TY";
        // 对给定的令牌进行解析
        JWT jwt = JWTUtil.parseToken(token);
        System.out.println(jwt.getPayload());
        System.out.println(jwt.getPayload().getClaim("roles"));
        System.out.println("加密算法：" + jwt.getAlgorithm());
        // 验证令牌是使用签名
        JWTSigner signer = JWTSignerUtil.createSigner("HS256","110".getBytes());
        System.out.println(jwt.verify(signer));
//        System.out.println("token签名：" + jwt.getSigner());
    }
}
