package com.sx.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
//    @ExceptionHandler({UnauthorizedException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("exception", e);
//        mv.setViewName("unauthorized");
//        return mv;
//    }


}
