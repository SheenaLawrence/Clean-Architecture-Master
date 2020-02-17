package com.example.cleanarchitecturemaster.Model;

import java.util.ArrayList;

public class NewsRes {

    private String title;
    ArrayList<Object> rows = new ArrayList<Object>();


    // Getter Methods

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setTitle( String title ) {
        this.title = title;
    }
}
