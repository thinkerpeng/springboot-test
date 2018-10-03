package com.pwx.spring.mvc.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by pengweixiang on 2018/10/1.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private Pattern pattern = Pattern.compile("^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|" +
        "([8][0-9])|([9][8,9]))[0-9]{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return pattern.matcher(value).matches();
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }
}
