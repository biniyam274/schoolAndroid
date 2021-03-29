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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductCustomListViewActivity extends AppCompatActivity {

    List<Product> productList;
    List<Product> basketList;
    ListView lvProdcut;
    Button cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_custom_list_view);

        lvProdcut = findViewById(R.id.lvProducts);
        cartBtn = findViewById(R.id.cartBtn);
        productList = new ArrayList<>();
        basketList = new ArrayList<>();
        BasketAdapter cart = new BasketAdapter(this,R.layout.listview_basket,basketList);
        productList.add(new Product("Laptop", 3500, R.drawable.ic_launcher_background, 45, "Shoes", "Perfect Stuff"));
        productList.add(new Product("shoes", 3500, R.drawable.ic_launcher_background, 45, "Shoes", "Perfect Stuff"));
        productList.add(new Product("laptop3 ", 3500, R.drawable.ic_launcher_background, 45, "Dress", "Perfect Stuff"));
        productList.add(new Product("Cumo", 3500, R.drawable.ic_launcher_background, 45, "Something", "Perfect Stuff"));
        productList.add(new Product("Benja", 3500, R.drawable.ic_launcher_background, 45, "Shoes", "Perfect Stuff"));
        productList.add(new Product("Siphora", 3500, R.drawable.ic_launcher_background, 45, "DOC", "Perfect Stuff"));
        productList.add(new Product("UTC", 3500, R.drawable.ic_launcher_background, 45, "phone", "Perfect Stuff"));
        productList.add(new Product("Laptop", 3500, R.drawable.ic_launcher_background, 45, "Shoes", "Perfect Stuff"));
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