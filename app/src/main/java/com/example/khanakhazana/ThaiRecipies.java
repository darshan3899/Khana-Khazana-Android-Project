package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThaiRecipies extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.khanakhazana.EXTRA_TEXT";
    CardView larb,thai_curry,satay,pad_thai;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_recipies);

        larb=findViewById(R.id.larb);
        thai_curry=findViewById(R.id.thai_curry);
        satay=findViewById(R.id.satay);
        pad_thai=findViewById(R.id.pad_thai);

        larb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="larb";
                Intent intent=new Intent(ThaiRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        thai_curry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="thai_curry";
                Intent intent=new Intent(ThaiRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        satay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="satay";
                Intent intent=new Intent(ThaiRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        pad_thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="pad_thai";
                Intent intent=new Intent(ThaiRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });
    }
}
