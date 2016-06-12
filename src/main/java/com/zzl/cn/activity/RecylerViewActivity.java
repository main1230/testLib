package com.zzl.cn.activity;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.zzl.cn.R;
import com.zzl.cn.adapter.MainRvAdapter;
import com.zzl.cn.utils.SoundManager;


public class RecylerViewActivity extends Activity {
    private RecyclerView recyclerView;
    private MainRvAdapter mainRvAdapter;

    private String[] data_ = new String[]{"Java", "Python", "C", "C++", "C#", "PHP","Java", "Python",
            "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#",
            "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java",
            "Python", "C", "C++C++C++C++C++C++C++C++C++C++C++C++C++C++C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C",
            "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP",
            "Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python",
            "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#",
            "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python",
            "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++",
            "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP",
            "Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java",
            "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python",
            "C", "C++PythonPythonPythonPythonPythonPython", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++",
            "C#", "PHP","Java", "PythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPythonPython", "C", "C++", "C#", "PHP","Java", "Python", "C", "C++", "C#", "PHP",
            "Java", "Python", "C", "C++", "C#", "PHP", "重复数据"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
        initSoundPool();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        mainRvAdapter = new MainRvAdapter();
        mainRvAdapter.setData(data_);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainRvAdapter);
        mainRvAdapter.setOnItemClickListener(new MainRvAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int postion) {
                switch (postion % 6) {
                    case 5:
                        snd.play(laser);
                        break;
                    case 4:
                        snd.play(explode);
                        break;
                    case 3:
                        snd.play(pickup);
                        break;
                    case 2:
                        snd.play(meow);
                        break;
                    case 1:
                        snd.play(bark);
                        break;
                    default:
                        snd.play(moo);
                        break;
                }
            }
        });
    }



    SoundManager snd;
    int laser, explode, pickup, meow, bark, moo;
    private void initSoundPool() {
        snd = new SoundManager(getApplicationContext());

        // Set volume rocker mode to media volume
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Load the samples from res/raw
        laser = snd.load(R.raw.laser);
        explode = snd.load(R.raw.explosion);
        pickup = snd.load(R.raw.pickup);
        meow = snd.load(R.raw.cat);
        bark = snd.load(R.raw.barkloud);
        moo = snd.load(R.raw.cow);
    }
}
