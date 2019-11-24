package com.example.recipeapplication.DataAcess;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.recipeapplication.Model.Recipe;

import java.util.List;

@Dao
public interface RecipeDAO {

    @Insert
    void insert(Recipe recipe);
    @Delete
    void delete(Recipe recipe);
    @Query("Delete from recipe_data_table8")
    void deleteAllRecipes();

    @Query("Select * from recipe_data_table8")
    LiveData<List<Recipe>> getAllRecipes();

    @Query("Select * from recipe_data_table8 where type='soup'")
    LiveData<List<Recipe>> getAllSoupRecipes();

    @Query("Select * from recipe_data_table8 where type='potato_dish'")
    LiveData<List<Recipe>> getAllPotatoDishRecipes();

    @Query("Select * from recipe_data_table8 where type='rice_dish'")
    LiveData<List<Recipe>> getAllRiceDishRecipes();

    @Query("Select * from recipe_data_table8 where type='bread'")
    LiveData<List<Recipe>> getAllBreadRecipes();

    @Query("Select * from recipe_data_table8 where type='desert'")
    LiveData<List<Recipe>> getAllDesertRecipes();




}