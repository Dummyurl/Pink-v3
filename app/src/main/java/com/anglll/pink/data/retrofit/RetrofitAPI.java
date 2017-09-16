package com.anglll.pink.data.retrofit;

import com.anglll.pink.data.retrofit.api.LocalService;
import com.anglll.pink.data.retrofit.api.RemoteService;
import com.anglll.pink.utils.Config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class RetrofitAPI {
    private static RetrofitAPI instance;
    private RemoteService remoteService;
    private OkHttpClient normalClient = new OkHttpClient().newBuilder().build();
    private LocalService localService;

    public static RetrofitAPI getInstance() {
        synchronized (RetrofitAPI.class) {
            if (instance == null) {
                instance = new RetrofitAPI();
            }
        }
        return instance;
    }

    public RemoteService getRemoteService() {
        synchronized (RetrofitAPI.class) {
            if (this.remoteService == null) {
                this.remoteService = getRxJavaService(normalClient, Config.HOST, RemoteService.class);
            }
        }
        return remoteService;
    }

    public LocalService getLocalService() {
        synchronized (RetrofitAPI.class) {
            if (this.localService == null) {
                this.localService = new LocalService();
            }
        }
        return localService;
    }

    public <T> T getRxJavaService(OkHttpClient client, String host, Class<T> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

}
