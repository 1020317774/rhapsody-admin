package com.wyc.elegant.admin.exception;

import com.wyc.elegant.admin.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 统一异常处理
 *
 * @author Knox
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常捕获
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        logger.error("全局异常：" + ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage());
    }

    /**
     * 处理入参时，参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String defaultMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        logger.error("参数验证异常：" + defaultMessage);
        return R.error().message(defaultMessage);
    }

    /**
     * 未登录
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(TokenException.class)
    public R noAuthException(TokenException e) {
        logger.error("未登录异常：" + ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMessage());
    }

    /**
     * 处理自定义异常
     *
     * @param e 异常
     * @return {@link R}
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public R myError(MyException e) {
        logger.error("自定义异常：" + ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMessage());
    }
}