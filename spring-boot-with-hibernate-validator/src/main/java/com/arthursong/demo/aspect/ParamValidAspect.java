package com.arthursong.demo.aspect;

import com.arthursong.demo.entity.dto.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Iterator;

/**
 * Created by Administrator on 2018/7/18.
 */
@Slf4j
@Aspect
@Component
public class ParamValidAspect {

    @Around("execution(* com.arthursong.demo.controller.*.*(..)) && args(..,bindingResult)")
    public ResultDto validateParam(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        ResultDto result;
        log.debug("进入AOP-ParamValidAspect-validateParam进行参数有效性校验....");
        if (bindingResult.hasErrors()) {
            Iterator<ObjectError> iterator = bindingResult.getAllErrors().iterator();
            ObjectError objectError = iterator.next();
            log.info("AOP-ParamValidAspect-validateParam进行参数校验出错, 出错信息如下：{}", objectError);

            return ResultDto.fail(objectError.getDefaultMessage(),objectError);
        } else {
            //执行目标方法
            result = (ResultDto) pjp.proceed();
        }
        return result;
    }

}
