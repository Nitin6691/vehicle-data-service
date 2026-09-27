package com.nitin.vehicledataservice.exception;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String s){
        super(s);
    }
}
