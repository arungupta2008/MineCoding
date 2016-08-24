package com.example.currencyConvert.response;


import com.example.currencyConvert.Helper.Helper;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response {
    @Getter @Setter
    Double amount;

    @Override
    public String toString() {
        return Helper.toJson(this);
    }
}
