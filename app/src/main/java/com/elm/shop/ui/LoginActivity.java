package com.elm.shop.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.elm.shop.R;
import com.elm.shop.presenter.ILoginPresenter;
import com.elm.shop.presenter.LoginPresenter;
import com.elm.shop.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    EditText email ,pas;
    Button login;
    String e,p;
    ILoginPresenter iLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pas = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);


        iLoginPresenter = new LoginPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e = email.getText().toString();
                p = pas.getText().toString();
                iLoginPresenter.onLogin(e,p);

            }
        });


    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.equals("Login Success")){
            Intent go = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(go);
            finish();
        }
    }


}