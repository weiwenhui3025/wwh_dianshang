package com.example.copy.adapter;

import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.copy.R;
import com.example.copy.base.BaseAdapter;
import com.example.copy.bean.IndexBean;

import java.util.List;

public class ZtAdapter extends BaseAdapter {
    public ZtAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.cc_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.ccImg);
        TextView title = (TextView) holder.getView(R.id.ccTitle);
        TextView price = (TextView) holder.getView(R.id.ccPrice);
        IndexBean.DataBean.CategoryListBean.GoodsListBean list = (IndexBean.DataBean.CategoryListBean.GoodsListBean) this.list.get(position);
        Glide.with(context).load(list.getList_pic_url()).into(img);
        title.setText(list.getName());
        price.setText("￥"+(String) list.getRetail_price());
    }
}
