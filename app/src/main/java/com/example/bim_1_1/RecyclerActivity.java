package com.example.bim_1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bim_1_1.model.Product;
import com.example.bim_1_1.model.ProductRepo;
import com.example.bim_1_1.model.RecyclerProductAdapter;

import java.util.ArrayList;
public class RecyclerActivity extends AppCompatActivity implements RecyclerProductAdapter.ItemClicked {

    private RecyclerView recyclerView;
    private RecyclerProductAdapter adapter;
    private ArrayList<Product> designList;
    public static ArrayList<Product> basketList;
    TextView  cartView;
    Button  cartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView_Main);
        designList = new ArrayList<Product>();
        designList = list();
        basketList = new ArrayList<Product>();
        cartView = (TextView) findViewById(R.id.cartCount);
        cartButton = (findViewById(R.id.cartButton));
        cartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               goToCart();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerProductAdapter(RecyclerActivity.this, designList);
        recyclerView.setAdapter(adapter);
    }


    public ArrayList<Product> list() {
       return ProductRepo.getProducts();
    }



    public void setBadgeCount(int count) {
        cartView.setText(Integer.toString(count));
    }

    public void goToCart() {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void OnItemDeleted(int index) {

    }

    @Override
    public void OnItemAdded(int index) {

    }


}