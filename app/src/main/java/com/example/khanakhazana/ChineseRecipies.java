package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChineseRecipies extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.khanakhazana.EXTRA_TEXT";
    CardView baozi,fried_rice,spring_roll,turnip_cake;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_recipies);

        baozi=findViewById(R.id.baozi);
        fried_rice=findViewById(R.id.fried_rice);
        spring_roll=findViewById(R.id.spring_roll);
        turnip_cake=findViewById(R.id.turnip_cake);

        baozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="baozi";
                Intent intent=new  Intent(ChineseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        fried_rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="fried_rice";
                Intent intent=new  Intent(ChineseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        spring_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="spring_roll";
                Intent intent=new  Intent(ChineseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

        turnip_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name="turnip_cake";
                Intent intent=new  Intent(ChineseRecipies.this,Recipies.class);
                intent.putExtra(EXTRA_TEXT,name);
                startActivity(intent);
            }
        });

    }
}
