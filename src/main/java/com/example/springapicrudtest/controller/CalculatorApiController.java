package com.example.springapicrudtest.controller;

import com.example.springapicrudtest.component.Calculator;
import com.example.springapicrudtest.component.ICalculator;
import com.example.springapicrudtest.dto.Req;
import com.example.springapicrudtest.dto.Res;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){
            return calculator.sum(x,y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req){
           int result = calculator.minus(req.getX(), req.getY());

           Res res = new Res();
           res.setResult(result);
           res.setResponse(new Res.Body());
           log.info("result: {} , resultCode: {}" , res.getResult(), res.getResponse().getResultCode());
           return res;
    }
}
