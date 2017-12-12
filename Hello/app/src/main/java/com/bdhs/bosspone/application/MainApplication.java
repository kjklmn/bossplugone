package com.bdhs.bosspone.application;


import android.app.Application;

/**
 * 项目名称：BossApp
 * 类描述：
 * 创建人：kejian
 * 创建时间：2017-12-02 17:52
 * 修改人：Administrator
 * 修改时间：2017-12-02 17:52
 * 修改备注：
 */
public class MainApplication extends Application {

    public boolean isDebug;
    public String APP_NAME;
    private static MainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MainApplication getInstance() {
        return instance;
    }
}
