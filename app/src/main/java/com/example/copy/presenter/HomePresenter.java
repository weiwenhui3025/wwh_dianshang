package com.example.copy.presenter;


import com.example.copy.base.BasePresenter;
import com.example.copy.bean.IndexBean;
import com.example.copy.component.CommonSubscriber;
import com.example.copy.contract.HomeContract;
import com.example.copy.model.HttpManager;
import com.example.copy.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean result) {
                        mView.homeData(result);
                    }
                }));
    }
}
