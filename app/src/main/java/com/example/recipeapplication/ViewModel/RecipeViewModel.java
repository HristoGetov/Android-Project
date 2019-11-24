package com.example.recipeapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recipeapplication.Model.Recipe;
import com.example.recipeapplication.RecipeRepository;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private RecipeRepository recipeRepository;
    private LiveData<List<Recipe>> recipes;
    private LiveData<List<Recipe>> soup_recipes;
    private LiveData<List<Recipe>> potato_dishes_recipes;
    private LiveData<List<Recipe>> rice_dishes_recipes;
    private LiveData<List<Recipe>> bread_recipes;
    private LiveData<List<Recipe>> desert_recipes;
    public RecipeViewModel(@NonNull Application application) {
        super(application);
        recipeRepository= new RecipeRepository(application);
        recipes = recipeRepository.getRecipes();
        soup_recipes=recipeRepository.getSoup_recipes();
        potato_dishes_recipes=recipeRepository.getPotato_dishes_recipes();
        rice_dishes_recipes=recipeRepository.getRice_dishes_recipes();
        bread_recipes=recipeRepository.getBread_recipes();
        desert_recipes=recipeRepository.getDesert_recipes();
    }

    public void insert(Recipe recipe){
        recipeRepository.insert(recipe);
    }
    public LiveData<List<Recipe>> getRecipes(){
        return recipes;
    }
    public LiveData<List<Recipe>> getSoup_recipes(){
        return soup_recipes;
    }
    public LiveData<List<Recipe>> getPotato_dishes_recipes(){
        return potato_dishes_recipes;
    }
    public LiveData<List<Recipe>> getRice_dishes_recipes(){
        return rice_dishes_recipes;
    }
    public LiveData<List<Recipe>> getBread_recipes(){
        return bread_recipes;
    }
    public LiveData<List<Recipe>> getDesert_recipes(){
        return desert_recipes;
    }

}
