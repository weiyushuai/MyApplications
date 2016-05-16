package com.example.wys.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wys.myapplication.Base.BaseFragment;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.adpater.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends BaseFragment {
    private ListView list_view;
    private List<Integer> list=new ArrayList<>();
    private MessageAdapter msgAdapter;

    @Override
    protected View setView(FragmentActivity activity) {
        View view=View.inflate(getActivity(),R.layout.activity_message_fragment,null);
        list_view= (ListView) view.findViewById(R.id.list_view);
        initData();
        return view;
    }

    private void initData() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                list.add(R.mipmap.fore);
            }else{
                list.add(R.mipmap.welcome1);
            }
        }
        msgAdapter=new MessageAdapter(getActivity(),list);
        list_view.setAdapter(msgAdapter);
    }
}
