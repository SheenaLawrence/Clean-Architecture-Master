package com.example.cleanarchitecturemaster.Presenter;

import android.content.Context;

import com.example.cleanarchitecturemaster.Model.NewsRes;

import java.util.List;

public interface GetDataContract {

        interface View {
            void onGetDataSuccess(String message, List<NewsRes> list);
            void onGetDataFailure(String message);

        }
        interface listPresenter{
            void getDataFromURL(Context context, String url);
        }

        interface Interactor{
            void initRetrofitCall(Context context,String url);
        }

        interface onGetDataListener{
            void onSuccess(String message,List<NewsRes> list);
            void onFailure(String message);
        }

}
