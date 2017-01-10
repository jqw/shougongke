package com.example.jiangqiangwei.myshougongke.app;

import android.app.Application;

/**
 * Created by jiangqiangwei on 16/12/27.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }
}
