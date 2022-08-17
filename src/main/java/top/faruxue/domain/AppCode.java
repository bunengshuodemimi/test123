package top.faruxue.domain;

import top.faruxue.vo.StatusCode;

/**
 * @author: Frank
 * @date: 2022/8/17 0:25
 */
public enum AppCode implements StatusCode {

    APP_ERROR(2000, "业务异常"),
    PRICE_ERROR(2001, "价格异常");

    private Integer code;
    private String msg;

    AppCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
