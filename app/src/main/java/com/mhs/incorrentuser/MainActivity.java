package com.mhs.incorrentuser;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize Views
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);

        // Add TextWatcher for Username
        usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateUsername(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });

        // Add TextWatcher for Password
        passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });
    }

    // Validate Username Input
    private void validateUsername(String username) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.baseline_person_24);

        // If the username matches "Fellow.one"
        if (username.equals("Fellow.one")) {
            // Set green border color
            usernameInput.setBackground(ContextCompat.getDrawable(this, R.drawable.spaces_border));

            // Change icon color to green
            drawable.setTint(getResources().getColor(R.color.green));  // Replace 'green' with your desired color

            // Change text color to green
            usernameInput.setTextColor(getResources().getColor(R.color.green));  // Replace 'green' with your desired color

            // Remove any error message
            usernameInput.setError(null);
        } else {
            // Set red border color
            usernameInput.setBackground(ContextCompat.getDrawable(this, R.drawable.red_border));

            // Change icon color to red
            drawable.setTint(getResources().getColor(R.color.red));  // Replace 'red' with your desired color

            // Change text color to red
            usernameInput.setTextColor(getResources().getColor(R.color.red));  // Replace 'red' with your desired color

            // Set the error message
            usernameInput.setError("Incorrect username");
        }

        // Apply the icon color change
        usernameInput.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    // Validate Password Input
    private void validatePassword(String password) {
        if (password.equals("Fellow.one")) {

        } else {

        }
    }
}
