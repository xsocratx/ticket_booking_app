package com.example.ticketapp.model;

import java.math.BigDecimal;

public enum ReservationType {
    ADULT("Adult", new BigDecimal(25.0)), STUDENT("Student", new BigDecimal(18.0)), CHILD("Child", new BigDecimal(12.50));

    private final String key;
    private final BigDecimal value;

    ReservationType(String key, BigDecimal value){
        this.key = key;
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public BigDecimal getValue(){
        return value;
    }
}
