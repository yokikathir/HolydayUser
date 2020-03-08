package com.kathir.holyday.mvvm;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kathir.core.AWSDataService;
import com.kathir.holyday.utils.SharedPrefUtil;


public class RegisterViewModel extends ViewModel {



    public MutableLiveData<String> regStatus = new MutableLiveData<String>();;



    public void doLogin(UserModel userModel, Context ctx) {




        final int code = userModel.checkUserValidity(userModel.getUsername(),userModel.getEmpno());
        System.out.println("@Code "+code);


        UserMtb request=new UserMtb();
        request.setRegID(userModel.getUID());
        if(userModel.getBranch()!=null)
            request.setBranch(userModel.getBranch());
        request.setDisplayName(userModel.getUsername());
        request.setDob(userModel.getDob());
        request.setmNo(userModel.getPhoneno());
        request.setEmailID(userModel.getGmail());
        request.setGender(userModel.getGender());
        request.setEmpID(userModel.getEmpno());
        request.setmDeviceID(Utility.getDeviceID(ctx));
        request.setStaff(userModel.getStaff());
        request.setMemberShip(userModel.getMembership());
        request.setPushStatus("FALSE");
        request.setStatus("P");
        request.setCreatedDate(Utility.getCurrentTime());
        request.setLastlogindate(Utility.getCurrentTime());
        request.setIpaddres(Utility.getIPAddress(false));
        AWSDataService awsDataService=new AWSDataService();
        awsDataService.createContext(ctx,regStatus);
        awsDataService.execute(request);


    }

}
