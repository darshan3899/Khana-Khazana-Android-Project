package com.example.khanakhazana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduction extends AppCompatActivity {
    Button btnOur,btnSpecial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        btnOur=findViewById(R.id.btnOur);
        btnSpecial=findViewById(R.id.btnSpecial);

        btnOur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cusine = new Intent(Introduction.this,Cusines.class);
                startActivity(cusine);
            }
        });
    }
}
