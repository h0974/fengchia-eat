package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String Tag = "RecyclerView";
    private Context cContext;
    private ArrayList<Category> categoryList;

  public RecyclerAdapter(Context cContext, ArrayList<Category> categoryList) {
    this.cContext = cContext;
    this.categoryList = categoryList;
  }

  @NonNull
  @Override
  public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.textView.setText(categoryList.get(position).getName());

    Glide.with(cContext).load(categoryList.get(position).getImage()).into(holder.imageView);
  }

  @Override
  public int getItemCount() {
    return categoryList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
      ImageView imageView;
      TextView textView;

      public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        textView = itemView.findViewById(R.id.textViewy);
      }
    }
}
