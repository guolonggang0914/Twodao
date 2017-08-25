package com.bway.two.presenter;

import com.bway.two.model.bean.MostClass;
import com.bway.two.model.net.okhttp.HttpManager;
import com.bway.two.view.IMview.IMMain;
import com.bway.two.view.IMview.customcallback.EntityCallBack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 卢程
 * 2017/8/16.
 */

public class HomeListPresenter {

    private IMMain imMain;

    public HomeListPresenter(IMMain imMain) {
        this.imMain = imMain;
    }

    public void LoadMostList(String url, Map<String, Object> map){
        HttpManager.getInstance().post(url, map, new EntityCallBack<MostClass>() {
            @Override
            public void onSuccess(MostClass o) {
                imMain.onSucceed(o);
            }

            @Override
            public void onFailure(String message, int error) {

            }
        });
    }
}
