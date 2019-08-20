package com.example.mrem0106.demomremSpringDemo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldMvcController {

    @GetMapping(path = "/hellomvcTemp")
    public String getHelloWorld(){
        return "greetingTemp"; //name des templates

    }

    @GetMapping(path = "/hellomvc")
    public ModelAndView getHelloWorldMvc(ModelAndView mv){
        mv.setViewName("greeting");
        mv.addObject("name","name_text");
        return mv;

    }
}
