package com.tms.controller;

import com.tms.dao.StudentDao;
import com.tms.model.Student;
import com.tms.validator.StudentsValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentsController {

    @Autowired
    private StudentsValidator studentsValidator;

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        Student newStudent = new Student();
        model.addAttribute("newStudent", newStudent);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(Model model, Student newStudent, BindingResult result) {
        studentsValidator.validate(newStudent, result);
        if(result.hasErrors())
        {
            model.addAttribute("errors", result.getAllErrors());
            return "../../error";
        }
        studentDao.addStudent(newStudent);

        return "first";
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first(Model model) {
        model.addAttribute("message", "Message from page available for EVERYONE");
        return "first";
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String second(Model model) {
        model.addAttribute("message", "Message from page available for AUTHENTICATED users");
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        return "second";
    }

    @RequestMapping(value = "/third", method = RequestMethod.GET)
    public String third(Model model) {
        model.addAttribute("message", "Message from page available for AUTHORIZED (ADMIN role) users");
        model.addAttribute("users", studentDao.findAll());
        return "third";
    }
}
