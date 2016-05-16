package com.example.wys.myapplication.widget;

/**
 * Created by wys on 2016/4/14.
 */
public interface IDrawerPresenter {
    IDrawerPresenter getInstance();
    void dispatchEvent(int totalPages, int currentPage);
}
