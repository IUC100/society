package com.example.reconnect_housingapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class fortog extends AppCompatActivity {
    private EditText forgotEmail;
    private Button forgotButton;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortog);

        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(fortog.this);

        forgotButton = findViewById(R.id.cirForgotButton);
        forgotEmail = findViewById(R.id.editTextEmailForgot);


        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String email = forgotEmail.getText().toString();
                progressDialog.setTitle("Sending Mail");
                progressDialog.show();

                auth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(fortog.this, "Email Sent", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(fortog.this,LoginPage.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(fortog.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }

/*                String email = forgotEmail.getText().toString();
                progressDialog.setTitle("Sending Mail");
                progressDialog.show();

                auth.sendPasswordResetEmail(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                progressDialog.cancel();
                                Toast.makeText(fortog.this, "Email Sent", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(fortog.this,login.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(fortog.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });*/


        });
    }

}