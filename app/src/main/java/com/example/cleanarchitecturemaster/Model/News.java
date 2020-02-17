package com.example.cleanarchitecturemaster.Model;

import java.util.List;

public class News {

    private List<NewsRes> news=null;
    public List<NewsRes> getNews()
    {
        return news;
    }

    public void setNews(List<NewsRes> news){
        this.news=news;
    }
}
