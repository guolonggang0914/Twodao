package com.bway.two.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bway.two.R;
import com.bway.two.model.bean.ItemMessage;
import com.bway.two.model.bean.RcData;
import com.bway.two.view.activity.NearbyActivity;
import com.bway.two.view.adapter.HomeRcAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 卢程
 * 2017/8/11.
 */

public class HomeFragmentVp2 extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.home_recycler_view)
    RecyclerView mRecyclerView;
    private String url;
    private List<RcData> mList;
    private ItemMessage itemMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        url = getArguments().getString("url");
        View view = inflater.inflate(R.layout.fragment_home_vp2, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList = new ArrayList<>();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            mList.add(new RcData());
        }
        HomeRcAdapter adapter = new HomeRcAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemListener(new HomeRcAdapter.OnItemListener() {
            @Override
            public void onItemLister(View view, int position) {
                Intent intent = new Intent(getContext(), NearbyActivity.class);
                RcData rcData = mList.get(position);
                if(itemMessage == null){
                    itemMessage = new ItemMessage();
                }
                Toast.makeText(getContext(),""+position, Toast.LENGTH_SHORT).show();
                itemMessage.setName("1504d" + position);
                Bundle bundle = new Bundle();
                bundle .putSerializable("home", itemMessage);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public static HomeFragmentVp2 getInstense(String url) {
        HomeFragmentVp2 homeFragmentVp = new HomeFragmentVp2();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        homeFragmentVp.setArguments(bundle);
        return homeFragmentVp;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
