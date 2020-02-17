package com.example.cleanarchitecturemaster.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cleanarchitecturemaster.Adapter.NewsListAdapter;
import com.example.cleanarchitecturemaster.Model.NewsRes;
import com.example.cleanarchitecturemaster.Presenter.GetDataContract;
import com.example.cleanarchitecturemaster.Presenter.ListPresenter;
import com.example.cleanarchitecturemaster.R;

import java.util.List;

public class ListActivity extends AppCompatActivity implements GetDataContract.View {
    private ListPresenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        mPresenter=new ListPresenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void onGetDataSuccess(String message, List<NewsRes> list) {
        newsListAdapter = new NewsListAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(newsListAdapter);
    }
    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status",message);
    }
}
