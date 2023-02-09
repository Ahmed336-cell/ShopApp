package com.elm.shop.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.elm.shop.model.StoreModel;
import com.elm.shop.reposit.MainRepo;

import java.util.List;

public class MainAcViewModel extends ViewModel {
    private final MainRepo mainRepo;

    public MainAcViewModel() {
        mainRepo = new MainRepo();
    }
    public LiveData<List<StoreModel>>getStoreItems(){
        return mainRepo.getItemModelLiveData();
    }
}
