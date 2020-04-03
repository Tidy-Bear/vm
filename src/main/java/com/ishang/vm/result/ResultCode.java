package com.ishang.vm.result;

public class ResultCode {
    public static final int FAIL = 400;
    public static final int SUCCESS = 200;
    public static final int UNAUTHORIZED = 401;
    public static final int NOT_FOUND = 404;
    public static final int INTERNAL_SERVER_ERROR = 500;

//    SUCCESS(200),
//    FAIL(400),
//    UNAUTHORIZED(401),
//    NOT_FOUND(404),
//    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
