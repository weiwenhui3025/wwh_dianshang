package com.example.copy.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.copy.R;
import com.example.copy.adapter.HomeAdapterBig;
import com.example.copy.base.BaseView;
import com.example.copy.bean.HomeBean;
import com.example.copy.contract.Contract;
import com.example.copy.presenter.HomePresenter;
import com.example.copy.utli.NetWorkAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Contract.HomeView{


    private RecyclerView recy;
    private HomePresenter presenter;
    private List<HomeBean.DataBean.BannerBean> banner=new ArrayList<>();
    private List<HomeBean.DataBean.ChannelBean> channel=new ArrayList<>();
    private List<HomeBean.DataBean.NewGoodsListBean> newGoodsList=new ArrayList<>();
    private List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList=new ArrayList<>();
    private List<HomeBean.DataBean.BrandListBean> brandList=new ArrayList<>();
    private List<HomeBean.DataBean.TopicListBean> topicList=new ArrayList<>();
    private List<HomeBean.DataBean.CategoryListBean> categoryList=new ArrayList<>();
    private HomeAdapterBig adapterBig;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        presenter = new HomePresenter();
        presenter.Attach(this);
        presenter.get(NetWorkAPI.IndexUrl);
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.home_recy);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterBig = new HomeAdapterBig(banner, channel, newGoodsList, hotGoodsList, brandList, topicList, categoryList);
        recy.setAdapter(adapterBig);
//        recy.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.delete();
    }

    @Override
    public void Success(String json) {
        HomeBean bean = new Gson().fromJson(json, HomeBean.class);
        HomeBean.DataBean data = bean.getData();
        banner.addAll(data.getBanner());
        channel.addAll(data.getChannel());
        newGoodsList.addAll(data.getNewGoodsList());
        hotGoodsList.addAll(data.getHotGoodsList());
        brandList.addAll(data.getBrandList());
        topicList.addAll(data.getTopicList());
        categoryList.addAll(data.getCategoryList());
        adapterBig.notifyDataSetChanged();
    }

    @Override
    public void Error(String json) {
        Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
    }
}