package com.mdxq.mall.response;

import lombok.Data;

@Data
public class R {

    private int code;
    private String message;
    private Object Data;

    // 不允许通过构造器来实例化R，之恶能通过后边我们提供的静态方法返回固定格式的数据
    private R() {}

    private R(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        Data = data;
    }

    public static R ok(Object data) {
        R r = new R(200, "操作成功", data);
        return r;
    }

    public static R error() {
        R r = new R(500, "程序出错了", null);
        return r;
    }

}
