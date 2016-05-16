package com.example.wys.myapplication.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.wys.myapplication.Fragment.HomeFragment;
import com.example.wys.myapplication.Fragment.MessageFragment;
import com.example.wys.myapplication.Fragment.MyFragment;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.adpater.SlidingMenuAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class Main2Activity extends BaseTitleBarActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.radio_group)
    RadioGroup radio_group;
    @Bind(R.id.list_view)
    ListView list_view;
    private Fragment homeFragment;
    private Fragment myFragment;
    private Fragment msgFragment;
    private List<String> listMenu=new ArrayList<>();
    @Override
    protected void initView() {
        replaceFragment(new HomeFragment());
        setClick();
        initAdapter();

    }
    private SlidingMenuAdapter menuAdapter;
    private void initAdapter() {
        for (int i=0;i<6;i++){
            listMenu.add("菜单"+i);
        }
        if (menuAdapter!=null){
            menuAdapter.notifyDataSetChanged();
        }else {
            menuAdapter=new SlidingMenuAdapter(ct,listMenu);
            list_view.setAdapter(menuAdapter);
        }
    }

    private void setClick() {
        radio_group.setOnCheckedChangeListener(this);
    }


    @Override
    protected void setView() {
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    replaceFragment(homeFragment);
                } else {
                    replaceFragment(homeFragment);
                }
                break;
            case R.id.rb_hot:
                if (msgFragment == null) {
                    msgFragment = new MessageFragment();
                    replaceFragment(msgFragment);
                } else {
                    replaceFragment(msgFragment);
                }
                break;
            case R.id.rb_my:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    replaceFragment(myFragment);
                } else {
                    replaceFragment(myFragment);
                }
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
    }
}
