package com.example.wys.myapplication.mvp.model.model;

import android.provider.Settings;
import android.util.Log;

import com.example.wys.myapplication.mvp.model.presenter.IMainPersenter;
import com.example.wys.myapplication.util.HttpUtils;
import com.example.wys.myapplication.util.T;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wys on 2016/5/13.
 */
public class MainModel {
    IMainPersenter iMainPersenter;

    public MainModel(IMainPersenter iMainPersenter) {
        this.iMainPersenter=iMainPersenter;
    }

    public void fillData(){
        String url="http://www.weather.com.cn/adat/sk/101010100.html";
        OkHttpUtils.get().url(url).build().buildCall(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                System.out.print("天气是::::"+response);
                Log.d("debug",response);
            }
        });
//        HttpUtils.post(url,new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//                System.out.print("天气是::::"+response);
//                Log.d("debug",response);
////                 Gson gson=new Gson();
////                MainModelBean.WeatherinfoBean modelBean=gson.fromJson(response,MainModelBean.WeatherinfoBean.class);
////                modelBean.setCity(modelBean.getCity());
////                modelBean.setWD(modelBean.getCity());
////                modelBean.setWS(modelBean.getCity());
////                modelBean.setTime(modelBean.getCity());
////                iMainPersenter.loadSuccess(modelBean);
//            }
//        });

    }

}
