package com.bway.two.presenter;

import com.bway.two.model.bean.NearShopping;
import com.bway.two.model.net.okhttp.HttpManager;
import com.bway.two.view.IMview.IMHome;
import com.bway.two.view.IMview.customcallback.EntityCallBack;

import java.util.Map;

/**
 * Created by 卢程
 * 2017/8/24.
 */

public class HomeNearPresenter {

    private IMHome imHome;

    public HomeNearPresenter(IMHome imHome) {
        this.imHome = imHome;
    }

    public void LoadMessage(String url, Map<String, Object> map){
        HttpManager.getInstance().post(url, map, new EntityCallBack<NearShopping>() {
            @Override
            public void onSuccess(NearShopping ns) {
                imHome.onSuccess(ns,0);
            }

            @Override
            public void onFailure(String message, int error) {
                imHome.onError(error,message);
            }
        });
    }
}
