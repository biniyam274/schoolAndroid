package com.example.bim_1_1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bim_1_1.model.BasketAdapter;
import com.example.bim_1_1.model.Product;
import com.example.bim_1_1.model.ProductRepo;
import com.example.bim_1_1.model.RecyclerProductAdapter;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements RecyclerProductAdapter.ItemClicked {

    BasketAdapter basketAdapter;
    ListView basketListView;
    ArrayList<Product> basketList;
    TextView tv_Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_basket_list_view);
        basketListView = (ListView)findViewById(R.id.lv_cart);
        tv_Total = findViewById(R.id.tv_total_recyvle);

        basketList= RecyclerActivity.basketList;

        basketAdapter = new BasketAdapter(this,R.layout.listview_basket,basketList);

        basketListView.setAdapter(basketAdapter);

    }

    @Override
    public void OnItemDeleted(int index) {
        basketAdapter.remove(ProductRepo.getProductById(index));
    }

    @Override
    public void OnItemAdded(int index) {
    basketAdapter.add(ProductRepo.getProductById(index));
    }
}