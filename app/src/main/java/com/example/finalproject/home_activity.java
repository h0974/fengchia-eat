package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class home_activity extends AppCompatActivity {

  //public static boolean VALID_USER = true;
  //widgets
  RecyclerView recyclerView;

  //firebase
  private DatabaseReference myRef;

  //variable
  private ArrayList<Category> categoryList;
  private RecyclerAdapter recyclerAdapter;
  private Context cContext = home_activity.this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    /*if(VALID_USER){
      Intent intent = new Intent();
      intent.setClass(this,login_activity.class);
      startActivity(intent);
    }*/

    recyclerView = findViewById(R.id.recyclerView);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);

    //firebase
    myRef = FirebaseDatabase.getInstance().getReference();

    //ArrayList
    categoryList = new ArrayList<>();

    //clear arraylist
    clearAll();

    //Get data from database method
    GetDataFromFirebase();
  }
  private void GetDataFromFirebase() {
    Query query = myRef.child("Category");

    query.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
          Category category = new Category();

          category.setImage(snapshot.child("Image").getValue().toString());
          category.setName(snapshot.child("Name").getValue().toString());

          categoryList.add(category);
        }
        recyclerAdapter = new RecyclerAdapter(cContext,categoryList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }
    });

  }

  private void clearAll(){
    if(categoryList !=null){
      categoryList.clear();

      if(recyclerAdapter != null){
        recyclerAdapter.notifyDataSetChanged();
      }
    }
    categoryList = new ArrayList<>();
  }
}