package com.lapin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author Lapin:Athens , starsw@coupang.com
 * @since 2017. 10. 12.
 */
@Slf4j
@Controller
public class HelloController {

    private ObjectMapper objectMapper;

    @Autowired
    @Bean
    public ObjectMapper objectMapper(){
        objectMapper = new ObjectMapper();
        return objectMapper;
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @RequestMapping("/")
    public ModelAndView dashboard(){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("randString",getSaltString());
        return modelAndView;
    }

    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam(value = "key",required = false)String key){

        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("randString",getSaltString());
        if(key == null || "".equals(key)){
            modelAndView.addObject("loadData", false);
            return modelAndView;
        }
        modelAndView.addObject("loadData", true);
        modelAndView.addObject("formComment","helloComment!!");
        modelAndView.addObject("formName","helloName");
        modelAndView.addObject("formMail","hello@mail");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/autosave")
    public String autosave(@RequestParam(value = "data") String data){
        log.info("autosave: {}",data);
        return data;
    }

}
