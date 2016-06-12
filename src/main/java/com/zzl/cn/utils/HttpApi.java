package com.zzl.cn.utils;

import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by: zzl.
 * describe:
 * date: 2016/6/12.
 */
public class HttpApi {
    public static void getApi(Context context, String url, StringCallback stringCallback) {
        OkHttpUtils.get()
                .addParams("name", "zzl")
        .addParams("pwd", "123")
        .build()
        .execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }
}
