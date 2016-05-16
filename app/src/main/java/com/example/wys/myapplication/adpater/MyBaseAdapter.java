package com.example.wys.myapplication.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wys on 2016/5/11.
 */
public abstract class MyBaseAdapter extends BaseAdapter {
    private List<?> list;
    private Context ct;
    public MyBaseAdapter(Context ct,List<?> list) {
        this.list=list;
        this.ct=ct;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
