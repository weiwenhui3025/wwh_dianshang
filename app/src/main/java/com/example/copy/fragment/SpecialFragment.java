package com.example.copy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.copy.R;
import com.example.copy.adapter.SpecialAdapter;
import com.example.copy.bean.SpecialBean;
import com.example.copy.contract.Contract;
import com.example.copy.presenter.HomePresenter;
import com.example.copy.utli.NetWorkAPI;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends Fragment implements Contract.HomeView, SpecialAdapter.Data {


    private SpecialAdapter adapter;
    private HomePresenter presenter;
    private List<SpecialBean.DataBeanX.DataBean> list=new ArrayList<>();
    private RecyclerView mRecySpecial;
    private boolean iscoumn=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_special, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        presenter = new HomePresenter();
        presenter.Attach(this);
        presenter.get(NetWorkAPI.TopicList);
    }

    private void initView(View view) {
        mRecySpecial = (RecyclerView) view.findViewById(R.id.recy_special);
        mRecySpecial.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SpecialAdapter(list,iscoumn);
        mRecySpecial.setAdapter(adapter);
        adapter.setData(this);
    }

    @Override
    public void Success(String json) {
        SpecialBean bean = new Gson().fromJson(json, SpecialBean.class);
        list.addAll(bean.getData().getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.delete();
    }

    @Override
    public void Error(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onData(int page) {
        list.clear();
        adapter.notifyDataSetChanged();
        presenter.get(NetWorkAPI.TopicList+"?page="+page);
    }
}
