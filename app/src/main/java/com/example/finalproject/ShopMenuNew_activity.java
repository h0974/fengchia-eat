package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShopMenuNew_activity extends AppCompatActivity {

  ListView listViewData;
  ArrayAdapter<String> adapter;
  String[] arrayMenu = {"大麥克套餐","勁辣雞腿堡套餐","鱈魚堡套餐","麥香雞套餐",
                        "雞塊套餐","雙層牛肉吉士堡套餐","黃金豬排套餐"};

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu,menu);
    return true;
    //return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    if(id == R.id.item_done){
      String itemSelected = "選擇餐點: \n";
      for(int i=0;i<listViewData.getCount();i++){
        if(listViewData.isItemChecked(i)){
          itemSelected += listViewData.getItemAtPosition(i)+"\n";
        }
      }
      Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop_menu_new);

    listViewData = findViewById(R.id.listview_data);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arrayMenu);
    listViewData.setAdapter(adapter);


  }
}