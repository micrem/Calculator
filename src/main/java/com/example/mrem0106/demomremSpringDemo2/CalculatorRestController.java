package com.example.mrem0106.demomremSpringDemo2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
public class CalculatorRestController {
    @GetMapping(path = "/calcrest")
    public CalculatorDataString calculate(@RequestParam String a, @RequestParam String b, @RequestParam String operant) {
        Calculator calculator = new Calculator();
        Operator operator = calculator.stringToEnum(operant);
        CalculatorDataString data = new CalculatorDataString();

        double anum = Double.parseDouble(a);
        double bnum = Double.parseDouble(b);

        data.setNum1(a);
        data.setNum2(b);
        data.setOperator(operant);
        data.setResult(Double.toString(calculator.calculate(anum, bnum, operator)));

        return data;
    }
}
