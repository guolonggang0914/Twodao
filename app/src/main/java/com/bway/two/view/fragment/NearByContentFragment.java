package com.bway.two.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bway.two.R;
import com.bway.two.model.bean.NearbyMessage;
import com.bway.two.view.adapter.ContentItemdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 卢程
 * 2017/8/11.
 */

public class NearByContentFragment extends Fragment implements ContentItemdapter.ItemListener {

    Unbinder unbinder;
    @BindView(R.id.home_recycler_view)
    RecyclerView mRecyclerView;
    private String url = "http://123.57.33.185:8088/near/shops";
    private String values = "longitude=116.4192930000&latitude=39.9768360000&scope=5&categoryType=2&pageNum=1&categoryId=7";

    private List<NearbyMessage> messageList = new ArrayList<>();
    private ContentItemdapter adapter;
    private ViewPager vp;
    private LinearLayout linearLayout;
    private TextView txtName,txtAdr,txtJuli;

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
        initData();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            messageList.add(new NearbyMessage("小可爱西点"+i,45+i,25,100));
        }
        adapter = new ContentItemdapter(getActivity(),messageList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    public static NearByContentFragment getInstense(double longitude, double latitude, int categoryId) {
        NearByContentFragment homeFragmentVp = new NearByContentFragment();
        Bundle bundle = new Bundle();
        bundle.putDouble("longitude",longitude);
        bundle.putDouble("latitude",latitude);
        bundle.putInt("categoryId",categoryId);
        homeFragmentVp.setArguments(bundle);
        return homeFragmentVp;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public void setOnClickListener(ViewPager vp, LinearLayout linearLayout, TextView txtName, TextView txtAdr, TextView txtJuli){
        this.vp = vp;
        this.linearLayout = linearLayout;
        this.txtAdr = txtAdr;
        this.txtJuli = txtJuli;
        this.txtName = txtName;
    }
    @Override
    public void onItemListener(View view, int positon) {
        Toast.makeText(getActivity(),"--",Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getActivity(), NearbyActivity.class);
//        startActivity(intent);
//        getActivity().finish();
//        getActivity().finish();
        vp.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
        NearbyMessage nearbyMessage = messageList.get(positon);
        txtName.setText(nearbyMessage.getName());
        txtJuli.setText(nearbyMessage.getJuli()+"");


    }
}
