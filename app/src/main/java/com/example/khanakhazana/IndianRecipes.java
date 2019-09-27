package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;

public class IndianRecipes extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.khanakhazana.EXTRA_TEXT";
    CardView khandvi,gulab_jamun,pav_bhaji,biryani;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_recipes);

        khandvi=findViewById(R.id.khandvi);
        gulab_jamun=findViewById(R.id.gulab_jamun);
        pav_bhaji=findViewById(R.id.pav_bhaji);
        biryani=findViewById(R.id.biryani);


        khandvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="khandvi";
                Intent intent=new Intent(IndianRecipes.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        gulab_jamun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="gulab_jamun";
                Intent intent=new Intent(IndianRecipes.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        pav_bhaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="pav_bhaji";
                Intent intent=new Intent(IndianRecipes.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
        biryani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="biryani";
                Intent intent=new Intent(IndianRecipes.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
    }
}
