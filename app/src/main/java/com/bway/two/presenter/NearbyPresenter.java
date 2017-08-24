package com.bway.two.presenter;

import android.content.Context;

import com.bway.two.model.bean.TuijianData;
import com.bway.two.model.net.okhttp.HttpManager;
import com.bway.two.view.IMview.IMNearby;
import com.bway.two.view.IMview.customcallback.EntityCallBack;

import java.util.Map;

/**
 * autor: 李金涛.
 * date:2017/8/16
 */


public class NearbyPresenter {

    private IMNearby imNearby;
    private Context context;
    public NearbyPresenter(Context context) {
        this.context = context;
    }

    public void attachPresenter(IMNearby imNearby){
        this.imNearby = imNearby;
    }
    public void detachPresenter(IMNearby imNearby){
        if(imNearby!=null){
            imNearby = null;
        }
    }

    public void loadUrlBypost(String url, Map<String,Object> map){
        HttpManager.getInstance().post(url, map, new EntityCallBack<TuijianData>() {

            @Override
            public void onSuccess(TuijianData tuijianData) {
                imNearby.onSucceed(tuijianData);
            }

            @Override
            public void onFailure(String message, int error) {
                imNearby.onError(error,message);
            }
        });

    }




}
