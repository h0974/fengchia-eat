package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Shop_RecyclerAdapter extends RecyclerView.Adapter<Shop_RecyclerAdapter.MyViewHolder> {

  Context context;
  ArrayList<ShopModel> shopModels;

  public Shop_RecyclerAdapter(Context context, ArrayList<ShopModel> shopModels){
    this.context = context;
    this.shopModels =shopModels;
  }

  @NonNull
  @Override
  public Shop_RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.recycler_view_row,parent,false);
    return new Shop_RecyclerAdapter.MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Shop_RecyclerAdapter.MyViewHolder holder, int position) {

    holder.tvShopName.setText(shopModels.get(position).getShopName());
    holder.tvShippingFee.setText(shopModels.get(position).getShippingFee());
    holder.imageView.setImageResource(shopModels.get(position).getImage());
  }

  @Override
  public int getItemCount() {

    return shopModels.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView tvShopName,tvShippingFee;

    public MyViewHolder(@NonNull View itemView) {
      super(itemView);

      imageView = itemView.findViewById(R.id.imageView_shop);
      tvShopName = itemView.findViewById(R.id.textView_shopName);
      tvShippingFee = itemView.findViewById(R.id.textView_shippingFee);
    }
  }
}
