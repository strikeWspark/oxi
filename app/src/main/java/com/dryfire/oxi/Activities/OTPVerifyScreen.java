package com.dryfire.oxi.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dryfire.oxi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPVerifyScreen extends AppCompatActivity {

    String verificationBySystem;
    private TextInputEditText otpEdit;
    private MaterialButton verifyButton;
    private FirebaseAuth mAuth;
    private TextView resendCodeButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_verify_screen);

        mAuth = FirebaseAuth.getInstance();

        String phoneNo = getIntent().getStringExtra("phone");
        //Toast.makeText(this, ""+phoneNo, Toast.LENGTH_SHORT).show();

        otpEdit = findViewById(R.id.oxi_otp_verifyEdit);
        resendCodeButton = findViewById(R.id.resend_otp);
        verifyButton = findViewById(R.id.oxi_otp_verify_button);

        sendVerificationCodeToUser(phoneNo);



        resendCodeButton.setOnClickListener((View v) -> sendVerificationCodeToUser(phoneNo) );
        verifyButton.setOnClickListener((View v) -> {
            String code = otpEdit.getText().toString().trim();
            if(code != null){
                verifyCode(code);
            }
        });

    }

    private void sendVerificationCodeToUser(String phoneNo) {
        try {
            PhoneAuthOptions options =
                    PhoneAuthOptions.newBuilder(mAuth)
                            .setPhoneNumber("+91"+phoneNo)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this)
                            .setCallbacks(mCallbacks)
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
            otpEdit.setText(e.getMessage());
        }

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationBySystem = s;
            //otpEdit.setText(verificationBySystem);

        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            Toast.makeText(OTPVerifyScreen.this, "Some text", Toast.LENGTH_SHORT).show();
            String code = phoneAuthCredential.getSmsCode();

            if(code != null){

                verifyCode(code);
            }else{

            }

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(getApplicationContext(),verificationBySystem+e.getMessage(),Toast.LENGTH_SHORT).show();
           // Toast.makeText(OTPVerifyScreen.this, "some Error", Toast.LENGTH_SHORT).show();
        }
    };

    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationBySystem,code);

        signInTheUserByCredential(credential);
    }

    private void signInTheUserByCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(OTPVerifyScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent intent = new Intent(OTPVerifyScreen.this, DashboardActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(),"Some Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.getCurrentUser();

    }
}
