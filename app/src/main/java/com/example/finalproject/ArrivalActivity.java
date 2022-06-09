package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ArrivalActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_arrival);
  }

  public void goRiderend (View view){
    Intent intent = new Intent (this, RiderendActivity.class);
    startActivity(intent);
  }

}