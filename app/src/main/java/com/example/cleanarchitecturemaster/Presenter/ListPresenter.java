package com.example.cleanarchitecturemaster.Presenter;

import android.content.Context;

import com.example.cleanarchitecturemaster.Model.NewsRes;

import java.util.List;

public class ListPresenter implements GetDataContract.listPresenter,GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Intractor mIntractor;
    public ListPresenter(GetDataContract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
    }

    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context,url);
    }

    @Override
    public void onSuccess(String message, List<NewsRes> list) {

        mGetDataView.onGetDataSuccess(message, list);

    }

    @Override
    public void onFailure(String message) {

        mGetDataView.onGetDataFailure(message);

    }
}
