package com.bway.two.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bway.two.R;
import com.bway.two.model.base.BaseActivity;
import com.bway.two.model.bean.KaBean;

import java.util.List;

/**
 * @类的用途:
 * @姓名: 张惠行
 * @date 2017/8/15
 */

public class KaListAdapter extends BaseAdapter {
    private Context context;
    private List<KaBean> mList;

    public KaListAdapter(Context context, List<KaBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View contextView, ViewGroup viewGroup) {
     Holder holder;
        if (contextView==null) {
            contextView = contextView.inflate(context, R.layout.ka_item, null);
            holder = new Holder();
            holder.imageView = contextView.findViewById(R.id.ka_item_image);
            holder.name = contextView.findViewById(R.id.ka_item_name);
            holder.bangding = contextView.findViewById(R.id.ka_item_bangding);

            contextView.setTag(holder);
        }else{
            holder = (Holder) contextView.getTag();
        }
        holder.name.setText(mList.get(position).getName());
        holder.bangding.setText(mList.get(position).getBangding());
        Glide.with(context).load(mList.get(position).getImage()).into(holder.imageView);
        return contextView;
    }
    class Holder{
        ImageView  imageView;
        TextView  name;
        TextView  bangding;
    }
}
