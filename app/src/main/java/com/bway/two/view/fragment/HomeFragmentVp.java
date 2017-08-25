package com.bway.two.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bway.two.R;
import com.bway.two.model.bean.Foods;
import com.bway.two.model.bean.MostClass;
import com.bway.two.model.net.okhttp.HttpManager;
import com.bway.two.presenter.HomeListPresenter;
import com.bway.two.view.IMview.IMMain;
import com.bway.two.view.IMview.customcallback.EntityCallBack;
import com.bway.two.view.adapter.HomeGvAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.id.list;

/**
 * Created by 卢程
 * 2017/8/11.
 */

public class HomeFragmentVp extends Fragment implements IMMain<MostClass> {
    @BindView(R.id.fragment_home_gridview)
    GridView mGridview;
    Unbinder unbinder;
    private String url = "http://123.57.33.185:8088/listCategories";
    private int number;
    private HomeListPresenter presenter;
    private ArrayList<Foods> foodList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        number = getArguments().getInt("url");
        View view = inflater.inflate(R.layout.fragment_home_vp, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        Map<String,Object> map = new HashMap<>();
        map.put("type","10001");
        map.put("pageNum",number);
        presenter = new HomeListPresenter(this);
        presenter.LoadMostList(url, map);
    }

    private void initData() {
        foodList = new ArrayList<>();
    }

    public static HomeFragmentVp getInstense(int number) {
        HomeFragmentVp homeFragmentVp = new HomeFragmentVp();
        Bundle bundle = new Bundle();
        bundle.putInt("url", number);
        homeFragmentVp.setArguments(bundle);
        return homeFragmentVp;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSucceed(MostClass data) {
        List<MostClass.ObjectBean.ListBean> list = data.getObject().getList();
        for (int i = 0; i < list.size(); i++) {
            foodList.add(new Foods(list.get(i).getCategoryName(),list.get(i).getPicture()));
        }
        HomeGvAdapter homeGvAdapter = new HomeGvAdapter(foodList, getActivity());
        mGridview.setAdapter(homeGvAdapter);
    }

    @Override
    public void onError(int code, String err) {

    }
}
