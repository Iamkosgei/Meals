package com.iamkosgei.androidacc.api;

import com.iamkosgei.androidacc.models.MealList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/json/v1/1/filter.php?c=Beef")
    Call<MealList> mealList();
}
