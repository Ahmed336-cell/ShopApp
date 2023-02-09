package com.elm.shop.presenter;

import android.content.Intent;

import com.elm.shop.model.User;
import com.elm.shop.ui.LoginActivity;
import com.elm.shop.ui.MainActivity;
import com.elm.shop.view.ILoginView;

public class LoginPresenter implements  ILoginPresenter {
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        boolean isLoginSuccess = user.isValid();

        if (isLoginSuccess){
            iLoginView.onLoginResult("Login Success");
        }else{
            iLoginView.onLoginResult("Login error");
        }

    }
}
