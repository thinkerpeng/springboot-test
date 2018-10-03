package com.pwx.spring.mvc.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * Created by pengweixiang on 2018/10/1.
 * 手机号校验注解
 */
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {

    String message() default "Phone number is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
