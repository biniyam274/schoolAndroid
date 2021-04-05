package com.example.bim_1_1.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements  Serializable {
    String Name;
    float Price;
    int Image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    int Quantity;
    String Category;
    String Description;
    Integer AmtInStock;

    public Product() {

    }

    public Product(String name, float price, int image, int quantity, String category, String description,int id) {
        Name = name;
        Price = price;
        Image = image;
        Quantity = quantity;
        Category = category;
        Description = description;
        id = id;
       AmtInStock = 0;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getAmtInStock() {
        return AmtInStock;
    }

    public void setAmtInStock(Integer amtInStock) {
       AmtInStock = amtInStock;
    }

}
