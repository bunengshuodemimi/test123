package top.faruxue.handler;

import top.faruxue.domain.AppCode;
import top.faruxue.vo.StatusCode;

/**
 * @author: Frank
 * @date: 2022/8/17 0:35
 */
public class ApiException extends RuntimeException {

    private Integer code;
    private String msg;

//    手动设置异常
    public ApiException(StatusCode statusCode, String message) {
//        message用于用户设置抛出异常详情
        super(message);
//        状态码
        this.code = statusCode.getCode();
//        状态码配套的msg
        this.msg = statusCode.getMsg();
    }

//    默认异常使用APP_ERROR状态码
    public ApiException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
