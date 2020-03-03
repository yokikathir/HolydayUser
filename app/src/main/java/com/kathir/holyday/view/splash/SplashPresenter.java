package com.kathir.holyday.view.splash;

import android.content.Context;
import android.os.Handler;

import com.kathir.holyday.utils.SharedPrefUtil;


public class SplashPresenter implements SplashMVPView.presenter {

    private SplashMVPView.View mvpViewData;

    private Context ctContextView;

    /** Duration of wait **/
    private  int SPLASH_DISPLAY_LENGTH = 3000;

    SharedPrefUtil prefUtil;





    public SplashPresenter(SplashMVPView.View mvpview, Context ctContext, int time)
    {
        mvpViewData=mvpview;
        ctContextView=ctContext;

        SPLASH_DISPLAY_LENGTH=time;
        prefUtil.init(ctContext);

    }

    @Override
    public void startSplash() {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {



                mvpViewData.navigationActivityBasedSession(prefUtil.getInstance().isLoginStatus());
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
