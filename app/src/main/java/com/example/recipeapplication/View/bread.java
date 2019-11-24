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

public class bread extends AppCompatActivity {

    private RecipeViewModel soupRecipeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);

        Toolbar toolbar=findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.bread_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        final RecipeAdapter adapter = new RecipeAdapter(bread.this);
        recyclerView.setAdapter(adapter);

        soupRecipeViewModel= ViewModelProviders.of(this).get(RecipeViewModel.class);

        soupRecipeViewModel.getBread_recipes()
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
        inflater.inflate(R.menu.bread_menu,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()){
            case R.id.main:
                Intent intent_main = new Intent(bread.this,MainActivity.class);
                startActivity(intent_main);
                break;
            case R.id.potato_item:
                Intent intent_potato = new Intent(bread.this, potato_dishes.class);
                startActivity(intent_potato);
                break;
            case R.id.rice_item:
                Intent intent_rice = new Intent(bread.this, rice_dishes.class);
                startActivity(intent_rice);
                break;
            case R.id.soup_item:
                Intent soups_intent = new Intent(bread.this, soups.class);
                startActivity(soups_intent);
                break;
            case R.id.desert:
                Intent desert_intent= new Intent(bread.this, desert.class);
                startActivity(desert_intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
