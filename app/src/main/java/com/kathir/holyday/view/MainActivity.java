package com.kathir.holyday.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kathir.holyday.R;
import com.kathir.holyday.mvvm.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    private Button loginButton,tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
               // finish();
            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
               // finish();
            }
        });

    }


    private void initUI() {

        loginButton = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.btnsignup);

    }
}
