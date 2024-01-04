package com.easy.demo.net.easy;

import android.app.Application;
import android.content.Context;

/**
 * Created by huzeyin on 2018/3/27.
 */

public class FanAppContext {

    private static Context mContext;
    private static Application mApplication;

    public static void init(Context context, Application application) {
        mContext = context;
        mApplication = application;
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static Application getApplication() {
        return mApplication;
    }

}
