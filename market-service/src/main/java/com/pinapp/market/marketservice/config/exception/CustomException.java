package com.pinapp.market.marketservice.config.exception;

public class CustomException extends RuntimeException{

    public static final long serialVersionUID = 700L;

    public CustomException(){}

    public CustomException(String message){
        super(message);
    }
}
