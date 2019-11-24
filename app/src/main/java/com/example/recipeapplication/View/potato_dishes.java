package com.example.recipeapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.recipeapplication.Adapters.RecipeAdapter;
import com.example.recipeapplication.Model.Recipe;
import com.example.recipeapplication.R;
import com.example.recipeapplication.ViewModel.RecipeViewModel;

import java.util.List;

public class potato_dishes extends AppCompatActivity {

    private RecipeViewModel potatoRecipeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potato_dishes);

        Toolbar toolbar=findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.potato_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        final RecipeAdapter adapter = new RecipeAdapter(potato_dishes.this);
        recyclerView.setAdapter(adapter);

        potatoRecipeViewModel= ViewModelProviders.of(this).get(RecipeViewModel.class);

        potatoRecipeViewModel.getPotato_dishes_recipes()
                .observe(this, new Observer<List<Recipe>>() {
                    @Override
                    public void onChanged(List<Recipe> recipes) {
                        adapter.setRecipes(recipes);
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.potato_menu,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()){
            case R.id.main:
                Intent intent_main = new Intent(potato_dishes.this,MainActivity.class);
                startActivity(intent_main);
                break;
            case R.id.rice_item:
                Intent intent_potato = new Intent(potato_dishes.this, rice_dishes.class);
                startActivity(intent_potato);
                break;
            case R.id.desert_item:
                Intent intent_desert = new Intent(potato_dishes.this, desert.class);
                startActivity(intent_desert);
                break;
            case R.id.soup_item:
                Intent soups_intent = new Intent(potato_dishes.this, soups.class);
                startActivity(soups_intent);
                break;
            case R.id.bread:
                Intent bread_intent= new Intent(potato_dishes.this, bread.class);
                startActivity(bread_intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
