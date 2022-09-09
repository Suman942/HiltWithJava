package com.personal.hiltwithjava.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.personal.hiltwithjava.networking.ApiInterface;
import com.personal.hiltwithjava.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public ApiInterface getApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
}
