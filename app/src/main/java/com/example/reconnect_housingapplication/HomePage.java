package com.example.reconnect_housingapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.reconnect_housingapplication.databinding.ActivityHomePageBinding;

import java.util.Locale;


public class HomePage extends AppCompatActivity {
    GridLayout Grid;
    Button bell,logout;
    private ActivityHomePageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bell = findViewById(R.id.bell);
        logout = findViewById(R.id.logout);
        binding= ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeLanguage();
            }
        });



        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), notice.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert("Do you want to Logout");
            }

            private void alert(String message) {
                AlertDialog dig = new AlertDialog.Builder(HomePage.this)
                        .setTitle(message)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent i = new Intent(getApplicationContext(),HomePage.class);
                                startActivity(i);
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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
        });
        //getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">"+getString(R.string.app_name)+"</font>"));
        Grid=(GridLayout)findViewById(R.id.mainGridLayout);
        setSignalEvent(Grid);
    }

    private void changeLanguage() {
        final String languages[] = {"English", "Hindi"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("");
                    recreate();
                } else if (i == 1) {
                    setLocale("hi");
                    recreate();
                }
            }
        });
        mBuilder.create();
        mBuilder.show();
    }
    private void setLocale(String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext()
        .getResources().getDisplayMetrics());

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {

        menu.add(menu.NONE, 0, 1, "settings");
        menu.add(menu.NONE, 1, 2, "ratings");
        menu.add(menu.NONE, 2, 3, "mode");
        menu.add(menu.NONE, 3, 4, "help");
        menu.add(menu.NONE, 4, 5, "Notice");
        return true;
    }

    private void setSignalEvent(GridLayout grid) {
        for (int i=0; i<Grid.getChildCount();i++) {
            CardView cardView = (CardView) Grid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(HomePage.this, UserDetails.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(HomePage.this, Maintenance.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(HomePage.this, VisitorsDetails.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(HomePage.this, Complain.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(HomePage.this, RentalsDetails.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        Intent intent = new Intent(HomePage.this, sellhouse.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        Intent intent = new Intent(HomePage.this, parking.class);
                        startActivity(intent);
                    } else if (finalI == 7) {
                        Intent intent = new Intent(HomePage.this, AdminDetails.class);
                        startActivity(intent);
                    } else if (finalI == 8) {
                        Intent intent = new Intent(HomePage.this, help.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}