package com.example.demo.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import com.example.demo.common.Result;
import com.example.demo.common.ParamVilidator;

@Aspect
@Component
public class ParamVilidatorAspect {
	
	//注入hibernate验证类
	@Autowired
	Validator validator;
	 /**
     * 消息源资源对象
     */
    @Autowired
    private MessageSource messageSource;
    
    @Pointcut("@annotation(com.example.demo.common.ParamVilidator)")
    public  void annotationPointCut() {
    }
    
    @Around(value="annotationPointCut()")
    public Object  around(ProceedingJoinPoint  joinPoin) {
    	//获取参数列表
    	Object[]  obj = joinPoin.getArgs();
    	//获取方法名称
        String  methodName = joinPoin.getSignature().getName();
        //获取类
        Class<? extends Object> clazz = joinPoin.getTarget().getClass();
        //获取参数类型列表
        Class[] parameterTypes = ((MethodSignature)joinPoin.getSignature()).getParameterTypes();
        
        try {
        	Method method = clazz.getMethod(methodName, parameterTypes);
            if (method.isAnnotationPresent(ParamVilidator.class)) {
            	for (Object o : obj) {
            		Set<ConstraintViolation<Object>> set = validator.validate(o);
                    for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext();) {
    					ConstraintViolation<Object> constraintViolation = iterator.next();
    					String code = constraintViolation.getMessage();
    					return   Result.fail(code,messageSource.getMessage(code, null, "", LocaleContextHolder.getLocale()));
    				}
            	}
            }
            return joinPoin.proceed();
            
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
