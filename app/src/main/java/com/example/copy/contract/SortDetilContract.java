package com.example.copy.contract;


import com.example.copy.base.IBaseView;
import com.example.copy.base.IPresenter;
import com.example.copy.bean.DetilListBean;
import com.example.copy.bean.DetilTabBean;

public interface SortDetilContract {

    interface View extends IBaseView {
        //加载分类列表的tab数据返回
        void getDetilTabReturn(DetilTabBean result);
        //获取分类类别的tab商品数据返回
        void getDetilReturn(DetilListBean result);
    }

    interface Presenter extends IPresenter<View> {
        //加载分类列表的tab数据
        void getDetilTab(int id);
        //获取分类列表tab所对应的商品数据
        void getDetilList(int categoryId, int page, int size);
    }

}
