package com.personal.hiltwithjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.personal.hiltwithjava.databinding.ActivityMainBinding;
import com.personal.hiltwithjava.models.Products;
import com.personal.hiltwithjava.viewModels.ProductsViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    ProductsViewModel productsViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productsViewModel.getProducts();

        productsViewModel.getProductsLiveData().observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                if (products != null) {
                        binding.setProduct(products.get(2));

                }
            }
        });
    }
}