package com.kathir.holyday.utils;

import android.app.Activity;
import android.content.Intent;


import com.kathir.holyday.fragment.HomeFragment;
import com.kathir.holyday.home.HomeScreen;
import com.kathir.holyday.view.LoginActivity;
import com.kathir.holyday.view.MainActivity;
import com.kathir.holyday.view.HomeActivity;


public class NavigationUtils {

    public static void navigateMain(Activity context) {
        final Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
        context.finish();
    }


    public static void navigateToLogin(Activity context) {
        final Intent intent = new Intent(context, LoginActivity.class);

        context.startActivity(intent);
        context.finish();
    }

    public static void navigateToHome(Activity context) {
        final Intent intent = new Intent(context, HomeScreen.class);

        context.startActivity(intent);
        context.finish();
    }


}
