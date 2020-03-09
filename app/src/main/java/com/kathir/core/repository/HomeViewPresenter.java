package com.kathir.core.repository;

import android.content.Context;

import com.kathir.core.ListProduDataService;
import com.kathir.holyday.home.HomeMVPView;


public class HomeViewPresenter implements HomeMVPView.presenter {

    private HomeMVPView.View mvpViewData;

    private Context ctContextView;

    /** Duration of wait **/
    private  int SPLASH_DISPLAY_LENGTH = 3000;





    public HomeViewPresenter(HomeMVPView.View mvpview, Context ctContext)
    {
        mvpViewData=mvpview;
        ctContextView=ctContext;



    }


    @Override
    public void getAllProduct() {

    }

    @Override
    public void getAllPost(String registerID, int start, int end) {
        mvpViewData.showPopUp();
        ListProduDataService awsDataService=new ListProduDataService();
        awsDataService.createContext(ctContextView,mvpViewData);
        awsDataService.execute(registerID);
    }

    @Override
    public void uploadPost(ProductMTB mProduct) {

    }

    @Override
    public void getUserDetail(String regID) {

    }

    @Override
    public void getpushList(String regID) {

    }


}
