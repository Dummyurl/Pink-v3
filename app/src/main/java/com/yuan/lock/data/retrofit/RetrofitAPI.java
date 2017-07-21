package com.yuan.lock.data.retrofit;

import com.yuan.lock.data.retrofit.api.RemoteService;
import com.yuan.lock.utils.Config;

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
                this.remoteService = getRxJavaService(normalClient, Config.HOST_WEATHER, RemoteService.class);
            }
        }
        return remoteService;
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
