package com.iamkosgei.androidacc.api;

import android.content.Context;

import com.iamkosgei.androidacc.utils.NetworkConnectionInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    public static final String BASE_URL = "https://www.themealdb.com";

    public static Retrofit getRetrofit(Context context){
        if (retrofit == null){
            OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new NetworkConnectionInterceptor(context));
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(oktHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
