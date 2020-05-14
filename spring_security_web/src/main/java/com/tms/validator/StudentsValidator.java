package com.tms.validator;

import com.tms.model.Student;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StudentsValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if(StringUtils.isEmpty(student.getUsername())) {
            errors.rejectValue("username", "username invalid");
        }
        if(StringUtils.isEmpty(student.getPassword())) {
            errors.rejectValue("password", "password invalid");
        }
        if(StringUtils.isEmpty(student.getName())) {
            errors.rejectValue("name", "name invalid");
        }
        if(StringUtils.isEmpty(student.getSurname())) {
            errors.rejectValue("surname", "surname invalid");
        }
    }
}
