package org.caohh.albol.vo;

import lombok.Data;

@Data
public class Result {
    public enum Code {
        SUCCESS(20000),
        FAIL(20001),
        ILLEGAL(50008),
        EXPIRED(50014);

        private final Integer code;

        Code(Integer code) {
            this.code = code;
        }
    }

    public Result() {
    }

    public Result(Code code, String message) {
        this.code = code.code;
        this.message = message;
    }

    public Result(Code code, Object data) {
        this.code = code.code;
        this.data = data;
    }

    public Result(Code code, String message, Object data) {
        this.code = code.code;
        this.message = message;
        this.data = data;
    }

    //返回码
    private Integer code;
    //消息
    private String message;
    //数据
    private Object data;
}
