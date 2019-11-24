package com.example.recipeapplication.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
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
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class main_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecipeViewModel recipeViewModel;
    private DrawerLayout drawer;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu,menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);

        Toolbar toolbar=findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final RecipeAdapter adapter = new RecipeAdapter(main_page.this);
        recyclerView.setAdapter(adapter);
        recipeViewModel= ViewModelProviders.of(this).get(RecipeViewModel.class);
        recipeViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                adapter.setRecipes(recipes);
            }
        });
    }




    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()){
            case R.id.soup_item:
                Intent intent_soup = new Intent(main_page.this,soups.class);
                startActivity(intent_soup);
                break;
            case R.id.potato_item:
                Intent intent_potato = new Intent(main_page.this, potato_dishes.class);
                startActivity(intent_potato);
                break;
            case R.id.rice_item:
                Intent intent_rice = new Intent(main_page.this, rice_dishes.class);
                startActivity(intent_rice);
                break;
            case R.id.bread_item:
                Intent bread_intent = new Intent(main_page.this, bread.class);
                startActivity(bread_intent);
                break;
            case R.id.desert:
                Intent desert_intent= new Intent(main_page.this, desert.class);
                startActivity(desert_intent);
                break;

        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.soup:
                Intent soup_intent = new Intent(main_page.this,soups.class);
                startActivity(soup_intent);
                break;
            case R.id.potato:
                Intent potato_intent = new Intent(main_page.this,potato_dishes.class);
                startActivity(potato_intent);
                break;
            case R.id.rice:
                Intent rice_intent = new Intent(main_page.this,rice_dishes.class);
                startActivity(rice_intent);
                break;
            case R.id.bread:
                Intent bread_intent = new Intent(main_page.this,bread.class);
                startActivity(bread_intent);
                break;
            case R.id.desert:
                Intent desert_intent = new Intent(main_page.this,desert.class);
                startActivity(desert_intent);
                break;
        }
        return true;
    }
}
