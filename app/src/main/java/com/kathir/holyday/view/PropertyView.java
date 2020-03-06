package com.kathir.holyday.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.google.android.material.appbar.MaterialToolbar;
import com.kathir.holyday.R;
import com.kathir.holyday.adapter.InclusionAdapter;
import com.kathir.holyday.model.InclusionProperty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PropertyView extends AppCompatActivity {
    Intent intent;//= getIntent();
    ImageView imageView;
    String CoverImage, adress, fulladdress, uid, price;
    RequestOptions options;
    TextView locationWrapper, securityMoney, priceView;
    ProgressDialog progressDialog;
    Button bookNow;
    HashMap<String, String> map = new HashMap<>();
    RecyclerView recyclerView;
    InclusionProperty inclusionProperty= new InclusionProperty();
    List<InclusionProperty> inclusionProperties = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_view);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching data...");

        progressDialog.setCanceledOnTouchOutside(false);
     //   progressDialog.show();
        intent = getIntent();

        imageView = (ImageView) findViewById(R.id.imageView);

        locationWrapper = (TextView) findViewById(R.id.locationWrapper);
        securityMoney = (TextView) findViewById(R.id.security_money);
        priceView = (TextView) findViewById(R.id.monthly_payment);
        bookNow = (Button) findViewById(R.id.book_now_initiate);
        recyclerView=(RecyclerView)findViewById(R.id.inclusion_grid);
        recyclerView.setHasFixedSize(true);
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.placeholder_bg_light)
                .error(R.drawable.placeholder_bg_light);

        inclusionProperty.setText("Hotel name");
     //   inclusionProperty.setImage(Constant.ROOT_IMAGE_URL+image);
        inclusionProperties.add(inclusionProperty);
        setInclusionAdapter(inclusionProperties);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Properites");

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
        // Glide.with(mContext).load(mData.get(position).getCoverImage()).apply(options).into(holder.propertyImage);
        Glide.with(getApplicationContext()).load(CoverImage).apply(options).into(imageView);
        locationWrapper.setText(adress);
        securityMoney.setText("Rs. " + price);
        priceView.setText("Rs. " + price);


        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), upload_documents.class);
                startActivity(intent);
            }
        });
    }

    private void setInclusionAdapter(List<InclusionProperty> inclusionProperties) {
        /*
        *  RvAdapter myAdapter = new RvAdapter(this,propertyLists) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);*/
        InclusionAdapter inclusionAdapter= new InclusionAdapter(this , inclusionProperties);
        recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(inclusionAdapter);
    }
}
