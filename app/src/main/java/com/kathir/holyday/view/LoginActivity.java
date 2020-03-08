package com.kathir.holyday.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kathir.holyday.R;
import com.kathir.holyday.otpview.OtpView;
import com.kathir.holyday.utils.NavigationUtils;
import com.kathir.holyday.utils.SharedPrefUtil;

import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {

    private Button loignbtn;
    private OtpView mPin;
    private String keyvalue;

    private SharedPrefUtil mPrefer;
    //private ProgressBar progressBar;
   private TextView headerText,hederdesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        mPrefer.init(this);
        keyvalue = mPrefer.getInstance().getMPIN();
       // progressBar.setVisibility(View.INVISIBLE);
        hederdesc.setText(mPrefer.getInstance().getUserName());
        loignbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (keyvalue!=null) {
                    if (mPin.getText().toString().equals(keyvalue)) {
                        //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        NavigationUtils.navigateToHome(LoginActivity.this);
                        //progressBar.setVisibility(View.INVISIBLE);
                    } else {
                       // progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivity.this, "Your enter wrong password", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

    }
    private String getTime()
    {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){

            return "Good Morning";

        }else if(timeOfDay >= 12 && timeOfDay < 16){
            return "Good Afternoon";

        }else if(timeOfDay >= 16 && timeOfDay < 21){
            return "Good Evening";
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            return "Good Night";
        }
        return  null;
    }
    private void initUI() {
        loignbtn = findViewById(R.id.validate_button);
        mPin = findViewById(R.id.otp_view);
        headerText=findViewById(R.id.hedertext);
        headerText.setText(getTime());
        hederdesc=findViewById(R.id.hederdesc);
        //progressBar = findViewById(R.id.progress_login_validate);
    }
}

