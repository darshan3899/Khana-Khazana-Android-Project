package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class SignUp extends AppCompatActivity {

    //private final int CHOOSE_IMAGE=101;
    //FirebaseStorage storage=FirebaseStorage.getInstance();
    //StorageReference profileReference=storage.getReference("image/*");
    //String profileURL;
    //Uri uriProfile;
    EditText etName,etPhone,etPassword,etConfirmPass,etEmail;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    ProgressBar pbBar;
    //ImageView ivProfile;
    //FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth=FirebaseAuth.getInstance();

        pbBar=findViewById(R.id.pbBar);
        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
        etConfirmPass=findViewById(R.id.etConfirmPass);
        btnSignUp=findViewById(R.id.btnSignUp);
        etEmail=findViewById(R.id.etEmail);
/*
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
                uploadImageToFirebase();
                saveImage();
            }
        });*/

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String c_password=etConfirmPass.getText().toString().trim();

                //check if fields are empty
                if(name.isEmpty())
                {
                    etName.setError("Please Enter Name!");
                    etName.requestFocus();
                }
                else if(phone.isEmpty())
                {
                    etPhone.setError("Please Enter Phone Number!");
                    etPhone.requestFocus();
                }
                else if(email.isEmpty())
                {
                    etEmail.setError("Please Enter Email!");
                    etEmail.requestFocus();
                }
                else  if(password.isEmpty())
                {
                    etPassword.setError("Please Enter Password!");
                    etPassword.requestFocus();
                }

                else if(!(password.equals(c_password)))
                {
                    etConfirmPass.setError("Enter Same Password");
                    etConfirmPass.requestFocus();
                }
                //check email
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    etEmail.setError("Please Enter Valid Email!");
                    etEmail.requestFocus();
                }

                //check password length
                if(password.length()<6)
                {
                    etPassword.setError("Minimum Password Length is 6!");
                    etPassword.requestFocus();
                }

               /* user=FirebaseAuth.getCurrentUser();
                if(user.isEmailVerified())
                {
                    tvVerify.setText(R.string.email_verified);
                    tvVerify.setVisibility(View.VISIBLE);
                }
                else
                {
                    tvVerify.setText(R.string.email_not_verified);
                    tvVerify.setVisibility(View.VISIBLE);
                    tvVerify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(SignUp.this,"Email Sent!",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }*/

                pbBar.setVisibility(View.VISIBLE);
                //create user
                if(!(email.isEmpty()&&password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            pbBar.setVisibility(View.GONE);
                            if(task.isSuccessful())
                            {
                                finish();
                                startActivity(new Intent(SignUp.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(SignUp.this,"ERROR SIGNING UP!",Toast.LENGTH_SHORT);
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

/*    private void saveImage() {
        FirebaseUser user=mFirebaseAuth.getCurrentUser();
        if(user!=null)
        {
            UserProfileChangeRequest profile=new UserProfileChangeRequest.Builder().setPhotoUri(Uri.parse(profileURL)).build();
            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignUp.this,"Profile Updated ",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void uploadImageToFirebase() {

        if(uriProfile!=null)
            profileReference.putFile(uriProfile)
                                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                @Override
                                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                    profileURL=taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                                                }
                                            });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CHOOSE_IMAGE && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            uriProfile=data.getData();
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),uriProfile);
                ivProfile.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showImageChooser()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Profile Image"),CHOOSE_IMAGE);
    }*/
}
