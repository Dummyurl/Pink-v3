package com.anglll.pink;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.leakcanary.LeakCanary;

import okhttp3.OkHttpClient;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class PinkApplication extends Application {
    private static PinkApplication instance;
    OkHttpClient okHttpClient; // build on your own


    public static PinkApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //init
    }


    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initFresco() {
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this, okHttpClient)
//                . // other setters
//    . // setNetworkFetcher is already called for you
                .build();
        Fresco.initialize(this, config);
    }

}
