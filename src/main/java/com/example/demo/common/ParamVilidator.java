package com.example.demo.common;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
/**
 * 参数校验注解 用于方法
 * 
 * 例子：@ParamVilidator(index={"1","2"})  表示对第一个参数和第二个参数校验
 * @author YCKJ1060
 *
 */
public @interface ParamVilidator {
	String[] index() ;
}
