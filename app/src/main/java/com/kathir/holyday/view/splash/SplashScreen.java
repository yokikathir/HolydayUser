package com.kathir.holyday.view.splash;

import android.os.Bundle;

import com.kathir.holyday.R;
import com.kathir.holyday.utils.NavigationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity implements SplashMVPView.View {

    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashPresenter=new SplashPresenter(this,this,3000);
        mSplashPresenter.startSplash();
    }

    @Override
    public void navigationActivityBasedSession(boolean loginStatus) {

        NavigationUtils.navigateToLogin(this);

    }
}
