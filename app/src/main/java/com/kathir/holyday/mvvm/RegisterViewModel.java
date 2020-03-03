package com.kathir.holyday.mvvm;

import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class RegisterViewModel extends ViewModel {

    public MutableLiveData<String> regStatus = new MutableLiveData<String>();;


    public void doLogin(String userName, String empno,String staff,String dob, String membership, String phone, String gmail,String gender) {
        UserModel userModel = new UserModel(userName, empno,dob,staff,membership,phone,gmail,gender);
        final int code = userModel.checkUserValidity(userName,empno);
        System.out.println("@Code "+code);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String msg;

                if(code==0) {
                    msg="Login Successful";
                }
                else{
                    msg="Login Fail";
                }
                System.out.println("@LOGIN: "+msg);

                regStatus.postValue(msg);
            }
        }, 2000);
    }

}
