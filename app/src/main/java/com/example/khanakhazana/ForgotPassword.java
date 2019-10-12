package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText etEmail_Forgot;
    Button btnSendPass;
    ProgressBar pbBar;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etEmail_Forgot=findViewById(R.id.etEmail_Forgot);
        pbBar=findViewById(R.id.pbBar);
        btnSendPass=findViewById(R.id.btnSendPass);
        mFirebaseAuth=FirebaseAuth.getInstance();

        btnSendPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail_Forgot.getText().toString().trim();
                mFirebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            pbBar.setVisibility(View.VISIBLE);
                            Toast.makeText(ForgotPassword.this, "Email Sent!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgotPassword.this, MainActivity.class));
                            //pbBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}
