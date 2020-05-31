package com.iamkosgei.androidacc.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iamkosgei.androidacc.models.MealList;
import com.iamkosgei.androidacc.repo.MealRepo;

public class MealViewModel extends AndroidViewModel {
    private MutableLiveData<MealList> mealListLiveData = new MutableLiveData<>();
    MealRepo mealRepo = new MealRepo();

    public MealViewModel(@NonNull Application application) {
        super(application);
        mealListLiveData = mealRepo.getMeals(application.getApplicationContext());
    }

    public MutableLiveData<MealList> getMeal(){
        return  mealListLiveData;
    }

    public LiveData<Boolean> isLoading(){
     return mealRepo.isLoading();
    }
}
