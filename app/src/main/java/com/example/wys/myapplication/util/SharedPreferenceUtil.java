package com.example.wys.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wys.myapplication.Conf.Conf;

/**
 * Created by wys on 2016/4/14.
 */
public class SharedPreferenceUtil {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static SharedPreferenceUtil instance;

    public static SharedPreferenceUtil getInstance(Context ct) {
        if (instance == null) {
            synchronized (SharedPreferenceUtil.class) {
                if (instance == null) {
                    instance = new SharedPreferenceUtil(ct, Conf.SP_NAME);
                }
            }
        }
        return instance;
    }

    private SharedPreferenceUtil(Context ct, String file) {
        sp = ct.getSharedPreferences(file, Context.MODE_APPEND);
        editor = sp.edit();
    }

    public void setLogin(boolean isLogin){
        editor.putBoolean("is_login",isLogin);
        editor.commit();
    }

    public boolean getLogin(){
        return sp.getBoolean("is_login",true);
    }

    public void setFirst(boolean isFirst){
        editor.putBoolean("isFirst",isFirst);
        editor.commit();
    }

    public boolean getFirst(){
        return sp.getBoolean("isFirst",true);
    }
}
