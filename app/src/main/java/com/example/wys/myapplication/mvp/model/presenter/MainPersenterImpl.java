package com.example.wys.myapplication.mvp.model.presenter;

import com.example.wys.myapplication.mvp.model.model.MainModel;
import com.example.wys.myapplication.mvp.model.model.MainModelBean;
import com.example.wys.myapplication.mvp.model.view.MainView;

/**
 * Created by wys on 2016/5/13.
 */
public class MainPersenterImpl implements IMainPersenter {
    MainView mainView;
    MainModel mainModel;

    public MainPersenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModel(this);
    }

    public void loadData() {
        mainModel.fillData();
    }

    @Override
    public void loadSuccess(MainModelBean.WeatherinfoBean modelBean) {
        mainView.showData(modelBean);

    }
}
