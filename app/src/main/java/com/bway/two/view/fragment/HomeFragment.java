package com.bway.two.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bway.two.R;
import com.bway.two.model.bean.ItemMessage;
import com.bway.two.model.bean.NearShopping;
import com.bway.two.presenter.HomeNearPresenter;
import com.bway.two.utils.ImageShowUtils.ImageUtils;
import com.bway.two.utils.ImageShowUtils.MyViewPager;
import com.bway.two.view.IMview.IMHome;
import com.bway.two.view.activity.CityCheckActivity;
import com.bway.two.view.activity.NearbyActivity;
import com.bway.two.view.adapter.HomeVpAdapter;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by 卢程
 * 2017/8/10.
 */

public class HomeFragment extends Fragment implements View.OnClickListener, IMHome {

    @BindView(R.id.fragment_home_search)
    LinearLayout mSearch;
    @BindView(R.id.fragment_home_xiaoxi)
    LinearLayout mXiaoxi;
    @BindView(R.id.fragment_home_saosao)
    LinearLayout mSaosao;
    @BindView(R.id.fragment_home_banner)
    Banner mBanner;
    @BindView(R.id.fragment_home_viewpager)
    ViewPager mViewpager;
    @BindView(R.id.fragment_home_fuli)
    LinearLayout mFuli;
    @BindView(R.id.fragment_home_dadao)
    LinearLayout mDadao;
    @BindView(R.id.nearby_map)
    ImageView nearbyMap;
    @BindView(R.id.fragment_home_viewpager2)
    MyViewPager mViewpager2;
    Unbinder unbinder;
    @BindView(R.id.fragment_home_tablayout)
    TabLayout mTablayout;
    @BindView(R.id.gv_rad1)
    RadioButton gvRad1;
    @BindView(R.id.gv_rad2)
    RadioButton gvRad2;
    @BindView(R.id.fragment_home_cityselector)
    TextView mCitySelector;
    @BindView(R.id.top_home)
    LinearLayout topHome;
    @BindView(R.id.nearby_sp1)
    ImageView nearbySp1;
    @BindView(R.id.nearby_name1)
    TextView nearbyName1;
    @BindView(R.id.nearby_txt1)
    TextView nearbyTxt1;
    @BindView(R.id.nearby_sp2)
    ImageView nearbySp2;
    @BindView(R.id.nearby_name2)
    TextView nearbyName2;
    @BindView(R.id.nearby_txt2)
    TextView nearbyTxt2;
    @BindView(R.id.nearby_sp3)
    ImageView nearbySp3;
    @BindView(R.id.nearby_name3)
    TextView nearbyName3;
    @BindView(R.id.nearby_txt3)
    TextView nearbyTxt3;
    private List<String> images;
    private List<Fragment> fragments;
    private List<Fragment> fragments2;
    private HomeVpAdapter vpAdapter;
    private PopupWindow window;
    private String nearUrl = "http://123.57.33.185:8088/listRecommendPositions";
    private Intent intent;
    private NearShopping o1;
    private ItemMessage item ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        loadBanner();
        loadViewpager();
        loadNear();
        loadTabView();
    }

    private void loadNear() {
        HomeNearPresenter nearPresenter = new HomeNearPresenter(this);
        Map<String, Object> map = new HashMap<>();
        map.put("type", 1);
        nearPresenter.LoadMessage(nearUrl,map);
    }

    /**
     * 加载底层tablayout + viewpager
     */
    private void loadTabView() {
        for (int i = 0; i < 5; i++) {
            fragments2.add(HomeFragmentVp2.getInstense("" + i));
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        mViewpager2.setAdapter(adapter);

        //TabLayout
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTablayout.setupWithViewPager(mViewpager2);
    }

    /**
     * 加载中间viewpager，内部Gridview
     */
    private void loadViewpager() {
        fragments.add(HomeFragmentVp.getInstense(1));
        fragments.add(HomeFragmentVp.getInstense(2));
        vpAdapter = new HomeVpAdapter(getActivity().getSupportFragmentManager(), fragments);
        mViewpager.setAdapter(vpAdapter);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    gvRad1.setBackgroundResource(R.drawable.myuan);
                    gvRad2.setBackgroundResource(R.drawable.nyuan);
                }
                if (position == 1) {
                    gvRad2.setBackgroundResource(R.drawable.myuan);
                    gvRad1.setBackgroundResource(R.drawable.nyuan);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initView() {
        images = new ArrayList<>();
        fragments = new ArrayList<>();
        fragments2 = new ArrayList<>();
    }

    private void loadBanner() {

        images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1931850890,4215733472&fm=26&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=25113326,1226603612&fm=26&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2710680424,3876257908&fm=26&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=809943721,3434341815&fm=26&gp=0.jpg");

        mBanner.setImageLoader(new GlideImagerloader());
        mBanner.setImages(images);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragment_home_search,
            R.id.fragment_home_cityselector,
            R.id.fragment_home_xiaoxi,
            R.id.fragment_home_saosao,
            R.id.fragment_home_fuli,
            R.id.fragment_home_dadao,
            R.id.nearby_sp1,
            R.id.nearby_sp2,
            R.id.nearby_sp3,
            R.id.nearby_map})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_cityselector:
                intent = new Intent(getContext(), CityCheckActivity.class);
                startActivityForResult(intent, 366);
                break;
            case R.id.fragment_home_search:
                break;
            case R.id.fragment_home_xiaoxi:
                break;
            case R.id.fragment_home_saosao:
                showPopwindow(view);
                break;
            case R.id.fragment_home_fuli:
                break;
            case R.id.fragment_home_dadao:
                break;
            case R.id.nearby_map:
                break;
            case R.id.nearby_sp1:
                intent = new Intent(getContext(), NearbyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("hoem", NearShopping.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.nearby_sp2:
                intent= new Intent(getContext(), NearbyActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("hoem", NearShopping.class);
                intent.putExtras(bundle2);
                startActivity(intent);
                break;
            case R.id.nearby_sp3:
                intent = new Intent(getContext(), NearbyActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("hoem", NearShopping.class);
                intent.putExtras(bundle3);
                startActivity(intent);
                break;
        }
    }

    private void showPopwindow(View view) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.home_popwindow, null);
        if (window == null) {
            window = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, true);
        }
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        window.showAsDropDown(topHome, width - inflate.getWidth(), 10);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE && !window.isFocusable()) {
                    window.dismiss();
                    return true;
                }
                return false;
            }
        });
        LinearLayout scan = inflate.findViewById(R.id.home_pop_sao);
        LinearLayout pay = inflate.findViewById(R.id.home_pop_pay);
        scan.setOnClickListener(this);
        pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_pop_sao:
                window.dismiss();
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.home_pop_pay:
                Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                window.dismiss();
                break;
        }
    }

    @Override
    public void onSuccess(Object o, int code) {
        if(code == 0){
            NearShopping o1 = (NearShopping) o;
            List<NearShopping.ObjectBean.ListBean> list = o1.getObject().getList();
            ImageUtils.newInstance().YuanjiaoImage(getContext(),list.get(0).getPicture(),nearbySp1);
            ImageUtils.newInstance().YuanjiaoImage(getContext(),list.get(1).getPicture(),nearbySp2);
            ImageUtils.newInstance().YuanjiaoImage(getContext(),list.get(2).getPicture(),nearbySp3);
        }
        if(code == 1){
            item = new ItemMessage();

        }
    }

    @Override
    public void onError(int code, String str) {

    }


    class GlideImagerloader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public final int COUNT = 5;
        private String[] titles = new String[]{"美食", "休闲娱乐", "生活服务", "酒店", "全部"};

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments2.get(position);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 366) {
            Log.e("=====", "onActivityResult: " + 111);
            String city = data.getStringExtra("city");
            if (city != null) {
                mCitySelector.setText(city);
            }
        }
        if (resultCode == RESULT_OK && requestCode == 0) {
            Bundle extras = data.getExtras();
            String result = extras.getString("result");
            Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
        }
    }
}
