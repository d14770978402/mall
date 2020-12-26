package com.deng.malltiny.common.api;

/**0.这是枚举类
 * 1.封装了状态码，和提示信息
 * 2.并创建了SUCCESS之类的枚举对象
 * 3.通过私有构造函数生成对象实例，即有且仅有列举的几个对象
 * ??,枚举的属性类型不能是Long吗？
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404,"参数校验失败"),
    UNAUTHORIZED(401,"未登入或taken已过期"),
    FORBIDDEN(403,"没有相关权限");

    private long code;
    private String message;

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }




}
