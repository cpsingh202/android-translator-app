package com.assignment.android.translatorapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

public class BaseApp extends Application {

    public static LocaleManager localeManager;

    @Override
    protected void attachBaseContext(Context base) {
        localeManager = new LocaleManager(base);
        super.attachBaseContext(localeManager.setLocale(base));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.extractLanguageData(getApplicationContext());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
    }
}