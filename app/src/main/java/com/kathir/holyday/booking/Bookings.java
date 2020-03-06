package com.kathir.holyday.booking;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.kathir.holyday.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bookings extends Fragment {

View view;
String UserMobile;
ProgressDialog progressDialog;
TextView countBooking , booking;
     public Bookings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activity_property_view for this fragment
       view= inflater.inflate(R.layout.fragment_bookings, container, false);
       //ssseion manager
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setCanceledOnTouchOutside(false);
        countBooking=(TextView)view.findViewById(R.id.countBooking);
        booking = (TextView)view.findViewById(R.id.booingView);
        //progressDialog.setTitle("U");
        progressDialog.setMessage("Please wait...");
      //  progressDialog.show();

        //bookingView
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookingIntent=new Intent(getContext()  , BookingAll.class);
                getActivity().startActivity(bookingIntent);
               // getActivity().overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
            }
        });
       return  view;
    }


}
