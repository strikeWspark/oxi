package com.dryfire.oxi.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.dryfire.oxi.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MaterialButton nextButton;
    private TextInputEditText phoneEdit;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mToolbar = findViewById(R.id.oxi_regd_toolbar);
        phoneEdit = findViewById(R.id.oxi_phoneEdit);
        nextButton = findViewById(R.id.oxi_next);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mToolbar.setNavigationOnClickListener((View v) -> {
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            finish();
        }
       );
        nextButton.setOnClickListener((View v) -> {
            String phone = phoneEdit.getText().toString().trim();
            Intent intent = new Intent(RegistrationActivity.this, OTPVerifyScreen.class);
            intent.putExtra("phone",phone);
            startActivity(intent);
            finish();
        });
    }
}
