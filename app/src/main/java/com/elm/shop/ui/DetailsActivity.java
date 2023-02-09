package com.elm.shop.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elm.shop.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView price,des,title,cate;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        price = findViewById(R.id.pricetxtd);
        des = findViewById(R.id.descriptiond);
        title = findViewById(R.id.titleld);
        cate = findViewById(R.id.categorytxtd);
        imageView = findViewById(R.id.imgd);

       Bundle extras = getIntent().getExtras();

         String p = extras.getString("price");
            String c = extras.getString("ca");
            String t = extras.getString("title");
            String d = extras.getString("desc");
            String i = extras.getString("img");


       price.setText(p);
       cate.setText(c);
        des.setText(d);
        title.setText(t);
        Glide.with(this).load(i).into(imageView);
    }
}