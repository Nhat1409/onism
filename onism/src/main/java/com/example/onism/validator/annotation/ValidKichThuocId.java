package com.example.onism.validator.annotation;

import com.example.onism.validator.ValidKichThuocValidator;
import com.example.onism.validator.ValidLoaiValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidKichThuocValidator.class)
@Documented
public @interface ValidKichThuocId {
    String message() default "Invalid Loai ID";
    Class <?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}


