package com.example.myapplication;

import android.app.Application;

/**
 * Created by zhanglongping on 18/12/25.
 */
public class OauthDemoApplication extends Application {

    private static OauthDemoApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static OauthDemoApplication getInstance() {
        return instance;
    }
}
