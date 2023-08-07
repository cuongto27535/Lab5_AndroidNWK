package com.example.lab5_androidnwk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lab5 extends AppCompatActivity {
    private Button btnViewProducts, btnAddProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
        getSupportActionBar().setTitle("Lab 5");
        btnViewProducts = (Button) findViewById(R.id.L5_btnViewProducts);
        btnAddProduct = (Button) findViewById(R.id.L5_btnAddProduct);
        btnViewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lab5.this,ProductList.class));
            }
        });
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lab5.this, AddProduct.class));
            }
        });
    }
}