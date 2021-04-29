package com.dryfire.oxi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MaterialButton nextButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mToolbar = findViewById(R.id.oxi_regd_toolbar);
        nextButton = findViewById(R.id.oxi_next);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mToolbar.setNavigationOnClickListener((View v) -> {
            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            finish();
        }
       );
        nextButton.setOnClickListener((View v) -> {
            startActivity(new Intent(RegistrationActivity.this,OTPVerifyScreen.class));
            finish();
        });
    }
}
