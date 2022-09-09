package com.personal.hiltwithjava.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.personal.hiltwithjava.models.Products;
import com.personal.hiltwithjava.networking.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepo {
    @Inject
    ApiInterface apiInterface;
    @Inject
    public ProductsRepo(){
    }

    public void getProducts(MutableLiveData<List<Products>> mutableLiveData){
        apiInterface.getProducts().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.isSuccessful()){
                    Log.d("Products","success");
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.d("Products","error: "+t.getMessage());

            }
        });
    }

}
