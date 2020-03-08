package com.kathir.holyday.profile;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.kathir.holyday.R;
import com.kathir.holyday.view.LoginActivity;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profilefragments extends Fragment {
    Button logout;
    AlertDialog alertDialog;
    String userName , userMobile , userEmail;
    TextView nameView, mobileView,emailView , fatherName , address, fatherMobile ;
    TextView fodName , fodAddress , fodContactPerson , fodContactMobile;
    RelativeLayout relativeLayout , noBooking;
    HashMap<String  , String> map= new HashMap<>();

    public Profilefragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the activity_property_view for this fragment
        final View view= inflater.inflate(R.layout.fragment_profile, container, false);

        logout=(Button)view.findViewById(R.id.logout_btn);
        userName="Mr."+map.get("name");
        userEmail=map.get("email");
        //Toast.makeText(getContext() , ""+map ,Toast.LENGTH_LONG).show();
        relativeLayout=(RelativeLayout)view.findViewById(R.id.no_detailsFoundsLayout);
        noBooking=(RelativeLayout)view.findViewById(R.id.no_fodFoundsLayout);
        //Text view
        nameView=(TextView)view.findViewById(R.id.name);
        mobileView=(TextView)view.findViewById(R.id.mobile);
        emailView=(TextView)view.findViewById(R.id.emailUser);
        fatherName=(TextView)view.findViewById(R.id.fatherName);
        address=(TextView)view.findViewById(R.id.address);
        fatherMobile=(TextView)view.findViewById(R.id.fatherMobile);
        fodName=(TextView)view.findViewById(R.id.fod_name);
        fodAddress=(TextView)view.findViewById(R.id.fod_address);
        fodContactPerson=(TextView)view.findViewById(R.id.fod_contact_name);
        fodContactMobile=(TextView)view.findViewById(R.id.fod_contact_mobile);
        alertDialog= new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Alert !!");
        alertDialog.setMessage("You will be logout from this device");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent go_to= new Intent(getContext() , LoginActivity.class);
                startActivity(go_to);
                getActivity().finish();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        try {
            mobileView.setText("+91-"+userMobile);
            nameView.setText(userName);
            emailView.setText(userEmail);
            //mShimmerViewContainer.startShimmerAnimation();
        }catch (Exception e){
            e.printStackTrace();
        }

       // mShimmerViewContainer.setVisibility(View.GONE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext() , ""+logout ,Toast.LENGTH_SHORT).show();
                alertDialog.show();
            }
        });

    return  view;
    }



}
