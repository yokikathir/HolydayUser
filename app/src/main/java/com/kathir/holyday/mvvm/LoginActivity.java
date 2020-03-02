package com.kathir.holyday.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kathir.holyday.R;
import com.kathir.holyday.view.OTPActivity;
import com.kathir.holyday.view.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    private TextView tvRegister;
    private EditText etLoginGmail, etLoginPassword;
    private Button loginButton;
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginResult();
            }
        });
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.loginStatus.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String str) {
                progressBar.setVisibility(View.INVISIBLE);
                System.out.println("onChanged: " + str);
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, OTPActivity.class));
            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

    }

    private void loginResult() {
        String email = etLoginGmail.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();
        loginViewModel.doLogin(email, password);
    }

    private void initUI() {
        tvRegister = findViewById(R.id.tvRegister);
        etLoginGmail = findViewById(R.id.etLogGmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        loginButton = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progress_login);
        progressBar.setVisibility(View.INVISIBLE);

    }
}
