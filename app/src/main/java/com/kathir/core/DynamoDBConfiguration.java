package com.kathir.core;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.kathir.core.repository.ProductMTB;
import com.kathir.core.repository.ProductMapperRepository;
import com.kathir.core.repository.UserMapperRepository;
import com.kathir.holyday.mvvm.UserMtb;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamoDBConfiguration {
    private static CognitoCachingCredentialsProvider credentialsProvider;
    private static AmazonDynamoDBClient dbClient;
    private static Context mContext;

    public static void initDB(Context ctContext)
    {
        mContext=ctContext;

        if(dbClient==null)
         dbClient = new AmazonDynamoDBClient(getCredentilProvider());

        dbClient.setRegion(Region.getRegion(Regions.AP_SOUTH_1));

    }
    public static AmazonDynamoDBClient getDBCclient(Context ctContext)
    {
        mContext=ctContext;

        if(dbClient==null)
            dbClient = new AmazonDynamoDBClient(getCredentilProvider());

        dbClient.setRegion(Region.getRegion(Regions.AP_SOUTH_1));
        return  dbClient;

    }
    public static List<ProductMTB> getAllProduct()
    {

        ProductMapperRepository mapper=new ProductMapperRepository(dbClient);
        List<ProductMTB> data=mapper.getProductList();

        return data;


    }
    public static AmazonDynamoDBClient getDBCclientWithoutContext()
    {


        if(dbClient==null)
            dbClient = new AmazonDynamoDBClient(getCredentilProvider());

        dbClient.setRegion(Region.getRegion(Regions.AP_SOUTH_1));
        return  dbClient;

    }

    private static CognitoCachingCredentialsProvider getCredentilProvider()
    {
        credentialsProvider = new CognitoCachingCredentialsProvider(
                mContext, AppConstant.COGNITO_POOL_ID, Regions.AP_SOUTH_1);
        Map<String, String> logins = new HashMap<String, String>();
        logins.put("login.fynlook", "login with Amazon token");
        return  credentialsProvider;
    }
    public static void uploadImage(Context context,String fileName,String filePath)
    {
        mContext=context;


        AmazonS3 s3 = new AmazonS3Client(getCredentilProvider());
        TransferUtility transferUtility = new TransferUtility(s3, mContext);
        final TransferObserver observer = transferUtility.upload(
                AppConstant.BUCKET_NAME,  //this is the bucket name on S3
                fileName, //this is the path and name
                new File(filePath), //path to the file locally
                CannedAccessControlList.PublicRead //to make the file public
        );
        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
                if (state.equals(TransferState.COMPLETED)) {
                    //Success
                } else if (state.equals(TransferState.FAILED)) {
                    //Failed
                }

            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {

            }

            @Override
            public void onError(int id, Exception ex) {

            }
        });
    }

    public static void uploadImageMul(Context context, String fileName, String filePath,String status)
    {
        mContext=context;

     
        AmazonS3 s3 = new AmazonS3Client(getCredentilProvider());
        TransferUtility transferUtility = new TransferUtility(s3, mContext);
        final TransferObserver observer = transferUtility.upload(
                AppConstant.BUCKET_NAME,  //this is the bucket name on S3
                fileName, //this is the path and name
                new File(filePath), //path to the file locally
                CannedAccessControlList.PublicRead //to make the file public
        );
        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

                Toast.makeText(mContext,state.toString(),Toast.LENGTH_LONG).show();
                if (state.equals(TransferState.COMPLETED)) {

                } else if (state.equals(TransferState.FAILED)) {
                    //Failed
                }

            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {

            }

            @Override
            public void onError(int id, Exception ex) {

            }
        });
    }


    public static void uploadImageMulLatest(Context context, String fileName, String filePath,String status)
    {
        mContext=context;
        AmazonS3 s3 = new AmazonS3Client(getCredentilProvider());
        TransferUtility transferUtility = new TransferUtility(s3, mContext.getApplicationContext());
        //UPLOADING_IMAGE=new File(Environment.getExternalStorageDirectory().getPath()+"/Screenshot.png");
        TransferObserver observer = transferUtility.upload( AppConstant.BUCKET_NAME,fileName,new File(filePath));
        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
                // do something

            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                int percentage = (int) (bytesCurrent / bytesTotal * 100);
               // progress.setProgress(percentage);
                //Display percentage transfered to user
            }

            @Override
            public void onError(int id, Exception ex) {
                // do something
                Log.e("Error  ",""+ex );
            }

        });

       /* AmazonS3 s3 = new AmazonS3Client(getCredentilProvider());
        TransferUtility transferUtility = new TransferUtility(s3, mContext);
        final TransferObserver observer = transferUtility.upload(
                AppConstant.BUCKET_NAME,  //this is the bucket name on S3
                fileName, //this is the path and name
                new File(filePath), //path to the file locally
                CannedAccessControlList.PublicRead //to make the file public
        );
        observer.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {

            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {

            }

            @Override
            public void onError(int id, Exception ex) {

            }
        });*/


    }





    public static void createRetailUserMTB(UserMtb userMTB)
    {

        UserMapperRepository mapper=new UserMapperRepository(dbClient);
        mapper.insert(userMTB);


    }


}
