package com.zzl.cn.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by: zzl.
 * describe:
 * date: 2016/6/12.
 */
public class MyToast extends Toast {
    private static Toast toast;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public MyToast(Context context) {
        super(context);
    }

    /**
     * 推荐使用，去除重叠了的
     */
    public static android.widget.Toast makeText(CharSequence text,Context context, int duration) {
        if(toast == null){
            toast = makeText(context,text,duration);
        } else{
            toast.setText(text);
        }
        return toast ;
    }
    /**
     * 推荐使用，去除重叠了的
     */
    public static android.widget.Toast makeText(int resId,Context context, int duration) {
        if(toast == null){
            toast = makeText(context,resId,duration);
        } else{
            toast.setText(resId);
        }
        return toast ;
    }


}
