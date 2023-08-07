package com.example.lab5_androidnwk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Product extends RecyclerView.Adapter<Adapter_Product.ViewHolder> {
    private Context context;
    private List<Product> productList;

    public Adapter_Product(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvName.setText("Name: " + product.getName());
        holder.tvPrice.setText("Price: " +product.getPrice());
        holder.tvDesc.setText( "Desc: " +product.getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,EditProduct.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",product);
                intent.putExtras(bundle);
;                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName, tvPrice, tvDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.rowProduct_tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.rowProduct_tvPrice);
            tvDesc = (TextView) itemView.findViewById(R.id.rowProduct_tvDesc);
        }
    }
}
