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

public class HomeAdaptertwo extends RecyclerView.Adapter {
    private List<HomeBean.DataBean.BrandListBean> brandList;

    public HomeAdaptertwo(List<HomeBean.DataBean.BrandListBean> brandList) {
        this.brandList = brandList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_two_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(holder1.itemView.getContext()).load(brandList.get(position).getNew_pic_url()).into(holder1.mHomrRec1Iv);
        holder1.mHomeRec1Text1.setText(brandList.get(position).getName());
        holder1.mHomeRec1Text2.setText(brandList.get(position).getFloor_price()+"元起");
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHomrRec1Iv;
        TextView mHomeRec1Text1;
        TextView mHomeRec1Text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mHomrRec1Iv = (ImageView) itemView.findViewById(R.id.homr_rec1_iv);
            this.mHomeRec1Text1 = (TextView) itemView.findViewById(R.id.home_rec1_text1);
            this.mHomeRec1Text2 = (TextView) itemView.findViewById(R.id.home_rec1_text2);
        }
    }
}
