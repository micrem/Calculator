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
        //String tempStr = calc.getResult().toString();

        Double result;
        Double num1d = Double.parseDouble(calcData.getNum1());
        Double num2d = Double.parseDouble(calcData.getNum2());
        String operator = calcData.getOperator();
        Operator op;


        Calculator calc = new Calculator();
        op = calc.stringToEnum(operator);
        result = calc.calculate(num1d, num2d, op);
        calcData.setResult(result.toString());

        mv.setViewName("calc");
        mv.addObject("calcData", calcData);
        return mv;
    }

    @GetMapping("/ui5")
    public String ui5Html(Model model) {
        //mv.addObject("calcData", new CalculatorData() );
        //mv.setViewName("calcInput");
        //return mv;
        //model.addAttribute("calcData", new CalculatorDataString());
        return "ui5";
    }
}
