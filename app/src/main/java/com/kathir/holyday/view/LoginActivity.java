package com.kathir.holyday.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kathir.holyday.R;
import com.kathir.holyday.otpview.OtpView;
import com.kathir.holyday.utils.NavigationUtils;
import com.kathir.holyday.utils.SharedPrefUtil;

public class LoginActivity extends AppCompatActivity {

    private Button loignbtn;
    private OtpView mPin;
    private String keyvalue;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        SharedPrefUtil.init(this);
        keyvalue = SharedPrefUtil.getInstance().getMpinId();
        progressBar.setVisibility(View.INVISIBLE);
        loignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (keyvalue!=null) {
                            if (mPin.getText().toString().equals(keyvalue)) {
                                //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                NavigationUtils.navigateToHome(LoginActivity.this);
                                progressBar.setVisibility(View.INVISIBLE);
                            } else {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(LoginActivity.this, "Your enter wrong password", Toast.LENGTH_LONG).show();

                            }
                        }else {
                            Toast.makeText(LoginActivity.this, "Your enter the wrong password", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }

                    }
                }, 2000);
            }
        });

    }
    private void initUI() {
        loignbtn = findViewById(R.id.validate_button);
        mPin = findViewById(R.id.otp_view);
        progressBar = findViewById(R.id.progress_login_validate);
    }
}
