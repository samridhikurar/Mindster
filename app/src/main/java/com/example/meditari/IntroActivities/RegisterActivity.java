package com.example.meditari.IntroActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meditari.Extras.Users;
import com.example.meditari.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    EditText regName;
    EditText regEmail;
    EditText regPass;
    EditText regConfirmPass;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    AppCompatButton signUpButton;
    TextView signInText;
    ImageView profileImage;
    ProgressDialog progressDialog;

    Uri imageUri;
    String imgUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        askForFullScreen();

        auth=FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        storage=FirebaseStorage.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        regName=findViewById(R.id.regName);
        regEmail=findViewById(R.id.regEmail);
        regPass=findViewById(R.id.regPass);
        regConfirmPass=findViewById(R.id.regConfirmPass);
        signUpButton=findViewById(R.id.signUpButton);
        signInText=findViewById(R.id.signInText);
        profileImage=findViewById(R.id.profileImage);


        signUpButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                progressDialog.show();
                                                String name = regName.getEditableText().toString();
                                                String email = regEmail.getEditableText().toString();
                                                String password = regPass.getEditableText().toString();
                                                String cPassword = regConfirmPass.getEditableText().toString();

                                                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(cPassword) || TextUtils.isEmpty(password)) {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(RegisterActivity.this, "Enter valid data", Toast.LENGTH_SHORT).show();
                                                } else if (!email.matches(emailPattern)) {
                                                    progressDialog.dismiss();
                                                    regEmail.setError("Invalid Email");
                                                    Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                                                } else if (password.length() <= 6) {
                                                    progressDialog.dismiss();
                                                    regPass.setError("Invalid password");
                                                    Toast.makeText(RegisterActivity.this, "Please enter more than 6 characters", Toast.LENGTH_SHORT).show();
                                                } else if (!password.equals(cPassword)) {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                            if (task.isSuccessful()) {
                                                                //Toast.makeText(RegisterActivity.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                                                                DatabaseReference reference = database.getReference().child("users").child(auth.getUid());
                                                                StorageReference storageReference = storage.getReference().child("upload").child(auth.getUid());

                                                                    imgUri = "https://firebasestorage.googleapis.com/v0/b/meditari-9da15.appspot.com/o/registerscreen.jpg?alt=media&token=ba7bbddf-ff62-4add-bd44-c37992b098ef";
                                                                    Users users = new Users(auth.getUid(), name, email, imgUri);
                                                                    reference.setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                        @Override
                                                                        public void onComplete(@NonNull Task<Void> task) {
                                                                            if (task.isSuccessful()) {
                                                                                progressDialog.dismiss();
                                                                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                                                            } else {
                                                                                Toast.makeText(RegisterActivity.this, "Error in creating a new user", Toast.LENGTH_SHORT).show();
                                                                            }
                                                                        }
                                                                    });
                                                            }else {
                                                                progressDialog.dismiss();
                                                                Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        });

                        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    private void askForFullScreen(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE
        );
    }
}