package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbBar;
    ImageView ivLogo;
    EditText etEmail,etPassword;
    Button btnLogin;
    TextView tvSignUp,tvForgot;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth=FirebaseAuth.getInstance();

        pbBar=findViewById(R.id.pbBar);
        tvForgot=findViewById(R.id.tvForgot);
        ivLogo=findViewById(R.id.ivLogo);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        tvSignUp=findViewById(R.id.tvSignUp);

        if(user!=null)
        {
            startActivity(new Intent(MainActivity.this,Introduction.class));
        }

        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getInstance().getCurrentUser();
                if(mFirebaseUser!=null)
                {
                    Toast.makeText(MainActivity.this,"You're Logged In",Toast.LENGTH_SHORT);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please Login!",Toast.LENGTH_SHORT);
                }
            }
        };
       btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();

                //check email
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    etEmail.setError("Please Enter Valid Email!");
                    etEmail.requestFocus();
                }

                //check if email and password are empty
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
                //if all values are inserted
                else if(!(email.isEmpty()&&password.isEmpty()))
                {
                    pbBar.setVisibility(View.VISIBLE);
                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            pbBar.setVisibility(View.GONE);
                            if(!task.isSuccessful())
                            {
                                finish();
                                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT);
                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this,Introduction.class));
                            }
                        }
                    });
                }
            }
        });

       tvForgot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ForgotPassword.class));
           }
       });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
