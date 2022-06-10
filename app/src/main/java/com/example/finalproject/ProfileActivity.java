package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
  }

  public void goBackMain (View view){
    finish();
  }

  public void goRider (View view){
    Intent intent = new Intent (this, RiderActivity.class);
    startActivity(intent);
  }

  public void goStore (View view){
    Intent intent = new Intent (this, StoreActivity.class);
    startActivity(intent);
  }

}
