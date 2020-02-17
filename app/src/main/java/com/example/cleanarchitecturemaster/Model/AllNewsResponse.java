package com.example.cleanarchitecturemaster.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllNewsResponse {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<News> getNews();

}
