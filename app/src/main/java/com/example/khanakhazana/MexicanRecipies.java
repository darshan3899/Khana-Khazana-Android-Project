package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MexicanRecipies extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.khanakhazana.EXTRA_TEXT";
    String name;
    CardView nacho,tacos,chicken_mole,salsa_verde;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican_recipies);

        nacho=findViewById(R.id.nacho);
        tacos=findViewById(R.id.tacos);
        chicken_mole=findViewById(R.id.chicken_mole);
        salsa_verde=findViewById(R.id.salsa_verde);

        nacho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="nacho";
                Intent intent=new Intent(MexicanRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }

        });
        tacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name ="tacos";
                Intent intent= new Intent(MexicanRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
        chicken_mole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="enchiladas";
                Intent intent= new Intent(MexicanRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
        salsa_verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="salsa";
                Intent intent = new Intent(MexicanRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
    }
}
