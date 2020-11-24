package com.mind.common.annotation;

import com.alibaba.fastjson.JSON;
import com.mind.common.constatns.NumConstant;
import com.mind.common.constatns.ReqMethodConstant;
import com.mind.common.constatns.SymbolConstant;
import com.mind.common.utils.MapUtils;
import com.mind.common.utils.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Auther: tianms
 * @Date: 2020/11/23 10:49
 * @Description: aop日志输出切面注解
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    // 标注使用哪个注解
    @Pointcut("@annotation(com.mind.common.annotation.Log)")
    private void cut() {
    } // 切面方法

    @Around("cut()")
    public Object cutMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        signature.getName();
        //AOP代理类的名字
        signature.getDeclaringTypeName();
        String className = signature.getDeclaringTypeName().split("[.]")[signature.getDeclaringTypeName().split("[.]").length - NumConstant.ONE.intValue()];
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (ObjectUtil.isEmpty(requestAttributes)) {
            Object result = joinPoint.proceed();
            return result;
        }
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        if (ObjectUtil.isEmpty(request)) {
            Object result = joinPoint.proceed();
            return result;
        }
        String method = request.getMethod();
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        if (ReqMethodConstant.GET.equalsIgnoreCase(request.getMethod())) {
            Enumeration<String> enumeration = request.getParameterNames();
            MapUtils mapUtils = new MapUtils();
            while (enumeration.hasMoreElements()) {
                String parameter = enumeration.nextElement();
                mapUtils.put(parameter, request.getParameter(parameter));
            }
            String str = JSON.toJSONString(mapUtils);
            if (obj.length > NumConstant.ZERO.intValue()) {
                log.info(className + SymbolConstant.VERTICAL + signature.getName() + SymbolConstant.VERTICAL + ReqMethodConstant.UP_GET + SymbolConstant.VERTICAL + str);
            }
        }
        if (ReqMethodConstant.POST.equalsIgnoreCase(request.getMethod())) {
            try {
                BufferedReader br = request.getReader();
                String str = null;
                StringBuffer stringBuffer = new StringBuffer();
                while ((str = br.readLine()) != null) {
                    stringBuffer.append(str);
                }
                log.info(className + SymbolConstant.VERTICAL + signature.getName() + SymbolConstant.VERTICAL + ReqMethodConstant.UP_POST + SymbolConstant.VERTICAL + stringBuffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Object result = joinPoint.proceed();
        if (ObjectUtil.isNotEmpty(result)) {
            log.info(className + SymbolConstant.VERTICAL + signature.getName() + SymbolConstant.VERTICAL + method + SymbolConstant.VERTICAL + result.toString());
        }
        return result;
    }

}
