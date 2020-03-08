package com.example.copy.presenter;


import com.example.copy.base.BasePresenter;
import com.example.copy.bean.RelatedBean;
import com.example.copy.component.CommonSubscriber;
import com.example.copy.contract.PurchaseContract;
import com.example.copy.model.HttpManager;
import com.example.copy.utils.RxUtils;

public class PurchasePresenter extends BasePresenter<PurchaseContract.View> implements PurchaseContract.Presenter {
    @Override
    public void getRelatedData(int id) {
        addSubscribe(HttpManager.getMyApi().getRelatedData(id)
                .compose(RxUtils.<RelatedBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RelatedBean>(mView){
                    @Override
                    public void onNext(RelatedBean relatedBean) {
                        mView.getRelatedDataReturn(relatedBean);
                    }
                }));
    }
}
