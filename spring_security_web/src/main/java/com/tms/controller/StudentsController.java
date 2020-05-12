package com.tms.controller;

import com.tms.dao.StudentDao;
import com.tms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentsController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first(Model model) {
        model.addAttribute("message", "Message from page available for EVERYONE");
        return "first";
    }

    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String second(Model model) {
        model.addAttribute("message", "Message from page available for AUTHENTICATED users");
        model.addAttribute("name", ((Student)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName());
        return "second";
    }

    @RequestMapping(value = "/third", method = RequestMethod.GET)
    public String third(Model model) {
        model.addAttribute("message", "Message from page available for AUTHORIZED (ADMIN role) users");
        model.addAttribute("users", studentDao.findAll());
        return "third";
    }
}
