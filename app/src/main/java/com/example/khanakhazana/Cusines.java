package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cusines extends AppCompatActivity {
    Button btnIndian,btnItalian, btnJapanese , btnChinese,btnThai ,btnMexican ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusines);

        btnChinese = findViewById(R.id.btnChinese);
        btnIndian =findViewById(R.id.btnIndian);
        btnJapanese = findViewById(R.id.btnJapanese);
        btnItalian = findViewById(R.id.btnItalian);
        btnMexican = findViewById(R.id.btnMexican);
        btnThai = findViewById(R.id.btnThai);

        btnIndian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Cusines.this,IndianRecipes.class));
            }

        });


        btnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cusines.this,ChineseRecipies.class));
            }
        });

        btnJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cusines.this,JapaneseRecipies.class));
            }
        });

        btnItalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cusines.this,ItalianRecipies.class));
            }
        });
        btnThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cusines.this,ThaiRecipies.class));
            }
        });
    }
}
