package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ItalianRecipies extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.khanakhazana.EXTRA_TEXT";
    CardView spagetti,risotto,pizza,panna_cotta;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_recipies);
        spagetti=findViewById(R.id.spagetti);
        risotto=findViewById(R.id.risotto);
        pizza=findViewById(R.id.pizza);
        panna_cotta=findViewById(R.id.panna_cotta);

        spagetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="spagetti";
                Intent intent=new Intent(ItalianRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        risotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="risotto";
                Intent intent=new Intent(ItalianRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="pizza";
                Intent intent=new Intent(ItalianRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        panna_cotta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="panna_cota";
                Intent intent=new Intent(ItalianRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
    }
}
