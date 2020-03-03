package com.kathir.holyday.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kathir.holyday.R;
import com.kathir.holyday.otpview.OtpView;

import com.kathir.holyday.otpview.OnOtpCompletionListener;
import com.kathir.holyday.utils.Keys;
import com.kathir.holyday.utils.SharedPrefUtil;

public class MpinSetupActivity extends AppCompatActivity implements View.OnClickListener,
        OnOtpCompletionListener {
    private OtpView mSetpin, mConfirmpin;
    private Button mvalidatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpin_setup);
        initializeUi();
        setListeners();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.set_pin) {

        } else if (view.getId() == R.id.confirm_pin) {

        } else if (view.getId() == R.id.validate_button) {
            String firstpin=mSetpin.getText().toString();
            String secondpin=mConfirmpin.getText().toString();
            if (firstpin.equals(secondpin)){
                startActivity(new Intent(MpinSetupActivity.this, HomeActivity.class));
               // finish();
                SharedPrefUtil.getInstance().writeString(Keys.KEY_MPIN,secondpin);

            }else {
                Toast.makeText(this, "Enterly wrong pin", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void initializeUi() {
        mSetpin = findViewById(R.id.set_pin);
        mConfirmpin = findViewById(R.id.confirm_pin);
        mvalidatebtn = findViewById(R.id.validate_button);
    }

    private void setListeners() {
        mvalidatebtn.setOnClickListener(this);
        mSetpin.setOtpCompletionListener(this);
        mConfirmpin.setOtpCompletionListener(this);
    }


    @Override
    public void onOtpCompleted(String otp) {

    }
}
