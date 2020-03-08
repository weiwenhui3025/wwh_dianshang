package com.example.copy.presenter;


import com.example.copy.base.BasePresenter;
import com.example.copy.bean.IndexBean;
import com.example.copy.component.CommonSubscriber;
import com.example.copy.contract.ZhuanTiContract;
import com.example.copy.model.HttpManager;
import com.example.copy.utils.RxUtils;

public class ZhuanTiPresenter extends BasePresenter<ZhuanTiContract.View> implements ZhuanTiContract.Presenter {
    @Override
    public void getZhuanTiData() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean result) {
                        mView.getZhuanTi(result);
                    }
                }));
    }
}
