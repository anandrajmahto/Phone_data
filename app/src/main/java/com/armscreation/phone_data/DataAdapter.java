package com.armscreation.phone_data;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataAdapter {

    public String name;
    public String email;
    public String g1;
    public String g2;
    public String g3;
    public String g4;
    public String g5;
    public String g6;
    public String g7;
    public String g8;
    public String g9;
    public  String turn;
public String indicator;


    public DataAdapter(String turn, String indicator) {
        this.turn = turn;
        this.indicator = indicator;
    }

    public DataAdapter(String g1, String g2, String g3, String g4, String g5, String g6, String g7, String g8, String g9) {

        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
        this.g5 = g5;
        this.g6 = g6;
        this.g7 = g7;
        this.g8 = g8;
        this.g9 = g9;
    }
    public DataAdapter(String name) {
        this.name = name;

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

    public String getG2() {
        return g2;
    }

    public void setG2(String g2) {
        this.g2 = g2;
    }

    public String getG3() {
        return g3;
    }

    public void setG3(String g3) {
        this.g3 = g3;
    }

    public String getG4() {
        return g4;
    }

    public void setG4(String g4) {
        this.g4 = g4;
    }

    public String getG5() {
        return g5;
    }

    public void setG5(String g5) {
        this.g5 = g5;
    }

    public String getG6() {
        return g6;
    }

    public void setG6(String g6) {
        this.g6 = g6;
    }

    public String getG7() {
        return g7;
    }

    public void setG7(String g7) {
        this.g7 = g7;
    }

    public String getG8() {
        return g8;
    }

    public void setG8(String g8) {
        this.g8 = g8;
    }

    public String getG9() {
        return g9;
    }

    public void setG9(String g9) {
        this.g9 = g9;
    }



    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public DataAdapter() {
    }

}