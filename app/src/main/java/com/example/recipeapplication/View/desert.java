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

public class desert extends AppCompatActivity {

    private RecipeViewModel soupRecipeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);

        Toolbar toolbar=findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.desert_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        final RecipeAdapter adapter = new RecipeAdapter(desert.this);
        recyclerView.setAdapter(adapter);

        soupRecipeViewModel= ViewModelProviders.of(this).get(RecipeViewModel.class);

        soupRecipeViewModel.getDesert_recipes()
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
        inflater.inflate(R.menu.desert_menu,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()){
            case R.id.main:
                Intent intent_main = new Intent(desert.this,MainActivity.class);
                startActivity(intent_main);
                break;
            case R.id.potato_item:
                Intent intent_potato = new Intent(desert.this, potato_dishes.class);
                startActivity(intent_potato);
                break;
            case R.id.rice_item:
                Intent intent_rice = new Intent(desert.this, rice_dishes.class);
                startActivity(intent_rice);
                break;
            case R.id.soup_item:
                Intent soups_intent = new Intent(desert.this, soups.class);
                startActivity(soups_intent);
                break;
            case R.id.bread:
                Intent bread_intent= new Intent(desert.this, bread.class);
                startActivity(bread_intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
