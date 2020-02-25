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

public class HomeAdapterfour extends RecyclerView.Adapter {
    private List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList;

    public HomeAdapterfour(List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_four_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(holder1.itemView.getContext()).load(hotGoodsList.get(position).getList_pic_url()).into(holder1.mHomeFourIv);
        holder1.mTvTitle.setText(hotGoodsList.get(position).getName());
        holder1.mTvBody.setText(hotGoodsList.get(position).getGoods_brief());
        holder1.mTvPric.setText("￥"+hotGoodsList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return hotGoodsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHomeFourIv;
        TextView mTvTitle;
        TextView mTvBody;
        TextView mTvPric;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mHomeFourIv = (ImageView) itemView.findViewById(R.id.home_four_iv);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mTvBody = (TextView) itemView.findViewById(R.id.tv_body);
            this.mTvPric = (TextView) itemView.findViewById(R.id.tv_pric);
        }
    }
}
