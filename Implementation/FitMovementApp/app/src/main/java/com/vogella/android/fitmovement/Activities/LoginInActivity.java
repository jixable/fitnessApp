package com.vogella.android.fitmovement.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.vogella.android.fitmovement.R;
import MiddlewareLogic.CouldNotConnectToServerException;
import static MiddlewareLogic.MiddlewareConnection.AreCredentialsRight;


public class LoginInActivity extends AppCompatActivity {

    public static String USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);
        Button login = findViewById(R.id.btLogin);
        Button register = findViewById(R.id.btRegister);
        login.setOnClickListener(v -> {

            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            Snackbar snackbar = Snackbar.make(v, "",Snackbar.LENGTH_SHORT);

            if(usernameString.isEmpty() || passwordString.isEmpty()){
                // show error if the username or password is empty
                snackbar.setText("Please fill in both the username and the password.");
                snackbar.show();
            } else {
                try {
                    if(!AreCredentialsRight(usernameString, passwordString)){
                        // if username != middleware function || password != middleware function, show error
                        snackbar.setText("The password or the username is incorrect. Please try again.");
                        snackbar.show();
                    } else {
                        // change to new activity
                        USERNAME = usernameString;
                        Intent loggedInSuccessful = new Intent(this, ProfileActivity.class);
                        startActivity(loggedInSuccessful);

                    }
                } catch (CouldNotConnectToServerException e) {
                    snackbar.setText(e.getMessage());
                    snackbar.show();
                }
            }
        });
    }
}
