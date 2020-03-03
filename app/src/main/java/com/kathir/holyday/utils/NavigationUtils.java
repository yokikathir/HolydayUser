package com.kathir.holyday.utils;

import android.app.Activity;
import android.content.Intent;


import com.kathir.holyday.view.MainActivity;
import com.kathir.holyday.view.HomeActivity;


public class NavigationUtils {



    public static void navigateToLogin(Activity context) {
        final Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
        context.finish();
    }

    public static void navigateToHome(Activity context) {
        final Intent intent = new Intent(context, HomeActivity.class);

        context.startActivity(intent);
        context.finish();
    }


}
