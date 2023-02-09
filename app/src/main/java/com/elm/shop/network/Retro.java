package com.elm.shop.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitClient(String baseUrl){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60*2, TimeUnit.SECONDS)
                .connectTimeout(60 * 2 , TimeUnit.SECONDS)
                .writeTimeout(60 * 2 ,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;

    }
}
