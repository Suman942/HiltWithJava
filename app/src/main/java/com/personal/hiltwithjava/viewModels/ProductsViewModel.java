package com.personal.hiltwithjava.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.personal.hiltwithjava.models.Products;
import com.personal.hiltwithjava.repo.ProductsRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ProductsViewModel extends ViewModel {

    @Inject
    ProductsRepo productsRepo;
    MutableLiveData<List<Products>> productsMutableLiveData = new MutableLiveData<>();

    @Inject
    public ProductsViewModel() {
    }

    public void getProducts(){
        productsRepo.getProducts(productsMutableLiveData);
    }

    public LiveData<List<Products>> getProductsLiveData(){
        return productsMutableLiveData;
    }
}
