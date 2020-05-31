package com.iamkosgei.androidacc.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.iamkosgei.androidacc.R;
import com.iamkosgei.androidacc.databinding.ActivityMainBinding;
import com.iamkosgei.androidacc.models.MealList;
import com.iamkosgei.androidacc.viewModel.MealViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MealAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MealViewModel mealViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MealViewModel.class);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewmodel(mealViewModel);
        mealAdapter = new MealAdapter();



        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(mealAdapter);

        mealViewModel.getMeal().observe(this, new Observer<MealList>() {
            @Override
            public void onChanged(MealList mealList) {
                mealAdapter.setMeals(mealList.getMeals());
            }
        });

    }
}