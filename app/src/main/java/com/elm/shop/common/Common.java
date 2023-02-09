package com.elm.shop.common;

import com.elm.shop.network.APIservices;
import com.elm.shop.network.Retro;

import retrofit2.Retrofit;

public class Common {
    private static final String BASE_URL = "https://fakestoreapi.com/";
    public static APIservices getAPIservices(){
        return Retro.getRetrofitClient(BASE_URL).create(APIservices.class);
    }
}
