package com.example.reconnect_housingapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MemberRegistration extends AppCompatActivity {
    EditText username, userId, password, repassword, phonenumber, societycode, email, flatno, wingno, noofvehical, type;
    Button submit;
    DBHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_registration);
        username = findViewById(R.id.M_usernamee);
        userId = findViewById(R.id.M_userID);
        password = findViewById(R.id.M_password);
        repassword = findViewById(R.id.M_REpassword);
        phonenumber = findViewById(R.id.M_phone);
        societycode = findViewById(R.id.M_societycode);
        email = findViewById(R.id.M_email);
        flatno = findViewById(R.id.M_flatno);
        wingno = findViewById(R.id.M_wingname);
        submit = findViewById(R.id.btnSubmit);
        noofvehical = findViewById(R.id.M_noofvehical);
        type = findViewById(R.id.M_vehicaltype);

        // creating a new dbhandler class
        // and passing our context to it.

        DB = new DBHandler(MemberRegistration.this);
        // below line is to add on click listener for our add course button.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code for field validation
                if (username.length()==0){
                    username.setError("Enter Name");
                }if (userId.length()==0){
                    userId.setError("Enter UserID");
                }if (password.length()==0){
                    password.setError("Password must be 8 digit long");
                }  if (repassword.length()==0){
                    repassword.setError("Retype your password");
                }if (phonenumber.length()==0){
                    phonenumber.setError("Enter Phone Number");
                } if (societycode.length()==0){
                    societycode.setError("Enter Society Code");
                } if (email.length()==0){
                    email.setError("Enter Email");
                } if (flatno.length()==0){
                    flatno.setError("Enter your Flat Number");
                } if (wingno.length()==0){
                    wingno.setError("Enter your Wing Number");
                }
                if (noofvehical.length()==0){
                    noofvehical.setError("Enter total Number of vehical");
                }
                if (type.length()==0){
                    type.setError("Enter vehical type");
                }





                // below line is to get data from all edit text fields.
                String m_username = username.getText().toString();
                String m_userId = userId.getText().toString();
                String m_password = password.getText().toString();
                String m_repassword = repassword.getText().toString();
                String m_phonenumber = phonenumber.getText().toString();
                String m_societycode = societycode.getText().toString();
                String m_email = email.getText().toString();
                String m_flatno = flatno.getText().toString();
                String m_wingno = wingno.getText().toString();
                String m_noofvehical = noofvehical.getText().toString();
                String m_type = type.getText().toString();


                // validating if the text fields are empty or not.
                if (m_username.isEmpty() && m_userId.isEmpty() && m_password.isEmpty() && m_repassword.isEmpty() && m_phonenumber.isEmpty() && m_societycode.isEmpty() && m_email.isEmpty() && m_flatno.isEmpty() && m_wingno.isEmpty() && m_noofvehical.isEmpty()&& m_type.isEmpty()) {
                    Toast.makeText(MemberRegistration.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }else {

                    if (m_password.equals(m_repassword)) {
                        Boolean checkers = DB.checkalreadyexist(m_userId);
                        if (checkers == false) {


                            boolean add = DB.addMemberDetails(m_username, m_userId, m_password, m_phonenumber, m_societycode, m_email, m_flatno, m_wingno, m_noofvehical, m_type);
                            // after adding the data we are displaying a Dilog message.
                            if (add == true) {
                                alert("Successfull Registration");
                            } else {
                                Toast.makeText(MemberRegistration.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MemberRegistration.this, "User already exists! please signin", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MemberRegistration.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }



                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.

                //Toast.makeText(MemberRegistration.this, "succesfull Registration", Toast.LENGTH_SHORT).show();

               /* username.setText("");
                userId.setText("");
                password.setText("");
                phonenumber.setText("");
                societycode.setText("");
                email.setText("");
                flatno.setText("");
                wingno.setText("");*/

            }
        });




    }

    private void alert(String message) {
        AlertDialog dig = new AlertDialog.Builder(MemberRegistration.this)
                .setTitle(message)
                .setMessage("Do you want to go to Login page?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(),MemberRegistration.class);
                        startActivity(i);
                    }
                })
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(),LoginPage.class);
                        startActivity(i);
                    }
                })
                .create();
        dig.show();
    }
}
