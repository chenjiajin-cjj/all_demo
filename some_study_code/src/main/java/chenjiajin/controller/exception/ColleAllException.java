package chenjiajin.controller.exception;

import chenjiajin.controller.controller.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice("chenjiajin.controller.controller")
@Slf4j
public class ColleAllException {

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            log.error("数据校验出现问题{},异常类型：{}", e.getMessage(), e.getClass());
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = exception.getBindingResult();
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach((fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }));
            return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(),BizCodeEnum.VAILD_EXCEPTION.getMsg()).put("data",errorMap);
        }
        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(),BizCodeEnum.UNKNOW_EXCEPTION.getMsg());
    }
}
