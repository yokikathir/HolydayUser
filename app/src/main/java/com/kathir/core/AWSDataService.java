package com.kathir.core;

import android.content.Context;
import android.os.AsyncTask;


import androidx.lifecycle.MutableLiveData;

import com.kathir.holyday.mvvm.UserMtb;

public class AWSDataService extends AsyncTask<UserMtb, Void, String> {
    DynamoDBConfiguration dbCOnfi;

    Context mContext;
    MutableLiveData<String> mvpView;
    public void createContext(Context mCt, MutableLiveData<String> regStatus)
    {
        mContext=mCt;
        mvpView=regStatus;
    }
    @Override
    protected String doInBackground(UserMtb... documents) {
        try {


            dbCOnfi = new DynamoDBConfiguration();
            dbCOnfi.initDB(mContext);

            dbCOnfi.createRetailUserMTB(documents[0]);


           // dbCOnfi.createRetailUser(documents[0]);
        }catch (Exception e)
        {
            return "n";
        }
        return "S";
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);

        if(aVoid.equalsIgnoreCase("S"))
        {
            mvpView.postValue("Login Successful");
        }else {
            mvpView.postValue("Login Fail");
        }
    }
}
