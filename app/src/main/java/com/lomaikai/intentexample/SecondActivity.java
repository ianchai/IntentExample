package com.lomaikai.intentexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Change the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registration Successful");
        // Add back button for action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Intent to get the data from first activity
        Intent intentSecond = getIntent();
        String nameReceived = intentSecond.getStringExtra("NAME");
        String emailReceived = intentSecond.getStringExtra("EMAIL");
        String mobileReceived = intentSecond.getStringExtra("MOBILE");

        Toast.makeText(SecondActivity.this, "Registration Successful",Toast.LENGTH_SHORT).show();
        // Create the text view object
        TextView txtNameReceived, txtEmailReceived, txtMobileReceived;
        txtNameReceived=findViewById(R.id.nameView);
        txtEmailReceived=findViewById(R.id.emailView);
        txtMobileReceived=findViewById(R.id.mobileView);
        // Set the data into the view
        txtEmailReceived.setText("Email: "+ emailReceived);
        txtMobileReceived.setText("Mobile: "+mobileReceived);
        txtNameReceived.setText("Name: "+nameReceived);
    }

    // Adding Functionality to the back button on the app bar.

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}