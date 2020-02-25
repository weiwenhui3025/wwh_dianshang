package com.example.copy.utli.NetWorkUtli;

import android.util.Log;

import com.example.copy.utli.NetWorkAPI;
import com.example.copy.utli.NetWorkUtli.NetWorkCallBack.NetWorkCallback;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class UtliNetWork {
    public volatile static UtliNetWork utliNetWork;
    private final Retrofit retrofit;
    private UtliNetWork() {
        retrofit = new Retrofit.Builder()
                .baseUrl(NetWorkAPI.ApiRootUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static UtliNetWork getUtliNetWork() {
        if (utliNetWork == null) {
            synchronized (UtliNetWork.class) {
                if (utliNetWork == null) {
                    utliNetWork = new UtliNetWork();
                }
            }
        }
        return utliNetWork;
    }
    public void get(String url, final NetWorkCallback callback){
        Observable<ResponseBody> data = retrofit.create(NetWorkAPI.class).getData(url);
        data.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe: "+d.toString() );
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        String toString = responseBody.toString();
                        try {
                            callback.Success(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.Error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
