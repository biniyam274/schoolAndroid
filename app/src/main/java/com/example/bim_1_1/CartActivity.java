package com.example.bim_1_1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bim_1_1.model.BasketAdapter;
import com.example.bim_1_1.model.ProdcutAdapter;
import com.example.bim_1_1.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {



    ListView lvBaskets;
    public static int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_basket_list_view);
        lvBaskets = findViewById(R.id.lv_cart);
        ArrayList<Product> baskets = (ArrayList<Product>) getIntent().getSerializableExtra("data");
        BasketAdapter adapter = new BasketAdapter(this,R.layout.listview_basket,baskets);
        lvBaskets.setAdapter(adapter);
    }
}