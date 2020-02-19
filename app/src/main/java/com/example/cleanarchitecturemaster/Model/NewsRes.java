package com.example.cleanarchitecturemaster.Model;

import java.util.ArrayList;
import java.util.List;

public class NewsRes {

    private String title;
    List<Row> rows = new ArrayList<Row>();

    public List<Row> getRows() {
        return rows;
    }




    // Getter Methods

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setTitle( String title ) {
        this.title = title;
    }
}
