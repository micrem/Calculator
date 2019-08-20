package com.example.mrem0106.demomremSpringDemo2;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcControllerMvc {

    @GetMapping("/calc")
    public String calcForm(Model model) {
        //mv.addObject("calcData", new CalculatorData() );
        //mv.setViewName("calcInput");
        //return mv;
        model.addAttribute("calcData", new CalculatorDataString());
        return "calcInput";
    }

    @PostMapping("/ergebnis")
    public ModelAndView calcSubmit(@ModelAttribute CalculatorDataString calcData, ModelAndView mv) {
        //CalculatorData calc = new CalculatorData(calcData.getNum1(), calcData.getNum2(), calcData.getOperator());
        //calcData.setResult(calc.getResult().toString());
        Double result;
        Double num1d = Double.parseDouble(calcData.getNum1());
        Double num2d = Double.parseDouble(calcData.getNum2());
        String operator = calcData.getOperator();
        result = Double.NaN;

        if (operator.equalsIgnoreCase("*")){
            result = num1d * num2d;
        } else if (operator.equalsIgnoreCase("/")){
            result = num1d / num2d;
        } else if (operator.equalsIgnoreCase("+")){
            result = num1d + num2d;
        } else if (operator.equalsIgnoreCase("-")){
            result = num1d - num2d;
        }

        calcData.setResult(result.toString());
        mv.setViewName("calc");
        mv.addObject("calcData", calcData);
        return mv;
        //return "calc";
    }
}
