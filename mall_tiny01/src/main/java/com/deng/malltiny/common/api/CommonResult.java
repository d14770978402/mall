package com.deng.malltiny.common.api;

/**
 * 1.这个类将（1）我们要返回的数据，（2）状态码 ，（3）提示信息 ， 封装到一起
 * 2.由于重写了构造函数，必须写上默认构造函数
 * 3.构造函数名不需要加上泛型
 * 4.通过这里面的方法（success，failed）得到此类类型，所以方法最好为静态方法
 */
public class CommonResult<T> {
    private String message;
    private Long code;
    private T data;
    public CommonResult(String message,Long code,T data){
        this.code = code;
        this.data = data;
        this.message = message;
    }
    public CommonResult(){}

    /**
     * 1.成功：将data与默认的resultCode.success封装,
     * 2.成功：，将data与自定义message，用默认code
     * @param data
     * @param <T>
     * @return
     */
    public static <T>CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getMessage(),ResultCode.SUCCESS.getCode(),data);
    }
    public static <T>CommonResult<T> success(String message,T data){
        return new CommonResult<T>(message,ResultCode.SUCCESS.getCode(),data);
    }

    /**1.这是对没有提示信息的封装
     *
     * @return
     */
    public static <T>CommonResult<T> failed(IErrorCode iErrorCode){
        return new CommonResult<T>(iErrorCode.getMessage(),iErrorCode.getCode(),null);
    }
    public static <T>CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }
    public static <T>CommonResult<T> failed(String message){
        return new CommonResult<T>(message,ResultCode.FAILED.getCode(),null);
    }
    public static <T>CommonResult<T> volidateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }
    public static <T>CommonResult<T> volidateFailed(String message){
        return new CommonResult<T>(message,ResultCode.VALIDATE_FAILED.getCode(),null);
    }
//    未登入返回结果（当前页面）
    public static <T>CommonResult<T> unAuthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getMessage(),ResultCode.UNAUTHORIZED.getCode(),data);
    }
//      未授权返回结果（当前页面）
    public static <T>CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getMessage(),ResultCode.FORBIDDEN.getCode(),data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
