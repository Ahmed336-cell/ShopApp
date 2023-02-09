package com.elm.shop.reposit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.elm.shop.common.Common;
import com.elm.shop.model.StoreModel;
import com.elm.shop.network.APIservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {
    private static final String TAG = "MainRepo";
    private APIservices apIservices;

    public MainRepo() {
        this.apIservices = Common.getAPIservices();
    }

    public MutableLiveData<List<StoreModel>>getItemModelLiveData(){
        MutableLiveData<List<StoreModel>> data= new MutableLiveData<>();
        apIservices.getItemList().enqueue(new Callback<List<StoreModel>>() {
            @Override
            public void onResponse(Call<List<StoreModel>> call, Response<List<StoreModel>> response) {
                Log.e(TAG,"onResponse"+response.code());
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }else{
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<StoreModel>> call, Throwable t) {
                Log.e(TAG,"onResponse"+t.getMessage());

                data.setValue(null);
            }
        });
        return data;
    }

}
