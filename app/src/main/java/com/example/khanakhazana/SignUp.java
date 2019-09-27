package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText etName,etPhone,etPassword,etConfirmPass,etEmail;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth=FirebaseAuth.getInstance();

        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
        etConfirmPass=findViewById(R.id.etConfirmPass);
        btnSignUp=findViewById(R.id.btnSignUp);
        etEmail=findViewById(R.id.etEmail);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String c_password=etConfirmPass.getText().toString().trim();

                //check if fields are empty
                if(email.isEmpty())
                {
                    etEmail.setError("Please Enter Email!");
                    etEmail.requestFocus();
                }
                else if(password.isEmpty())
                {
                    etPassword.setError("Please Enter Password!");
                    etPassword.requestFocus();
                }
                else if(name.isEmpty())
                {
                    etPassword.setError("Please Enter Name!");
                    etPassword.requestFocus();
                }
                else if(phone.isEmpty())
                {
                    etPassword.setError("Please Enter Phone Number!");
                    etPassword.requestFocus();
                }
                else if(!(password.equals(c_password)))
                {
                    etConfirmPass.setError("Enter Same Password");
                    etConfirmPass.requestFocus();
                }
                else if(!(email.isEmpty()&&password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(SignUp.this,"ERROR SIGNING UP!",Toast.LENGTH_SHORT);
                            }
                            else
                            {
                                startActivity(new Intent(SignUp.this,MainActivity.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(SignUp.this,"ERROR!",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
