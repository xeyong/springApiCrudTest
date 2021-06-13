package com.example.springapicrudtest.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.error.Mark;

@Component
@RequiredArgsConstructor
public class DollorCalculator implements ICalculator{

    private int price = 1;

    private final MarketApi marketApi;// @RequiredArgsConstuctor랑 
    /*이거랑 완전 같은코드임
    private MarketApi marketApi;

    public DollorCalculator(MarketApi marketApi){
        this.marketApi = marketApi;
    }

     */

    public void init(){
        this.price = marketApi.connect();
    }
    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;

        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;

        return x-y;
    }
}
