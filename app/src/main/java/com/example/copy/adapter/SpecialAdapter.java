package com.example.copy.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.copy.R;
import com.example.copy.bean.SpecialBean;

import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter {
    private List<SpecialBean.DataBeanX.DataBean> list;
    private boolean iscoumn;

    public SpecialAdapter(List<SpecialBean.DataBeanX.DataBean> list, boolean iscoumn) {
        this.list = list;
        this.iscoumn = iscoumn;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_layout, null);
        } else if (viewType==1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.up_down_layout, null);
        }
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;


        if (position==10){}else {
            if (list.size() > 0) {
                if (iscoumn) {
                    Glide.with(holder1.itemView).load(list.get(position).getScene_pic_url()).into(holder1.mSpecialIv);
                    holder1.mSpecialBody.setText(list.get(position).getSubtitle());
                    holder1.mSpecialName.setText(list.get(position).getTitle());
                    holder1.mSpecialPric.setText(list.get(position).getPrice_info() + "元起");
                } else {
                    Glide.with(holder1.itemView).load(list.get(position + 10).getScene_pic_url()).into(holder1.mSpecialIv);
                    holder1.mSpecialBody.setText(list.get(position + 10).getSubtitle());
                    holder1.mSpecialName.setText(list.get(position + 10).getTitle());
                    holder1.mSpecialPric.setText(list.get(position + 10).getPrice_info() + "元起");
                }
        }

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 10) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mSpecialIv;
        TextView mSpecialName;
        TextView mSpecialBody;
        TextView mSpecialPric;
        TextView mUpTv;
        TextView mDownTv;
        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if (viewType==0){
                this.mSpecialIv = (ImageView) itemView.findViewById(R.id.special_iv);
                this.mSpecialName = (TextView) itemView.findViewById(R.id.special_name);
                this.mSpecialBody = (TextView) itemView.findViewById(R.id.special_body);
                this.mSpecialPric = (TextView) itemView.findViewById(R.id.special_pric);
            }else {
                this.mUpTv = (TextView) itemView.findViewById(R.id.up_tv);
                this.mDownTv = (TextView) itemView.findViewById(R.id.down_tv);
                mUpTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mUpTv.setTextColor(Color.GRAY);
                        mDownTv.setTextColor(Color.BLACK);
                        if (data!=null){
                            data.onData(1);
                        }
                    }
                });
                mDownTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mUpTv.setTextColor(Color.BLACK);
                        mDownTv.setTextColor(Color.GRAY);
                        if (data!=null){
                            data.onData(2);
                        }
                    }
                });
            }

        }
    }
    public interface Data{
        void onData(int page);
    }
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }
}
