package com.example.bim_1_1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class ProdcutAdapter extends ArrayAdapter<Product> {

    List<Product> productList;
    BasketAdapter bAdapter;

    Context context;
    int resourceID;
     Button cartBtn;

    public ProdcutAdapter(@NonNull Context context, int resource, @NonNull List<Product> list,BasketAdapter bAdpt,Button cartBtn) {
        super(context, resource, list);
        this.productList = list;
        this.context = context;
        this.resourceID = resource;
        this.bAdapter = bAdpt;
        this.cartBtn = cartBtn;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(resourceID,null,false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvProductName = (TextView) view.findViewById(R.id.tvProductName);
        TextView tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);
        TextView tvStock = (TextView) view.findViewById(R.id.tvStock);
        Button btnAdd = (Button) view.findViewById(R.id.btnAdd);
        Button btnDetails = (Button) view.findViewById(R.id.btnDetails);

        Product product = productList.get(position);
        ivImage.setImageDrawable(context.getResources().getDrawable(product.getImage(),null));
        tvProductName.setText(product.getName());
        tvProductPrice.setText(String.valueOf(product.getPrice()));
        tvStock.setText("Amt In Stock"+ ":" +(product.getQuantity() - product.getAmtInStock()));

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
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(product.getQuantity()-product.getAmtInStock()>0){
                    bAdapter.addPro(product);
                    tvStock.setText("Amt In Stock"+ ":" +(product.getQuantity() - product.getAmtInStock()));
                    Toast.makeText(context, "One product added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Product is out of stoc", Toast.LENGTH_SHORT).show();

                }


                cartBtn.setText(((Integer)bAdapter.getCount()).toString());

            }
        });

        return view;
    }
}
