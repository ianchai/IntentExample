package com.lomaikai.intentexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Change action bar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MMU Employee Registration Page");

        // Create objects to link to UI elements
        EditText editTxtName, editTxtEmail, editTxtMobile;
        Button btnRegister, btnVisit, btnLocate;
        editTxtName = findViewById(R.id.editName);
        editTxtMobile =  findViewById(R.id.editMobile);
        editTxtEmail = findViewById(R.id.editEmail);
        btnLocate = findViewById(R.id.buttonLocate);
        btnRegister = findViewById(R.id.buttonRegister);
        btnVisit = findViewById(R.id.buttonVisit);

        // Create listener for register button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get what the user has entered into the text fields
                String nameInput = editTxtName.getText().toString();
                String emailInput = editTxtEmail.getText().toString();
                String mobileInput = editTxtMobile.getText().toString();

                // Create intent object
                Intent intentPage = new Intent(MainActivity.this,SecondActivity.class);
                // Pass data to second activity
                intentPage.putExtra("NAME",nameInput);
                intentPage.putExtra("EMAIL",emailInput);
                intentPage.putExtra("MOBILE",mobileInput);
                // Start the intent activity
                startActivity(intentPage);
            }
        });

        // Add the functionality for the visit us button
        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add intent to jump to MMU website
                Intent intentVisit = new Intent(Intent.ACTION_VIEW);
                intentVisit.setData(Uri.parse("https://www.mmu.edu.my"));
                // Check if there's a package or app to handle the intent, so as not to crash the activity and load something that's not available on the device
                if (intentVisit.resolveActivity(getPackageManager())!=null)
                    startActivity(intentVisit);
                else {
                    // To catch the error, print a message to the log
                    Toast.makeText(MainActivity.this, R.string.no_web_browser, Toast.LENGTH_SHORT).show();
                    Log.d("ImplicitIntents", "Cannot handle");
                }
            }
        });

        // Add the functionality for the local us button
        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the loation of the place to visit
                String visitLocation = "Multimedia University, Cyberjaya";
                // Take and create the string that will be passed as a geolocation
                // The result of this will be a very long text
                Uri addressUri = Uri.parse("geo:2.242665696,102.272832242?q="+visitLocation);
                Intent intentLocateUs = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intentLocateUs.resolveActivity(getPackageManager())!=null)
                    startActivity(intentLocateUs);
                else {
                    Toast.makeText(MainActivity.this, "No suitable map app available", Toast.LENGTH_SHORT).show();
                    Log.d("ImplicitIntents", "Cannot handle");
                }
            }
        });
    }
}