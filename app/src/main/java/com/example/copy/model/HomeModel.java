package com.example.copy.model;

import com.example.copy.contract.Contract;
import com.example.copy.utli.NetWorkUtli.NetWorkCallBack.NetWorkCallback;
import com.example.copy.utli.NetWorkUtli.UtliNetWork;

public class HomeModel implements Contract.HomeModel {
    @Override
    public void get(String url, NetWorkCallback callback) {
        UtliNetWork.getUtliNetWork().get(url,callback);
    }
}
