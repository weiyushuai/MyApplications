package com.example.wys.myapplication.util;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;

/**
 * Created by wys on 2016/4/21.
 */
public class HttpUtils {
    public static String WEB_USER_AGENT="";
    private static String uuid="e1994d5d-4a7f-4019-bf0d-1af7414d44b3";
    private static String imei="867064018293025";
    private static String ua=WEB_USER_AGENT+"KP_AUTH=UUID:"+ uuid +";IMEI:" + imei;
    /**
     * post带UA请求
     * @param url
     * @param paramsMap
     * @param callback
     */
    public static void postUa(String url, HashMap<String,String> paramsMap,StringCallback callback){
        OkHttpUtils.post().addHeader("User-Agent",ua).url(url).params(paramsMap).build().execute(callback);
    }
    /**
     * get带UA请求
     * @param url
     * @param paramsMap
     * @param callback
     */
    public static void get(String url, HashMap<String,String> paramsMap,StringCallback callback){
        OkHttpUtils.post().addHeader("User-Agent",ua).url(url).params(paramsMap).build().execute(callback);
    }
    public static void get(String url,StringCallback callback){
        OkHttpUtils.post().addHeader("User-Agent",ua).url(url).build().execute(callback);
    }
    /**
     * postUA请求
     * @param url
     * @param paramsMap
     * @param callback
     */
    public static void post(String url, HashMap<String,String> paramsMap, StringCallback callback){
        OkHttpUtils.post().url(url).params(paramsMap).build().execute(callback);
    }
    public static void post(String url,StringCallback callback){
        OkHttpUtils.post().url(url).build().execute(callback);
    }
    /**
     * 文件上传
     * @param name
     * @param fileName
     * @param file
     * @param callback
     */
    public static void postFile(String name,String fileName,File file,FileCallBack callback){
        OkHttpUtils.post().addFile(name,fileName,file).build().execute(callback);

    }



    public static String getUA(Context context) {
        WebView webView = new WebView(context);
        WebSettings websettings = webView.getSettings();

        String agent = websettings.getUserAgentString();
        String version ="1.0";
        String userAgent = agent + " " + "Android:KuaiPaiQR/Guanjia/" + version;
        return userAgent;
    }
}
