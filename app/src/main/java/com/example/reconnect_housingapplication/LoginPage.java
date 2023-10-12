package com.example.reconnect_housingapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    EditText username,password;
    Button loginbtn, registrationbtn,forgotbtn;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username = findViewById(R.id.et_username);

        password = findViewById(R.id.pass);
        loginbtn = findViewById(R.id.loginButton);
        registrationbtn = findViewById(R.id.registerButton);
        db = new DBHandler(LoginPage.this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();

                String pass = password.getText().toString();

                if (user.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(LoginPage.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(LoginPage.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginPage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(), RegistrationPage.class);
                startActivity(i2);
            }
        });

        forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, fortog.class));
            }
        });

    }
}