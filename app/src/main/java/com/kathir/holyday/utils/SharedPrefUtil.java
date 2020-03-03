package com.kathir.holyday.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.security.Key;
import java.util.Random;

public class SharedPrefUtil {
    private static final String TAG = SharedPrefUtil.class.getSimpleName();

    private static SharedPrefUtil mThis = new SharedPrefUtil();

    private SharedPreferences mPreference = null;

    private SharedPrefUtil() {

    }

    public static void init(Context context) {
        mThis.setData(context);
    }

    public static SharedPrefUtil getInstance() {
        return mThis;
    }

    private void setData(Context context) {
        mPreference = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public void clearPreference(String key) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.remove(key).apply();
    }

    public void writeString(String tag, String data) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putString(tag, data).apply();
    }
    public String getTrackingDistinctId() {

        String ret =getDisticntID();
        if (ret == null) {
            ret = generateDistinctId();
           writeString("MIXPANEL_DISTINCT_ID_NAME",ret);
        }

        return ret;
    }

    private String getDisticntID()
    {
        return readString("MIXPANEL_DISTINCT_ID_NAME");
    }

    // These disinct ids are here for the purposes of illustration.
    // In practice, there are great advantages to using distinct ids that
    // are easily associated with user identity, either from server-side
    // sources, or user logins. A common best practice is to maintain a field
    // in your users table to store mixpanel distinct_id, so it is easily
    // accesible for use in attributing cross platform or server side events.
    private String generateDistinctId() {
        final Random random = new Random();
        final byte[] randomBytes = new byte[32];
        random.nextBytes(randomBytes);
        return Base64.encodeToString(randomBytes, Base64.NO_WRAP | Base64.NO_PADDING);
    }

    public void setLoginDetails(String userID, String sessionToken, boolean loginStatus, String username, String email)
    {
        writeString("EMAIL",email);
        writeString("USERNAME",username);
        writeString("USERID",userID);
        writeString("SESSSIONID",sessionToken);
        writeBoolean("ISLOGIN",loginStatus);
    }

    public void setLogin(boolean is)
    {
        writeBoolean("ISLOGIN",is);
    }

    public void setPhone(String data)
    {
        writeString("MNO",data);
    }
    public String getPhone()
    {
        return readString("MNO");

    }
    public void setCouponCode(String data)
    {
        writeString("CPC",data);
    }
    public String getCouponCode()
    {
        return readString("CPC");

    }
    public void clearCoupon()
    {
        clear("CPC");

    }
    public void logout()
    {
        clear("USERNAME");
        clear("USERID");
        clear("SESSSIONID");
        clear("ISLOGIN");
    }

    public String getUserID()
    {
       return readString("USERID");

    }
    public String getUserEmail()
    {
        return readString("EMAIL");

    }
    public String getUserName()
    {
        return readString("USERNAME");

    }
    public String getSessionToken()
    {
        return readString("SESSSIONID");

    }
    public boolean isLoginStatus()
    {
        return readBoolean("ISLOGIN");

    }
    public String getMpinId() {

        return mPreference.getString(Keys.KEY_MPIN, "");
    }

    public String readString(String tag) {
        if (mPreference == null) {
            return "";
        }
        return mPreference.getString(tag, "");
    }

    public void writeBoolean(String tag, boolean data) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putBoolean(tag, data).apply();
    }

    public boolean readBoolean(String tag) {
        return mPreference != null && mPreference.getBoolean(tag, false);
    }

    public void clear(String tag) {
        mPreference.edit().remove(tag).apply();
    }


}
