package com.kathir.core;

import android.content.Context;
import android.os.AsyncTask;

import com.kathir.core.repository.ProductMTB;
import com.kathir.holyday.home.HomeMVPView;

import java.util.List;

public class ListProduDataService extends AsyncTask<String, Void, List<ProductMTB>> {
    DynamoDBConfiguration dbCOnfi;

    Context mContext;

    HomeMVPView.View mvpView;

    public void createContext(Context mCt, HomeMVPView.View mvpViewData)
    {
        mContext=mCt;
        mvpView=mvpViewData;
    }
    @Override
    protected List<ProductMTB> doInBackground(String... documents) {
        try {


            dbCOnfi = new DynamoDBConfiguration();
            dbCOnfi.initDB(mContext);



           return dbCOnfi.getAllProduct();


           // dbCOnfi.createRetailUser(documents[0]);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<ProductMTB> aVoid) {
        super.onPostExecute(aVoid);
        mvpView.dismissPopUp();
        if(aVoid!=null)
        {
            mvpView.showProductsList(aVoid);
        }else{
            mvpView.validationError("NO_DATA");
        }




    }
}
