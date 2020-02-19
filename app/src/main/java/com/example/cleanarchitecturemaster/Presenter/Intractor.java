package com.example.cleanarchitecturemaster.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.cleanarchitecturemaster.Model.AllNewsResponse;
import com.example.cleanarchitecturemaster.Model.News;
import com.example.cleanarchitecturemaster.Model.NewsRes;
import com.example.cleanarchitecturemaster.Model.Row;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Intractor implements GetDataContract.Interactor {
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    List<Row> allNews = new ArrayList<>();
    List<Row> allRows=new ArrayList<>();
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
        retrofit2.Call<NewsRes> call = request.getNews();
        call.enqueue(new retrofit2.Callback<NewsRes>() {
            @Override
            public void onResponse(retrofit2.Call<NewsRes> call, retrofit2.Response<NewsRes> response) {

                NewsRes jsonResponse = response.body();
                allNews=jsonResponse.getRows();
                for (int k=0;k<allNews.size();k++)
                {
                    Log.i("RESPONSE",allNews.get(k)+"");
                    allNewsData.add(allNews.get(k).getTitle());
                }
                mOnGetDatalistener.onSuccess("List Size: " + allNewsData.size(),allNews);

            }

            @Override
            public void onFailure(retrofit2.Call<NewsRes> call, Throwable t) {
                Log.i("Error", t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}

