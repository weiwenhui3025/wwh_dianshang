package com.example.copy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.copy.R;
import com.example.copy.base.BaseAdapter;
import com.example.copy.bean.IndexBean;

import java.util.List;

public class ZhuanTiAdapter extends BaseAdapter {
    public ZhuanTiAdapter(List list) {
        super(list);
    }

    @Override
    protected int getLayout() {
        return R.layout.zhuanti_adapter;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object o) {
        ImageView img = (ImageView) holder.getView(R.id.zhuantiImg);
        TextView subtitle = (TextView) holder.getView(R.id.zhuantiSubtitle);
        TextView title = (TextView) holder.getView(R.id.zhuantiTitle);
        TextView price = (TextView) holder.getView(R.id.zhuantiPrice);
        price.setText("0元起");
        IndexBean.DataBean.TopicListBean zhuantiList = (IndexBean.DataBean.TopicListBean) list.get(position);
        subtitle.setText(zhuantiList.getSubtitle());
        title.setText(zhuantiList.getTitle());
        Glide.with(context).load(zhuantiList.getItem_pic_url()).into(img);
    }
}
