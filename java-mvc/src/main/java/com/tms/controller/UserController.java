package com.tms.controller;

import com.tms.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello there! Do you want to add new user?");
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userOb", new User());
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("userOb") User user, ModelMap model) {
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());

        return "result";
    }
}
