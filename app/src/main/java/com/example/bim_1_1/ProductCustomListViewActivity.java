package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bim_1_1.model.BasketAdapter;
import com.example.bim_1_1.model.ProdcutAdapter;
import com.example.bim_1_1.model.Product;
import com.example.bim_1_1.model.ProductRepo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductCustomListViewActivity extends AppCompatActivity {

    List<Product> productList;
    ArrayList<Product> basketList;
    ListView lvProdcut;
    Button cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_custom_list_view);

        lvProdcut = findViewById(R.id.lvProducts);
        cartBtn = findViewById(R.id.cartBtn);
        productList = new ArrayList<>();
        basketList = ProductRepo.getProducts();
        BasketAdapter cart = new BasketAdapter(this,R.layout.listview_basket,basketList );

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints = new Intent(ProductCustomListViewActivity.this,CartActivity.class);
                ints.putExtra("data", (Serializable) basketList);
                startActivity(ints);
            }
        });
        ProdcutAdapter adapter = new ProdcutAdapter(this, R.layout.listview_product, productList ,cart,cartBtn);
        lvProdcut.setAdapter(adapter);



    }

}