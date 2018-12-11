package com.example.dell.liuguangyan1211.util;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkUtil {
    private static volatile OkUtil mInstance;
    private OkHttpClient mclient;
    private Handler handler = new Handler(Looper.myLooper());
    public static  OkUtil getmInstance(){
        if (mInstance==null){
            synchronized (OkUtil.class){
                if (null==mInstance){
                    mInstance = new OkUtil();
                }
            }

        }
        return mInstance;
    }
    private OkUtil(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor .setLevel(HttpLoggingInterceptor.Level.BODY);
        mclient = new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }
    public void postEnququ(String url, Map<String,String>praams, final Class clazz, final ICall callback){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String>entry : praams.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody body = builder.build();
        final Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call1 = mclient.newCall(request);
        call1.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                String result = response.body().string();
                final Object o = new Gson().fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                              callback.success(o);
                    }
                });
            }
        });

    }
}
