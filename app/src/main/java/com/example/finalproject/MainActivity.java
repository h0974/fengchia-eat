package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static boolean VALID_USER = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(VALID_USER){
            Intent intent = new Intent();
            intent.setClass(this,login_activity.class);
            startActivity(intent);
        }
    }
}