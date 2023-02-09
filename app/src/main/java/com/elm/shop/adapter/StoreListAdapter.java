package com.elm.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elm.shop.R;
import com.elm.shop.model.StoreModel;
import com.elm.shop.ui.DetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder> {
    Context context;
    List<StoreModel>storeModelList;

    public StoreListAdapter(Context context, List<StoreModel> storeModelList) {
        this.context = context;
        this.storeModelList = storeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.items_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(storeModelList.get(position).getImage()).into(holder.imageView);
        holder.price.setText(storeModelList.get(position).getPrice()+" $");
        holder.description.setText(storeModelList.get(position).getDescription());
        holder.title.setText(storeModelList.get(position).getTitle());
        holder.cateogry.setText(storeModelList.get(position).getCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go =new Intent(context, DetailsActivity.class);
                go.putExtra("title",storeModelList.get(position).getTitle());
                go.putExtra("desc",storeModelList.get(position).getDescription());
                go.putExtra("ca",storeModelList.get(position).getCategory());
                go.putExtra("price",storeModelList.get(position).getPrice()+" $");
                go.putExtra("img",storeModelList.get(position).getImage());
                context.startActivity(go);


            }
        });
    }

    @Override
    public int getItemCount() {
        return storeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,description,cateogry,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.titlel);
            description = itemView.findViewById(R.id.description);
            cateogry = itemView.findViewById(R.id.categorytxt);
            price = itemView.findViewById(R.id.pricetxt);
        }
    }
}
