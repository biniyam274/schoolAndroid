package com.example.bim_1_1.model;

import com.example.bim_1_1.R;

import java.util.ArrayList;

public class ProductRepo {

    public static  ArrayList<Product> getProducts(){
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(new Product("Laptop", 76, R.drawable.ic_launcher_background, 2, "Electronics", "Perfect Stuff",productList.size()));
        productList.add(new Product("shoes", 3500, R.drawable.ic_launcher_background, 8, "Shoes", "Perfect Stuff",productList.size()));
        productList.add(new Product("Desktop ", 54, R.drawable.ic_launcher_background, 45, "Electronics", "Perfect Stuff",productList.size()));
        productList.add(new Product("JBL", 345, R.drawable.ic_launcher_background, 5, "Something", "Perfect Stuff",productList.size()));
        productList.add(new Product("Nike", 3500, R.drawable.ic_launcher_background, 6, "Cloth", "Perfect Stuff",productList.size()));
        productList.add(new Product("Siphora", 87, R.drawable.ic_launcher_background, 30, "DOC", "Perfect Stuff",productList.size()));
        productList.add(new Product("UTC", 986, R.drawable.ic_launcher_background, 45, "phone", "Perfect Stuff",productList.size()));
        productList.add(new Product("PS3", 345, R.drawable.ic_launcher_background, 12, "Shoes", "Perfect Stuff",productList.size()));

        return productList;
    }

    public static Product getProductById(int index) {
        return  getProducts().get(index);
    }
}
