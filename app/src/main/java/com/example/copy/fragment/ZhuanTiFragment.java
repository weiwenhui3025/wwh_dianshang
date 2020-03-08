package com.example.copy.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.copy.R;
import com.example.copy.adapter.ZhuanTiAdapter;
import com.example.copy.base.BaseFragment;
import com.example.copy.bean.IndexBean;
import com.example.copy.contract.ZhuanTiContract;
import com.example.copy.presenter.ZhuanTiPresenter;


import java.util.ArrayList;
import java.util.List;

public class ZhuanTiFragment extends BaseFragment<ZhuanTiContract.View, ZhuanTiContract.Presenter> implements ZhuanTiContract.View {
    private TextView mTitleZhuanti;
    private RecyclerView mZhuantiRec;
    private List<IndexBean.DataBean.TopicListBean> listBeans;
    private ZhuanTiAdapter zhuanTiAdapter;

    @Override
    protected void initData() {
        presenter.getZhuanTiData();
    }

    @Override
    protected ZhuanTiPresenter createPresenter() {
        return new ZhuanTiPresenter();
    }

    @Override
    protected void initView(View view) {
        mTitleZhuanti = (TextView) view.findViewById(R.id.zhuanti_title);
        mZhuantiRec = (RecyclerView) view.findViewById(R.id.zhuantiRec);
        mTitleZhuanti.setText("专题精选");
        mZhuantiRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        listBeans = new ArrayList<>();
        zhuanTiAdapter = new ZhuanTiAdapter(listBeans);
        mZhuantiRec.setAdapter(zhuanTiAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.zhuanti_fragment;
    }

    @Override
    public void getZhuanTi(IndexBean zhuanti) {
        zhuanTiAdapter.addData(zhuanti.getData().getTopicList());
    }
}
