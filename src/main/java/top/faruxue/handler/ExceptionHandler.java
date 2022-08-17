package top.faruxue.handler;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.faruxue.Application;
import top.faruxue.domain.ResultCode;
import top.faruxue.vo.ResultVo;

/**
 * @author: Frank
 * @date: 2022/8/17 0:10
 */
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResultVo nullPointExceptionHandler(NullPointerException e) {
        return new ResultVo(ResultCode.VALIDATE_ERROR.getCode(),"参数为空" ,e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
    public ResultVo appExceptionHandler(ApiException e) {
        System.out.println(e.getMessage());
        System.out.println(e);
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }

}
