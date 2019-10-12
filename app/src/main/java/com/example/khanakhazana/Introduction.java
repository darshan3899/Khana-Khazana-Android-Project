package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Introduction extends AppCompatActivity {
    Button btnOur,btnSpecial;
    FirebaseAuth mFirebaseAuth;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_log,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                mFirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Introduction.this,MainActivity.class));
                return true;
        }
        return true;
    }

}
