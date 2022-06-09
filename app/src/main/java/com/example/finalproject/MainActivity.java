package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    public static boolean VALID_USER = true;

    ArrayList<ShopModel> shopModels = new ArrayList<>();
    int[] shopImages = {R.drawable.mcd,R.drawable.breakfast,R.drawable.kfc,R.drawable.drink,R.drawable.shushi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       if(VALID_USER){
            Intent intent = new Intent();
            intent.setClass(this,login_activity.class);
            startActivity(intent);
        }

       RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

       setUpShopModel();

       Shop_RecyclerAdapter adapter = new Shop_RecyclerAdapter(this,shopModels,this);
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpShopModel(){
      String[] shopNames = getResources().getStringArray(R.array.shop_name);
      String[] shippingFees = getResources().getStringArray(R.array.shipping_fee);

      for(int i=0;i<shopNames.length;i++){
        shopModels.add(new ShopModel(shopNames[i],shippingFees[i],shopImages[i]));
      }
    }

  @Override
  public void onItemClick(int position) {
      Intent intent = new Intent(MainActivity.this,ShopMenuNew_activity.class);
      startActivity(intent);

  }

  public void goProfile (View view){
    Intent intent = new Intent (this, ProfileActivity.class);
    startActivity(intent);
  }
}