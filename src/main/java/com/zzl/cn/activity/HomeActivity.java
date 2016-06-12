package com.zzl.cn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zhy.http.okhttp.callback.StringCallback;
import com.zzl.cn.R;
import com.zzl.cn.adapter.HomeAdapter;
import com.zzl.cn.utils.HttpApi;
import com.zzl.cn.widget.MyToast;

import okhttp3.Call;

/**
 * Description:
 * Created by zhangzl
 * Date: 15/7/21
 */
public class HomeActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;

    private String[] data_ = {"RecylerView", "Java", "PHP", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initUI() {
        setContentView(R.layout.activity_homt);

        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        homeAdapter = new HomeAdapter();
        homeAdapter.setData(data_);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                // 点击事件处理
                //showToastMsg(data_[position]);
                dealClickListener(position);
            }
        });
    }

    private void dealClickListener(int position) {
        switch (position) {
            default:
//                Intent intent = new Intent(HomeActivity.this, RecylerViewActivity.class);
//                startActivity(intent);
                HttpApi.getApi(HomeActivity.this, "http://www.baidu.com", new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        MyToast.makeText(HomeActivity.this, "失敗："+id+e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        MyToast.makeText(HomeActivity.this, "成功："+response.substring(0, 10), Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }
}
