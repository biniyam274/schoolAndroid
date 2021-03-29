package com.example.bim_1_1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bim_1_1.R;

import java.util.ArrayList;
import java.util.List;

public class BasketAdapter extends ArrayAdapter<Product> {

    List<Product> cart;
    int resourceID;
    Context context;
    public BasketAdapter(@NonNull Context context, int resource,List<Product> cart) {
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

    @Override
    public void add(Product object) {
        cart.add(object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(resourceID,null,false);

//        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvProductName = (TextView) view.findViewById(R.id.tv_name);
//        TextView tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);
//        Button btnAdd = (Button) view.findViewById(R.id.btnAdd);
//        Button btnDetails = (Button) view.findViewById(R.id.btnDetails);

        Product product = cart.get(position);
        tvProductName.setText(product.getName());
//        tvProductPrice.setText(String.valueOf(product.getPrice()));


        return view;
    }
}
