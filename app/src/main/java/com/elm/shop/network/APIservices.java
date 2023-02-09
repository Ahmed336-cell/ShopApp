package com.elm.shop.network;

import com.elm.shop.model.StoreModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservices {
    @GET("products")
    Call<List<StoreModel>> getItemList();
}
