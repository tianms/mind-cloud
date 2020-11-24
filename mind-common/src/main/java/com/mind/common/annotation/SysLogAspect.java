package com.mind.common.annotation;

import com.alibaba.fastjson.JSON;
import com.mind.common.constatns.NumConstant;
import com.mind.common.constatns.ReqMethodConstant;
import com.mind.common.utils.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @Auther: tianms
 * @Date: 2020/11/23 11:04
 * @Description: 操作日志切面注解，可以写入数据库
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {

//    @Autowired
//    private SysLogRecordService sysLogRecordService;

    //表示匹配带有自定义注解的方法
    @Pointcut("@annotation(com.mind.common.annotation.SysLog )")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
            long endTime = System.currentTimeMillis();
            insertLog(point, endTime - beginTime);
        } catch (Throwable e) {
            log.error("SysLogAspect pointcut() error: {}", e);
        }
        return result;
    }

    private void insertLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
//         SysLogRecordModel sysLogRecordModel = new SysLogRecordModel();

        //获取操作
        SysLog operation = method.getAnnotation(SysLog.class);
        if (operation != null) {
            String value = operation.value();
//            sysLogRecordModel.setOperation(value);//保存获取的操作
        }

//        Api api = method.getAnnotation(Api.class);
//        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
//        String operationText = "";
//        if (api != null) {
//            operationText += api.tags()[0];
//        }
//        if (apiOperation != null) {
//            operationText += '-' + apiOperation.value();
//        }
//        //保存获取的操作
//        sysLog.setOperation(operationText);

        //获取请求的类名
        String className = point.getTarget().getClass().getName();

        //获取请求的方法名
        String methodName = method.getName();
//        sysLogRecordModel.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = point.getArgs();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest httpRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        if (ReqMethodConstant.GET.equalsIgnoreCase(httpRequest.getMethod())) {
            Enumeration<String> enumeration = httpRequest.getParameterNames();
            MapUtils mapUtils = new MapUtils();
            while (enumeration.hasMoreElements()) {
                String parameter = enumeration.nextElement();
                mapUtils.put(parameter, httpRequest.getParameter(parameter));
            }
            String str = JSON.toJSONString(mapUtils);
            if (args.length > NumConstant.ONE.intValue()) {
//                sysLogRecordModel.setParams(str);
            }
        }
        if (ReqMethodConstant.POST.equalsIgnoreCase(httpRequest.getMethod())) {
            try {
                BufferedReader br = httpRequest.getReader();
                String str = null;
                StringBuffer stringBuffer = new StringBuffer();
                while ((str = br.readLine()) != null) {
                    stringBuffer.append(str);
                }
//                sysLogRecordModel.setParams(stringBuffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //请求的时间
//        sysLogRecordModel.setCreateTime(new Date());

        //获取用户ID和企业ID
//        UserInfo userInfo = userContext.getUserInfo();
//        Integer userId = userInfo.getUserId();
//        sysLogRecordModel.setUserId(userId);
//        String username = userInfo.getUsername();
//        sysLogRecordModel.setUsername(username);
//        Integer CompanyId = userInfo.getCompanyId().intValue();
//        sysLogRecordModel.setCompanyId(CompanyId);

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        sysLogRecordModel.setIp(IpAdrressUtil.getIpAdrress(request));

//        sysLogRecordService.insert(sysLogRecordModel);
    }
}
