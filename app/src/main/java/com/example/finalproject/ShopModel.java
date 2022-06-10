package com.example.finalproject;

public class ShopModel {
  String shopName;
  String shippingFee;
  int image;

  public ShopModel(String shopName, String shippingFee, int image) {
    this.shopName = shopName;
    this.shippingFee = shippingFee;
    this.image = image;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getShippingFee() {
    return shippingFee;
  }

  public void setShippingFee(String shippingFee) {
    this.shippingFee = shippingFee;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
  //66
}
