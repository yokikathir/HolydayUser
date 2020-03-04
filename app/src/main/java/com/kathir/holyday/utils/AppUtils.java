package com.kathir.holyday.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.kathir.holyday.home.ProductList;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    private static String TAG = AppUtils.class.getSimpleName();
    private SharedPreferences mSecurePrefs;
    /**
     * This method is here for backwards compatibility reasons. Recommend supplying your own Salt
     *
     * @param context
     * @return Consistent between app restarts, device restarts, factory resets,
     * however cannot be guaranteed on OS updates.
     */
    @SuppressLint("MissingPermission")
    static String getDefaultSalt(Context context) {

        //Android Q removes all access to Serial, fallback to Settings.Secure.ANDROID_ID
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            return getSecureDeviceId(context);
        } else {
            return getDeviceSerialNumber(context);
        }
    }




    @SuppressLint("HardwareIds")
    private static String getSecureDeviceId(Context context) {
        return Settings.Secure.getString(
                context.getContentResolver(),
                Settings.Secure.ANDROID_ID
        );
    }


    public static List<ProductList> getProductList()
    {
        List<ProductList> noti=new ArrayList<>();
        ProductList product1=new ProductList();
        product1.setHouseName("PCBOA HOME1-Poonamallee");
        product1.setPriceValue("RS 100");
        product1.setImageUrl("https://i.ytimg.com/vi/PoFX3AfVPgo/maxresdefault.jpg");
        noti.add(product1);
        ProductList product2=new ProductList();
        product2.setHouseName("PCBOA HOME2-Poonamallee");
        product2.setPriceValue("RS 200");
        product2.setImageUrl("https://i.pinimg.com/originals/a5/67/88/a56788472a77f38b12204034e4aeccde.jpg");
        noti.add(product2);
        ProductList product3=new ProductList();
        product3.setHouseName("PCBOA HOME3-Poonamallee");
        product3.setPriceValue("RS 500");
        product3.setImageUrl("https://wallpapercave.com/wp/wp2464233.jpg");
        noti.add(product3);
        ProductList product4=new ProductList();
        product4.setHouseName("PCBOA HOME1-Poonamallee");
        product4.setPriceValue("RS 100");
        product4.setImageUrl("https://i.ytimg.com/vi/PoFX3AfVPgo/maxresdefault.jpg");
        noti.add(product4);
        ProductList product5=new ProductList();
        product5.setHouseName("PCBOA HOME1-Poonamallee");
        product5.setPriceValue("RS 100");
        product5.setImageUrl("https://wallpapercave.com/wp/wp2464233.jpg");
        noti.add(product5);

        return noti;
    }


    public static int getDeviceWidth(Context ctContext,int percentage)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager)ctContext.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;
        deviceWidth=deviceWidth*percentage/100;
        return deviceWidth;
    }
    public static int getDeviceHeight(Context ctContext,int percentage)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager)ctContext.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.heightPixels;
        deviceWidth=deviceWidth*percentage/100;
        return deviceWidth;
    }

    public static String getDeviceID(Context ctContext)
    {

        return Settings.Secure.getString(ctContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }



    /**
     * Gets the hardware serial number of this device. This only for backwards compatibility
     *
     * @return serial number or Settings.Secure.ANDROID_ID if not available.
     */
    @SuppressLint("MissingPermission")
    private static String getDeviceSerialNumber(Context context) {
        try {
            String deviceSerial = "";
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
                deviceSerial = Build.getSerial();
            } else {
                deviceSerial = Build.SERIAL;
            }

            if (TextUtils.isEmpty(deviceSerial)) {
                return getSecureDeviceId(context);
            } else {
                return deviceSerial;
            }
        } catch (Exception ignored) {
            // Fall back to Android_ID
            return getSecureDeviceId(context);
        }
    }
}

