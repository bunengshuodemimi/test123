package top.faruxue.vo;

import top.faruxue.domain.ResultCode;

/**
 * @author: Frank
 * @date: 2022/8/16 23:00
 */
public class ResultVo {
//    状态码
    private Integer code;
//    状态信息
    private String msg;
//    返回对象
    private Object data;

//    手动设置返回vo
    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//    默认返回成功状态码,数据对象
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

//    返回指定状态码，数据对象
    public ResultVo(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

//    只返回状态码
    public ResultVo(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
