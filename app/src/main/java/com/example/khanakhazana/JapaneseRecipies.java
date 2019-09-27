package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JapaneseRecipies extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.khanakhazana.EXTRA_TEXT";
    CardView sushi, onigiri, sashimi, tempura;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese_recipies);


        sushi = findViewById(R.id.sushi);
        onigiri = findViewById(R.id.ongiri);
        sashimi = findViewById(R.id.sashimi);
        tempura = findViewById(R.id.tempura);

        sushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="sushi";
                Intent intent=new Intent(JapaneseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        onigiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="onigiri";
                Intent intent=new Intent(JapaneseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        sashimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="sashimi";
                Intent intent=new Intent(JapaneseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        tempura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="tempura";
                Intent intent=new Intent(JapaneseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
    }
}