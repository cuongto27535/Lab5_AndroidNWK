package com.example.lab5_androidnwk;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface API {

    @GET("/lab5/products")
    Call<List<Product>> lab5_getListProduct();
    @DELETE("/lab5/product/{productId}")
    Call<String> lab5_deleteProduct(@Path(value = "productId") String productId);
    @PATCH("/lab5/product/{productId}")
    Call<String> lab5_updateProduct(@Path(value = "productId") String productId,@Body HashMap<String,String> map);
    @POST("/lab5/add_product")
    Call<String> lab5_addProduct(@Body HashMap<String,String> map);
}
