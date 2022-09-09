package com.personal.hiltwithjava.networking;

import com.personal.hiltwithjava.models.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
    Call<List<Products>> getProducts();
}
