package com.example.wys.myapplication.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.util.HttpUtils;
import com.example.wys.myapplication.util.T;
import com.example.wys.myapplication.widget.StateRoundRectDrawable;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

public class ListActivity extends BaseTitleBarActivity {
    @Bind(R.id.list_view)
    GridView list_view;
    MyAdapter adapter;
    private List<String> list = new ArrayList<>();
    public static String getUA(Context context) {
        WebView webView = new WebView(context);
        WebSettings websettings = webView.getSettings();

        String agent = websettings.getUserAgentString();
        String version ="1.0";
        String userAgent = agent + " " + "Android:KuaiPaiQR/Guanjia/" + version;
        return userAgent;
    }
    @Override
    protected void initView(){
        final String url="http://guansir.kuaipai.cn/support/api/kuaipai/label/detail.do";
//        final String url="http://guansir.kuaipai.cn/support/api/kuaipai/label/me.do";

        HashMap<String,String> paramsMap=new HashMap<>();
        paramsMap.put("id","51609");
        paramsMap.put("barcode","6901294300187");
        HttpUtils.postUa(url, paramsMap, new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                Log.d("debug","onError:" + e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Log.d("debug",response);
            }
        });

        initColor();
        for (int i = 0; i < 10; i++) {
            list.add("条目" + i);
        }
        adapter = new MyAdapter();
//        CommonAdapter<String> adapter=new CommonAdapter<String>(ct,R.layout.list_item,list) {
//            @Override
//            public void convert(final ViewHolder holder, String s) {
//                Button btn_add=holder.getView(R.id.btn_add);
//                Button btn_reduce=holder.getView(R.id.btn_reduce);
//                final TextView tv_num=holder.getView(R.id.tv_num);
//                TextView tv_title=holder.getView(R.id.tv_title);
//                btn_add.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int count=Integer.valueOf(tv_num.getText().toString());
//                        tv_num.setText(String.valueOf(++count));
//                    }
//                });
//
//                btn_reduce.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int count=Integer.valueOf(tv_num.getText().toString());
//                        if (count>0){
//                            tv_num.setText(String.valueOf(--count));
//                        }else {
//                            T.s(ct,"数量不能小于0");
//                        }
//
//                    }
//                });
//                tv_title.setText(s);
//            }
//        };
        list_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private ArrayList<String> colors;
    private void initColor() {
        colors = new ArrayList<String>();
        colors.add("#a1d989");
        colors.add("#78d699");
        colors.add("#6dd6c6");
        colors.add("#6dbcd6");
        colors.add("#6498d7");
        colors.add("#a582f4");
        colors.add("#e5acff");
        colors.add("#fc8ad3");
        colors.add("#fa94aa");
        colors.add("#f3b1b1");
        colors.add("#fbbe96");
        colors.add("#f9d170");
        Collections.shuffle(colors);
    }

    private StateListDrawable generateDrawable(int position) {
        if (position >= colors.size()) {
            position %= colors.size();
        }
        int color = Color.parseColor(colors.get(position));
        int pressColor = Color.argb(128, Color.red(color), Color.green(color), Color.blue(color));
        return new StateRoundRectDrawable(color, pressColor);
    }
    @Override
    protected void setView() {
        setContentView(R.layout.activity_list);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder vh;

            if (convertView == null) {
                convertView = View.inflate(ct, R.layout.list_item, null);
                vh = new ViewHolder();
                vh.btn_add = (Button) convertView.findViewById(R.id.btn_add);
                vh.btn_reduce = (Button) convertView.findViewById(R.id.btn_reduce);
                vh.tv_num = (EditText) convertView.findViewById(R.id.tv_num);
                vh.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
                vh.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count=Integer.valueOf(vh.tv_num.getText().toString());
                    vh.tv_num.setText(String.valueOf(++count));
                }
            });
            vh.btn_reduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count=Integer.valueOf(vh.tv_num.getText().toString());
                    if (count>0){
                        vh.tv_num.setText(String.valueOf(--count));
                    }else {
                        T.s(ct,"数量不能小于0");
                    }

                }
            });
            vh.tv_title.setText(list.get(position));
            vh.linearLayout.setBackgroundDrawable(generateDrawable(position));
            return convertView;
        }

        private class ViewHolder {
            EditText tv_num;
            TextView tv_title;
            Button btn_add;
            Button btn_reduce;
            LinearLayout linearLayout;
        }
    }

}
