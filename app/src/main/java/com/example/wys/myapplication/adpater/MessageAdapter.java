package com.example.wys.myapplication.adpater;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wys.myapplication.R;

import java.util.List;

/**
 * Created by wys on 2016/5/11.
 */
public class MessageAdapter extends MyBaseAdapter {
    private Context ct;
    private List<Integer> list;
    public MessageAdapter(FragmentActivity activity, List<Integer> list) {
        super(activity,list);
        this.ct=activity;
        this.list=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(ct, R.layout.message_item,null);
            vh.iv_image= (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.iv_image.setBackgroundResource(list.get(position));
        return convertView;
    }
    private class ViewHolder{
        private ImageView iv_image;
    }
}
