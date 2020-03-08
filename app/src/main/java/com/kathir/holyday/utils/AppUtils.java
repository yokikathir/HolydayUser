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

import com.kathir.core.repository.ProductMTB;
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


    public static List<ProductList> getProductList(List<ProductMTB> mProductList)
    {
        List<ProductList> noti=new ArrayList<>();

        for(int i=0;i<mProductList.size();i++) {
            ProductList product1 = new ProductList();
            product1.setHouseName(mProductList.get(i).getTittle());
            product1.setPriceValue("₹ "+mProductList.get(i).getStaffMemberAmt());
            product1.setImageUrl(mProductList.get(i).getImage1());
            noti.add(product1);


        }

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

