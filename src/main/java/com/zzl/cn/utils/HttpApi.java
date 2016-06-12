package com.zzl.cn.utils;

import android.content.Context;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzl.cn.widget.MyToast;

import okhttp3.Call;

/**
 * Created by: zzl.
 * describe:
 * date: 2016/6/12.
 */
public class HttpApi {
    public static void getApi(final Context context, String url, StringCallback stringCallback) {
        OkHttpUtils.get()
                .url(url)
                .addParams("name", "zzl")
        .build()
        .execute(stringCallback);
    }
}
