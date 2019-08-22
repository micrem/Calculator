package com.example.mrem0106.demomremSpringDemo2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin
//dev prod parity
//
public class CalculatorRestController {
    @GetMapping(path = "/calcrest")
    public CalculatorDataString calculate(@RequestParam String a, @RequestParam String b, @RequestParam String operant) {
        Calculator calculator = new Calculator();
        Operator operator = calculator.stringToEnum(operant);
        CalculatorDataString data = new CalculatorDataString();

        double anum=0.;
        double bnum=0.;

        try {
            anum = Double.parseDouble(a);
            bnum = Double.parseDouble(b);
        } catch (java.lang.NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        data.setNum1(a);
        data.setNum2(b);
        data.setOperator(operant);
        data.setResult(Double.toString(calculator.calculate(anum, bnum, operator)));

        System.out.println("request : a = " + a + "   b = " + b + "   operator = " + operant + "   result = " + data.getResult() );

        return data;
    }
}
