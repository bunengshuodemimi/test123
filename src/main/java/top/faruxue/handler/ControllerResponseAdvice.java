package top.faruxue.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.faruxue.vo.ResultVo;

/**
 * @author: Frank
 * @date: 2022/8/17 0:17
 */
@RestControllerAdvice(basePackages = {"top.faruxue.controller"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        response是ResultCo类型不进行包装
        return !methodParameter.getParameterType().isAssignableFrom(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter resultType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
//        String类型不能直接包装
        if (resultType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
//                将数据包装在ResultVo里后转换为json串进行返回
                objectMapper.writeValueAsString(new ResultVo(data));
            } catch (JsonProcessingException e) {

            }
        }
//        否则直接包装成ResultVo返回
        return new ResultVo(data);
    }
}
