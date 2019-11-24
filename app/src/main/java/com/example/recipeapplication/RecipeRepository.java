package com.example.recipeapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.recipeapplication.DataAcess.RecipeDAO;
import com.example.recipeapplication.DataAcess.RecipeDatabase;
import com.example.recipeapplication.Model.Recipe;

import java.util.List;

public class RecipeRepository {
    private RecipeDAO recipeDAO;
    private LiveData<List<Recipe>> recipes;
    private LiveData<List<Recipe>> soup_recipes;
    private LiveData<List<Recipe>> potato_dishes_recipes;
    private LiveData<List<Recipe>> rice_dishes_recipes;
    private LiveData<List<Recipe>> bread_recipes;
    private LiveData<List<Recipe>> desert_recipes;

    public RecipeRepository(Application application){

        RecipeDatabase database = RecipeDatabase.getInstance(application);
        recipeDAO=database.noteDao();
        recipes=recipeDAO.getAllRecipes();
        soup_recipes=recipeDAO.getAllSoupRecipes();
        potato_dishes_recipes=recipeDAO.getAllPotatoDishRecipes();
        rice_dishes_recipes=recipeDAO.getAllRiceDishRecipes();
        bread_recipes=recipeDAO.getAllBreadRecipes();
        desert_recipes=recipeDAO.getAllDesertRecipes();
    }

    public void insert(Recipe recipe){

        new InsertRecipeAssyncTask(recipeDAO).equals(recipe);
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


    private static class InsertRecipeAssyncTask extends AsyncTask<Recipe,Void,Void> {
        private RecipeDAO recipeDAO;
        private InsertRecipeAssyncTask(RecipeDAO recipeDAO){
            this.recipeDAO=recipeDAO;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDAO.insert(recipes[0]);
            return null;
        }
    }
}
