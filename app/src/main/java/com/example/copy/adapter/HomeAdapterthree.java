package com.example.copy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.copy.R;
import com.example.copy.adapter.HomeAdapterthree.ViewHolder;
import com.example.copy.bean.HomeBean;

import java.util.List;

public class HomeAdapterthree extends RecyclerView.Adapter {
    private List<HomeBean.DataBean.NewGoodsListBean> newGoodsList;

    public HomeAdapterthree(List<HomeBean.DataBean.NewGoodsListBean> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_three_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(viewHolder.itemView.getContext()).load(newGoodsList.get(position).getList_pic_url()).into(viewHolder.mHomeThreeIv);
        viewHolder.mHomeThreeTv1.setText(newGoodsList.get(position).getName());
        viewHolder.mHomeThreeTv2.setText("￥"+newGoodsList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return newGoodsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHomeThreeIv;
        TextView mHomeThreeTv1;
        TextView mHomeThreeTv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mHomeThreeIv = (ImageView) itemView.findViewById(R.id.home_three_iv);
            this.mHomeThreeTv1 = (TextView) itemView.findViewById(R.id.home_three_tv1);
            this.mHomeThreeTv2 = (TextView) itemView.findViewById(R.id.home_three_tv2);
        }


    }
}
