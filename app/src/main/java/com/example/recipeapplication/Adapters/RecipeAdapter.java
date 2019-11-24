package com.example.recipeapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapplication.Model.Recipe;
import com.example.recipeapplication.R;
import com.example.recipeapplication.View.Way_Of_Preparation;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    private Context mContext;
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeAdapter(Context mContext){
        this.mContext=mContext;
    }
    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recipe_item,parent,false);
        return new RecipeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);
        holder.title.setText(currentRecipe.getTitle());
        holder.imageView.setImageResource(currentRecipe.getImage());
        holder.products.setText(currentRecipe.getProducts());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Way_Of_Preparation.class);
                intent.putExtra("Image", recipes.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Way of preparation", recipes.get(holder.getAdapterPosition()).getWay_of_prep());
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes=recipes;
        notifyDataSetChanged();
    }
    class  RecipeHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView products;
        private CardView mCardView;


        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.text_title);
            products = itemView.findViewById(R.id.text_products);
            mCardView = itemView.findViewById(R.id.my_card_view);
        }
    }
}
