package com.armscreation.phone_data;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataAdapter {


    public String name;
    public String email;
    public String g1;


    public  String value1,value2,value3;

    public  String turn;
public String indicator;


    public DataAdapter(String turn, String indicator) {
        this.turn = turn;
        this.indicator = indicator;
    }

    public DataAdapter(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
    public DataAdapter(String name) {
        this.name = name;

    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getindicator() {
        return indicator;
    }

    public void setindicator(String blank) {
        this.indicator = indicator;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getG1() {
        return g1;
    }

    public void setG1(String g1) {
        this.g1 = g1;
    }





    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public DataAdapter() {
    }

}