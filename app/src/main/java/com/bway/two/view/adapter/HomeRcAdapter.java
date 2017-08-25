package com.bway.two.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bway.two.R;
import com.bway.two.model.bean.RcData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 卢程
 * 2017/8/12.
 */

public class HomeRcAdapter extends RecyclerView.Adapter<HomeRcAdapter.ViewHolder> {


    private Context context;
    private List<RcData> mList;
    private OnItemListener onItemListener;
    private View view;

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public HomeRcAdapter(Context context, List<RcData> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.fragment_home_rcitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.homeRcJifen.setText("" + (15 + position) +"%");
        holder.homeRcMoney.setText("￥"+ (45 + position) + "/人");
        holder.homeRcTitle.setText("味多美（安贞店）");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_rc_head)
        ImageView homeRcHead;
        @BindView(R.id.home_rc_title)
        TextView homeRcTitle;
        @BindView(R.id.home_rc_money)
        TextView homeRcMoney;
        @BindView(R.id.home_rc_jifen)
        TextView homeRcJifen;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemListener.onItemLister(view, (Integer) view.getTag());
                }
            });
        }
    }

    public interface OnItemListener{
        void onItemLister(View view, int position);
    }
}
