package com.example.bim_1_1.model;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bim_1_1.CartActivity;
import com.example.bim_1_1.R;
import com.example.bim_1_1.RecyclerActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasketAdapter extends ArrayAdapter<Product> {

    ArrayList<Product> cart;
    int resourceID;
    Context context;
    public BasketAdapter(@NonNull Context context, int resource, ArrayList<Product> cart) {
        super(context, resource, cart);
        this.cart = cart;
        this.resourceID = resource;
        this.context = context;
    }


    @Override
    public int getCount() {
        if(cart !=null){
            return cart.size();
        }
        return 0;
    }

    public void addPro(Product object) {
        if(RecyclerActivity.basketList.contains(object)){
            object.setAmtInStock(object.getAmtInStock()+1);
        }
        else {
            RecyclerActivity.basketList.add(object);
        }
    }
    private void removePro(Product product) {
        RecyclerActivity.basketList.remove(product);
    }

    @Override
    public void add(@Nullable Product object) {
        object.setAmtInStock(object.getAmtInStock()+1);

    }

    @Override
    public void remove(@Nullable Product object) {
        object.setAmtInStock(object.getAmtInStock()-1);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(resourceID,null,false);

        TextView tvProductName = (TextView) view.findViewById(R.id.tv_proName);
        TextView tvProductTotal = (TextView) view.findViewById(R.id.tv_total);
        Button minusProduct = (Button) view.findViewById(R.id.btnMinusProduct);
        Button plusProduct = (Button) view.findViewById(R.id.btnPlusProduct);
        Button btnDetails = (Button) view.findViewById(R.id.ItemBtnDetail);
        Button ItemBtnDelete = (Button) view.findViewById(R.id.ItemBtnDelete);
        Product product = cart.get(position);
        tvProductTotal.setText(tvProductTotal.getText() + ((Float)product.getPrice() ).toString());
        tvProductName.setText(product.getAmtInStock() +" : " + product.getName());

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                StringBuilder me = new StringBuilder();

                me.append("Product Name : "+product.getName());
                me.append("\nProduct Category : "+product.getCategory() +"'\n Product Price :"+product.getPrice());
                me.append("\nProduct Quantity : "+(product.getQuantity()-product.getAmtInStock()) +"'\n Product Description :"+product.getDescription());
                builder.setMessage(me);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        ItemBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(product);
            }
        });
        minusProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getAmtInStock()>0){
                    remove(product);
                    tvProductName.setText(product.getAmtInStock() +" : " + product.getName());

                }
                else {
                removePro(product);
                }
            }
        });

        plusProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getAmtInStock() < product.getQuantity()){
                add(product);
                tvProductName.setText(product.getAmtInStock() +" : " + product.getName());
                }
            }
        });

        return view;
    }


}
