package com.example.copy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.copy.R;
import com.example.copy.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapterBig extends RecyclerView.Adapter {
    private List<HomeBean.DataBean.BannerBean> banner;
    private List<HomeBean.DataBean.ChannelBean> channel;
    private List<HomeBean.DataBean.NewGoodsListBean> newGoodsList;
    private List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList;
    private List<HomeBean.DataBean.BrandListBean> brandList;
    private List<HomeBean.DataBean.TopicListBean> topicList;
    private List<HomeBean.DataBean.CategoryListBean> categoryList;
    private Context context;

    public HomeAdapterBig(List<HomeBean.DataBean.BannerBean> banner, List<HomeBean.DataBean.ChannelBean> channel, List<HomeBean.DataBean.NewGoodsListBean> newGoodsList, List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList, List<HomeBean.DataBean.BrandListBean> brandList, List<HomeBean.DataBean.TopicListBean> topicList, List<HomeBean.DataBean.CategoryListBean> categoryList) {
        this.banner = banner;
        this.channel = channel;
        this.newGoodsList = newGoodsList;
        this.hotGoodsList = hotGoodsList;
        this.brandList = brandList;
        this.topicList = topicList;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_home, null);
        } else if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_two, null);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_three, null);
        } else if (viewType == 3) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_four, null);
        } else if (viewType == 4) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_five, null);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_six, null);
        }
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        int viewType = getItemViewType(position);
        if (viewType == 0) {
            List<String> banns = new ArrayList<>();
            for (int i = 0; i < banner.size(); i++) {
                banns.add(banner.get(i).getImage_url());
            }
            holder1.mHomeBan.setImages(banns).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();

        } else if (viewType == 1) {
            holder1.mHomeTwoRecy.setLayoutManager(new GridLayoutManager(context, 2));
            holder1.mHomeTwoRecy.setAdapter(new HomeAdaptertwo(brandList));
        } else if (viewType == 2) {
            holder1.mHomeThreeRecy.setLayoutManager(new GridLayoutManager(context, 2));
            holder1.mHomeThreeRecy.setAdapter(new HomeAdapterthree(newGoodsList));
        } else if (viewType == 3) {
            holder1.mHomeFourRecy.setLayoutManager(new LinearLayoutManager(context));
            holder1.mHomeFourRecy.setAdapter(new HomeAdapterfour(hotGoodsList));

        } else if (viewType == 4) {
            if (topicList.size()>0){
                Glide.with(holder1.itemView.getContext()).load(topicList.get(0).getItem_pic_url()).into(holder1.mHomeFiveIv1);
                Glide.with(holder1.itemView.getContext()).load(topicList.get(1).getItem_pic_url()).into(holder1.mHomeFiveIv2);
                Glide.with(holder1.itemView.getContext()).load(topicList.get(2).getItem_pic_url()).into(holder1.mHomeFiveIv3);
                holder1.mHomeFiveTvtitle1.setText(topicList.get(0).getTitle());
                holder1.mHomeFiveTvtitle2.setText(topicList.get(1).getTitle());
                holder1.mHomeFiveTvtitle3.setText(topicList.get(2).getTitle());
                holder1.mHomeFiveTvPric1.setText("￥" + topicList.get(0).getPrice_info() + "元起");
                holder1.mHomeFiveTvPric2.setText("￥" + topicList.get(1).getPrice_info() + "元起");
                holder1.mHomeFiveTvPric3.setText("￥" + topicList.get(2).getPrice_info() + "元起");
                holder1.mHomeFiveTvBody.setText(topicList.get(0).getSubtitle());
                holder1.mHomeFiveTvBody2.setText(topicList.get(1).getSubtitle());
                holder1.mHomeFiveTvBody3.setText(topicList.get(2).getSubtitle());
            }
        } else {
            holder1.mHomeSixTitle.setText(categoryList.get(position-5).getName());
            holder1.mRecySix.setLayoutManager(new GridLayoutManager(context, 2));
            holder1.mRecySix.setAdapter(new HomeAdaptersix(categoryList.get(position-5).getGoodsList()));
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size()+5;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        }
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Banner mHomeBan;
        TextView mTv1;
        TextView mTv2;
        TextView mTv3;
        TextView mTv4;
        TextView mTv5;
        RecyclerView mHomeTwoRecy;
        RecyclerView mHomeThreeRecy;
        RecyclerView mHomeFourRecy;
        ImageView mHomeFiveIv1;
        TextView mHomeFiveTvtitle1;
        TextView mHomeFiveTvPric1;
        TextView mHomeFiveTvBody;
        ImageView mHomeFiveIv2;
        TextView mHomeFiveTvtitle2;
        TextView mHomeFiveTvPric2;
        TextView mHomeFiveTvBody2;
        ImageView mHomeFiveIv3;
        TextView mHomeFiveTvtitle3;
        TextView mHomeFiveTvPric3;
        TextView mHomeFiveTvBody3;
        TextView mHomeSixTitle;
        RecyclerView mRecySix;

        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if (viewType == 0) {
                this.mHomeBan = (Banner) itemView.findViewById(R.id.home_ban);
                this.mTv1 = (TextView) itemView.findViewById(R.id.tv1);
                this.mTv2 = (TextView) itemView.findViewById(R.id.tv2);
                this.mTv3 = (TextView) itemView.findViewById(R.id.tv3);
                this.mTv4 = (TextView) itemView.findViewById(R.id.tv4);
                this.mTv5 = (TextView) itemView.findViewById(R.id.tv5);
            } else if (viewType == 1) {
                this.mHomeTwoRecy = (RecyclerView) itemView.findViewById(R.id.home_two_recy);
            } else if (viewType == 2) {
                this.mHomeThreeRecy = (RecyclerView) itemView.findViewById(R.id.home_three_recy);
            } else if (viewType == 3) {
                this.mHomeFourRecy = (RecyclerView) itemView.findViewById(R.id.home_four_recy);
            } else if (viewType == 4) {
                this.mHomeFiveIv1 = (ImageView) itemView.findViewById(R.id.home_five_iv1);
                this.mHomeFiveTvtitle1 = (TextView) itemView.findViewById(R.id.home_five_tvtitle1);
                this.mHomeFiveTvPric1 = (TextView) itemView.findViewById(R.id.home_five_tv_pric1);
                this.mHomeFiveTvBody = (TextView) itemView.findViewById(R.id.home_five_tv_body);
                this.mHomeFiveIv2 = (ImageView) itemView.findViewById(R.id.home_five_iv2);
                this.mHomeFiveTvtitle2 = (TextView) itemView.findViewById(R.id.home_five_tvtitle2);
                this.mHomeFiveTvPric2 = (TextView) itemView.findViewById(R.id.home_five_tv_pric2);
                this.mHomeFiveTvBody2 = (TextView) itemView.findViewById(R.id.home_five_tv_body2);
                this.mHomeFiveIv3 = (ImageView) itemView.findViewById(R.id.home_five_iv3);
                this.mHomeFiveTvtitle3 = (TextView) itemView.findViewById(R.id.home_five_tvtitle3);
                this.mHomeFiveTvPric3 = (TextView) itemView.findViewById(R.id.home_five_tv_pric3);
                this.mHomeFiveTvBody3 = (TextView) itemView.findViewById(R.id.home_five_tv_body3);
            } else {
                this.mHomeSixTitle = (TextView) itemView.findViewById(R.id.home_six_title);
                this.mRecySix = (RecyclerView) itemView.findViewById(R.id.recy_six);
            }

        }
    }
}
