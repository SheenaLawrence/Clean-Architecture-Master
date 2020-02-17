package com.example.cleanarchitecturemaster.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.cleanarchitecturemaster.Model.AllNewsResponse;
import com.example.cleanarchitecturemaster.Model.News;
import com.example.cleanarchitecturemaster.Model.NewsRes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Intractor implements GetDataContract.Interactor {
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<NewsRes> allNews = new ArrayList<>();
    List<String> allNewsData = new ArrayList<>();

    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener) {
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AllNewsResponse request = retrofit.create(AllNewsResponse.class);
        retrofit2.Call<News> call = request.getNews();
        call.enqueue(new retrofit2.Callback<News>() {
            @Override
            public void onResponse(retrofit2.Call<News> call, retrofit2.Response<News> response) {
                News jsonResponse = response.body();
                allNews = jsonResponse.getNews();
                for (int i = 0; i < allNews.size(); i++) {
                    allNewsData.add(allNews.get(i).getTitle());
                }
                Log.i("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size" + allNewsData.size(), allNews);
            }

            @Override
            public void onFailure(retrofit2.Call<News> call, Throwable t) {
                Log.i("Error", t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}

