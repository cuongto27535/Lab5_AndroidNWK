package com.example.lab5_androidnwk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProduct extends AppCompatActivity {
    private EditText etName, etPrice, etDesc;
    private Button btnSubmit, btnDelete, btnCancel;
    private String productId;
    private API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        getSupportActionBar().setTitle("Edit Product");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        api = Retrofit_Manager.retrofit.create(API.class);
        etName = (EditText) findViewById(R.id.L5EditProduct_etName);
        etPrice = (EditText) findViewById(R.id.L5EditProduct_etPrice);
        etDesc = (EditText) findViewById(R.id.L5EditProduct_etDesc);
        btnSubmit = (Button) findViewById(R.id.L5EditProduct_btnSubmit);
        btnDelete = (Button) findViewById(R.id.L5EditProduct_btnDelete);
        btnCancel = (Button) findViewById(R.id.L5EditProduct_btnCancel);
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("product");
            etName.setText(product.getName());
            etPrice.setText(product.getPrice());
            etDesc.setText(product.getDesc());
            productId = product.get_id();
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", etName.getText().toString());
                map.put("price", etPrice.getText().toString());
                map.put("desc", etDesc.getText().toString());
                Call<String> call = api.lab5_updateProduct(productId,map);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.code() == 201){
                            Toast.makeText(EditProduct.this, "Product was updated", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(EditProduct.this,ProductList.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("result",t.getMessage());
                    }
                });
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<String> call = api.lab5_deleteProduct(productId);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.code() == 201) {
                            Toast.makeText(EditProduct.this, "Product was deleted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(EditProduct.this,ProductList.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("result", t.getMessage());
                    }
                });
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProduct.this, ProductList.class));
            }
        });
    }
}