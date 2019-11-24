package com.example.recipeapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipeapplication.R;

public class Way_Of_Preparation extends AppCompatActivity {


    private TextView prepText;
    private ImageView prepImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way_of_preparation);
        TextView text = findViewById(R.id.prep_text);
        text.setMovementMethod(new ScrollingMovementMethod());
        Toolbar toolbar=findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        prepText=findViewById(R.id.prep_text);
        prepImage=findViewById(R.id.prep_image);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            prepText.setText(bundle.getString("Way of preparation"));
            prepImage.setImageResource(bundle.getInt("Image"));
        }
    }
}
