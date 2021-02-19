package com.lomaikai.intentexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        editTxtMobile =  findViewById(R.id.editEmail);
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
    }
}