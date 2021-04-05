package com.example.bim_1_1.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bim_1_1.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {

    Context _ctx;
    ArrayList<Product> _productList;
    ItemClicked activity;

    public  interface  ItemClicked{
        void OnItemDeleted(int index);
        void OnItemAdded(int index);
    }

    public RecyclerProductAdapter(Context _ctx, ArrayList<Product> _productList) {
        this._ctx = _ctx;
        this._productList = _productList;
        activity = ((ItemClicked)_ctx);
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder   {

        ImageView ivImage;
        TextView tvProductName ,tvProductPrice ,tvStock ;
        Button btnAdd , btnDetails ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             ivImage = itemView.findViewById(R.id.ivImage);
             tvProductName = itemView.findViewById(R.id.tvProductName);
             tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
             tvStock = itemView.findViewById(R.id.tvStock);
             btnAdd = itemView.findViewById(R.id.btnAdd);
             btnDetails = itemView.findViewById(R.id.btnDetails);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.OnItemAdded(Integer.parseInt(itemView.getTag().toString()));
                }
            });
            btnDetails.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     activity.OnItemDeleted(Integer.parseInt(itemView.getTag().toString()));
                 }
             });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(_ctx).inflate(R.layout.listview_product,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = _productList.get(position);
        holder.ivImage.setImageDrawable(_ctx.getResources().getDrawable(product.getImage()));
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice()+"");
        holder.tvProductName.setText(product.getName());
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        if(_productList != null)
            return _productList.size();
        return  0;
    }

}
