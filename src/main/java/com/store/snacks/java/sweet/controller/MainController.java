package com.store.snacks.java.sweet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ngan nnh on 5/13/2019
 * @project sweet
 */
@Controller
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET) public ModelAndView index() {
        ModelAndView modelAndView = getMAV();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    static ModelAndView getMAV() {
        return new ModelAndView();
    }

    static String getMethodName(){
        return new Throwable().getStackTrace()[1].getMethodName();
    }
}
