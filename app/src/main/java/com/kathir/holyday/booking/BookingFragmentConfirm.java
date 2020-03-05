package com.kathir.holyday.booking;


import android.app.ProgressDialog;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kathir.holyday.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragmentConfirm extends Fragment {
    String userMobile;
    View view;
    ProgressDialog progressDialog;
    public BookingFragmentConfirm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_booking_fragment_confirm, container, false);
       /* progressDialog= new ProgressDialog(getContext());
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();*/
        return  view;
    }


}
