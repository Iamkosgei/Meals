package com.iamkosgei.androidacc.repo;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.iamkosgei.androidacc.api.ApiClient;
import com.iamkosgei.androidacc.api.ApiService;
import com.iamkosgei.androidacc.models.MealList;
import com.iamkosgei.androidacc.utils.NoConnectivityException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepo {
    private static final String TAG = "MealRepo";
    MutableLiveData<MealList> mealListLiveData = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<MealList> getMeals(Context context) {
        isLoading.setValue(true);
        ApiService apiService = ApiClient.getRetrofit(context).create(ApiService.class);
        Call<MealList> call = apiService.mealList();
        call.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()){
                    mealListLiveData.setValue(response.body());
                    isLoading.setValue(false);
                }
                else {
                    Log.d(TAG, response.message() + "error");

                }
            }
            @Override
            public void onFailure(Call<MealList> call, Throwable t) {
                isLoading.setValue(false);
                if(t instanceof NoConnectivityException) {
                    Log.d(TAG,"check your connectivity");
                }

            }
        });
        return mealListLiveData;
    }
    public MutableLiveData<Boolean> isLoading(){
        return isLoading;
    }
}
