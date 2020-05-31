package com.iamkosgei.androidacc.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamkosgei.androidacc.R;
import com.iamkosgei.androidacc.models.Meal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    List<Meal> meals = new ArrayList<>();
    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item,parent,false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        holder.setMeal(meals.get(position));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public void setMeals(List<Meal> meals){
        this.meals = meals;
        notifyDataSetChanged();
    }

    class MealViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name;
        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.meal_image);
            name = itemView.findViewById(R.id.meal_name);
        }

        public void setMeal(Meal meal){
            name.setText(meal.getName());
            Picasso.get().load(meal.getImage()).into(imageView);
        }


    }
}
