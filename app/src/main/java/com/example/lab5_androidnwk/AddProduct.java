package com.example.lab5_androidnwk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProduct extends AppCompatActivity {
    private Button btnSubmit, btnCancel;
    private EditText etName, etPrice, etDesc;
    private TextView tvResult;
    private API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        getSupportActionBar().setTitle("Add Product");
        api = Retrofit_Manager.retrofit.create(API.class);
        btnSubmit = (Button) findViewById(R.id.L5AddProduct_btnSubmit);
        btnCancel = (Button) findViewById(R.id.L5AddProduct_btnCancel);
        etName = (EditText) findViewById(R.id.L5AddProduct_etPName);
        etPrice = (EditText) findViewById(R.id.L5AddProduct_etPrice);
        etDesc = (EditText) findViewById(R.id.L5AddProduct_etDesc);
        tvResult = (TextView) findViewById(R.id.L5AddProduct_tvResult);
        tvResult.setVisibility(View.GONE);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddProduct.this,ProductList.class));
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<>();
                map.put("name",etName.getText().toString());
                map.put("price",etPrice.getText().toString());
                map.put("desc",etDesc.getText().toString());
                Call<String> call = api.lab5_addProduct(map);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("result",response.body());
                        if (response.code() == 201){
                            tvResult.setVisibility(View.VISIBLE);
                            tvResult.setText("Add product successfully");
                            etDesc.setText("");
                            etName.setText("");
                            etPrice.setText("");

                        }

                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("result",t.getMessage());
                    }
                });
            }
        });
    }
}