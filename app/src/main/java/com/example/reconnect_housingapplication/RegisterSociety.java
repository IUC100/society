package com.example.reconnect_housingapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterSociety extends AppCompatActivity {
    private EditText societyname, address, city, area, pincode, Noofflats, noofwings, societycode, secretoryName, secretoryID, password, confirmpass, flatNo, WingNo, Email, PhoneNo;
    private Button addCourseBtn;
    private DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_society);
            societyname = findViewById(R.id.S_societyname);
            address = findViewById(R.id.S_address);
            city = findViewById(R.id.S_city);
            area = findViewById(R.id.S_area);
            pincode = findViewById(R.id.S_pincode);
            Noofflats = findViewById(R.id.S_noOfFlats);
            noofwings = findViewById(R.id.S_noofwings);
            secretoryName = findViewById(R.id.S_secretoryDetails);
            societycode = findViewById(R.id.S_societycode);

            secretoryID = findViewById(R.id.S_secretoryID);
            password = findViewById(R.id.S_password);
            confirmpass = findViewById(R.id.S_confirmpass);
            flatNo = findViewById(R.id.S_flatno);
            WingNo = findViewById(R.id.S_wingNo);
            Email = findViewById(R.id.S_email);
            PhoneNo = findViewById(R.id.S_phoneno);
            addCourseBtn = findViewById(R.id.btnsumit);

            dbHandler = new DBHandler(RegisterSociety.this);

            // below line is to add on click listener for our add course button.
            addCourseBtn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    //code for field validation
                    if (societyname.length() == 0) {
                        societyname.setError("Enter Society Name ");
                    }
                    if (address.length() == 0) {
                        address.setError("Enter Address");
                    }
                    if (city.length() == 0) {
                        city.setError("Enter Your City");
                    }
                    if (area.length() == 0) {
                        area.setError("Enter your state");
                    }
                    if (pincode.length() == 0) {
                        pincode.setError("Enter your Pincode");
                    }
                    if (Noofflats.length() == 0) {
                        Noofflats.setError("Enter Total no of flats in your society");
                    }
                    if (noofwings.length() == 0) {
                        noofwings.setError("Enter Total no of wings in your society");
                    }
                    if (societycode.length() == 0) {
                        societycode.setError("create your society code");
                    }
                    if (secretoryName.length() == 0) {
                        secretoryName.setError("Enter secretory name");
                    }
                    if (secretoryID.length() == 0) {
                        secretoryID.setError("Enter secretory Id");
                    }
                    if (password.length() == 0) {
                        password.setError(" Password must be 8 digit long");
                    }
                    if (confirmpass.length() == 0) {
                        confirmpass.setError("Re type your password");
                    }
                    if (flatNo.length() == 0) {
                        flatNo.setError("Enter your flatno ");
                    }
                    if (WingNo.length() == 0) {
                        WingNo.setError("Enter  your wingno");
                    }
                    if (Email.length() == 0) {
                        Email.setError("Enter your Email");
                    }
                    if (PhoneNo.length() == 0) {
                        PhoneNo.setError("Enter Phonenumber");
                    }


                    // below line is to get data from all edit text fields.
                    String s_societyname = societyname.getText().toString();
                    String s_address = address.getText().toString();
                    String s_city = city.getText().toString();
                    String s_area = area.getText().toString();
                    String s_pincode = pincode.getText().toString();
                    String s_noflats = Noofflats.getText().toString();
                    String s_nowings = noofwings.getText().toString();
                    String s_societycode = societycode.getText().toString();
                    String s_secretoryname = secretoryName.getText().toString();
                    String s_secretoryID = secretoryID.getText().toString();
                    String s_password = password.getText().toString();
                    String s_confirmpass = confirmpass.getText().toString();
                    String s_flatno = flatNo.getText().toString();
                    String s_wingno = WingNo.getText().toString();
                    String s_email = Email.getText().toString();
                    String s_phonemno = PhoneNo.getText().toString();
                    // validating if the text fields are empty or not.
                    if (s_societyname.isEmpty() && s_address.isEmpty() && s_city.isEmpty() && s_area.isEmpty() && s_pincode.isEmpty() && s_noflats.isEmpty() && s_nowings.isEmpty() && s_societycode.isEmpty() && s_secretoryname.isEmpty() && s_secretoryID.isEmpty() && s_password.isEmpty() && s_confirmpass.isEmpty() && s_flatno.isEmpty() && s_wingno.isEmpty() && s_email.isEmpty() && s_phonemno.isEmpty()) {
                        Toast.makeText(RegisterSociety.this, "Please Enter The All Details!!", Toast.LENGTH_SHORT).show();

                        return;

                    } else {

                        if (s_password.equals(s_confirmpass)) {
                            Boolean checkers = dbHandler.checkalreadyexistsociety(s_societycode);
                            if (checkers == false) {

                                boolean add = dbHandler.addsocietyDetails(s_societyname, s_address, s_city, s_area, s_pincode, s_noflats, s_nowings, s_societycode, s_secretoryname, s_secretoryID, s_password, s_flatno, s_wingno, s_email, s_phonemno);
                                if (add == true) {
                                    alert("Successfull Registration");
                                } else {
                                    Toast.makeText(RegisterSociety.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(RegisterSociety.this, "User already exists! please signin", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterSociety.this, "Password not matching", Toast.LENGTH_SHORT).show();
                        }

                    }


                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.

                    // after adding the data we are displaying a toast message.


                /*
                societyname.setText("");
                address.setText("");
                city.setText("");
                area.setText("");
                pincode.setText("");
                Noofflats.setText("");
                noofwings.setText("");
                societycode.setText("");
                secretoryName.setText("");
                secretoryID.setText("");
                password.setText("");
                flatNo.setText("");
                WingNo.setText("");
                Email.setText("");
                PhoneNo.setText("");*/
                }
            });

        }



    private void alert(String message) {
        AlertDialog dig = new AlertDialog.Builder(RegisterSociety.this)
                .setTitle(message)
                .setMessage("Do you want to go to Login page?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(), RegisterSociety.class);
                        startActivity(i);
                    }
                })
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(), LoginPage.class);//MainActivity:loginactivity class write hear
                        startActivity(i);
                    }
                })
                .create();
        dig.show();
    }
}
