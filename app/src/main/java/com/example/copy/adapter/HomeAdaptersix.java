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
import com.example.copy.bean.HomeBean;

import java.util.List;

public class HomeAdaptersix extends RecyclerView.Adapter {
    private List<HomeBean.DataBean.CategoryListBean.GoodsListBean> categoryList;

    public HomeAdaptersix(List<HomeBean.DataBean.CategoryListBean.GoodsListBean> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_six_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(viewHolder.itemView.getContext()).load(categoryList.get(position).getList_pic_url()).into(viewHolder.mHomeSixIv);
        viewHolder.mHomeSixTv1.setText(categoryList.get(position).getName());
        viewHolder.mHomeSixTv2.setText("￥" + categoryList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHomeSixIv;
        TextView mHomeSixTv1;
        TextView mHomeSixTv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mHomeSixIv = (ImageView) itemView.findViewById(R.id.home_six_iv);
            this.mHomeSixTv1 = (TextView) itemView.findViewById(R.id.home_six_tv1);
            this.mHomeSixTv2 = (TextView) itemView.findViewById(R.id.home_six_tv2);
        }
    }
}
