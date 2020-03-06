package com.kathir.holyday.booking;


import android.app.ProgressDialog;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kathir.holyday.R;
import com.kathir.holyday.adapter.BookingsAdapter;
import com.kathir.holyday.model.BookingList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragmentConfirm extends Fragment {
    List<BookingList> list = new ArrayList<BookingList>();

    BookingsAdapter bookingsAdapter;
    String userMobile;
    View view;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    BookingList bookingList= new BookingList();
    public BookingFragmentConfirm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activity_property_view for this fragment
        view= inflater.inflate(R.layout.fragment_booking_fragment_confirm, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.bookingRecyclerView);
        progressDialog= new ProgressDialog(getContext());
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please Wait...");
        //progressDialog.show();

        bookingList.setId("100001");
        bookingList.setBookedOn("YES");
        bookingList.setPropertyName("Kathir");
        bookingList.setBookingNo("123456");
        bookingList.setDateFrom("02.03.2020");
        bookingList.setDateTo("04.03.2020");
        list.add(bookingList);
        setAdapter(list);
        return  view;
    }

    private void setAdapter(List<BookingList> list) {

        bookingsAdapter=new BookingsAdapter(getContext() , list);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bookingsAdapter);
    }
}
