package com.bway.two.model.application;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.baidu.mapapi.SDKInitializer;
import com.bway.two.model.net.okhttp.HttpManager;
import com.bway.two.model.net.okhttp.OkhttpEnginen;

/**
 * autor: 李金涛.
 * date:2017/8/9
 */


public class MainApplication extends Application {
    private static MainApplication mApplication;
    private String token,userName,userPhone;
    private boolean isLogin;
    private SharedPreferences mSp;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
        mSp.edit().putBoolean("isLogin",login).commit();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        mSp.edit().putString("token",token).commit();
    }
    public static MainApplication getInstence(){
        return mApplication;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        mSp.edit().putString("userName",userName).commit();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
        mSp.edit().putString("userPhone",userPhone).commit();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initManager();
        SDKInitializer.initialize(getApplicationContext());
        mApplication = this;
//        x.Ext.init(this);
//        x.Ext.setDebug(BuildConfig.DEBUG);
        mSp = getSharedPreferences("config", MODE_PRIVATE);
        token = mSp.getString("token","");
        isLogin = mSp.getBoolean("isLogin",false);
    }

    private void initManager() {
        HttpManager.getInstance().init(new OkhttpEnginen());
    }
}
