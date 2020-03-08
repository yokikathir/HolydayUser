package com.kathir.holyday.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.google.android.material.appbar.MaterialToolbar;
import com.kathir.core.repository.ProductMTB;
import com.kathir.holyday.R;
import com.kathir.holyday.adapter.InclusionAdapter;
import com.kathir.holyday.model.InclusionProperty;
import com.kathir.holyday.utils.GlideUtil;

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
    TextView locationWrapper, securityMoney, priceView,retiredAmt;
    ProgressDialog progressDialog;
    Button bookNow;
    HashMap<String, String> map = new HashMap<>();
    RecyclerView recyclerView;
    TextView locationdetail;
    InclusionProperty inclusionProperty= new InclusionProperty();
    List<InclusionProperty> inclusionProperties = new ArrayList<>();
    WebView mWebview;

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
        Intent intent = getIntent();
        ProductMTB productMTB = (ProductMTB) intent.getSerializableExtra("DETAILVIEW");


        locationWrapper = (TextView) findViewById(R.id.locationWrapper);
        locationWrapper.setText(productMTB.getTittle());
        mWebview=findViewById(R.id.webview);
        mWebview.loadUrl(productMTB.getMapurl());
        locationdetail=findViewById(R.id.locationdetail);
        locationdetail.setText(productMTB.getDescription());
        securityMoney = (TextView) findViewById(R.id.security_money);
        securityMoney.setText("Rs. " +productMTB.getStaffMemberAmt());
        priceView = (TextView) findViewById(R.id.monthly_payment);
        priceView.setText("Rs. " +productMTB.getStaffNonMemberAmt());
        bookNow = (Button) findViewById(R.id.book_now_initiate);
        retiredAmt=findViewById(R.id.electricity_payment);
        retiredAmt.setText("Rs. " +productMTB.getRetiredamt());
        recyclerView=(RecyclerView)findViewById(R.id.inclusion_grid);
        recyclerView.setHasFixedSize(false);
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.placeholder_bg_light)
                .error(R.drawable.placeholder_bg_light);

        inclusionProperty.setText("Jokking Trick");
        inclusionProperty.setImage("https://holidayuobcoa.s3.ap-south-1.amazonaws.com/jk1.png");
        inclusionProperties.add(inclusionProperty);
        inclusionProperty.setText("ATM");
        inclusionProperty.setImage("https://holidayuobcoa.s3.ap-south-1.amazonaws.com/jk1.png");
        inclusionProperties.add(inclusionProperty);
        inclusionProperty.setText("Swimming Pool");
        inclusionProperty.setImage("https://holidayuobcoa.s3.ap-south-1.amazonaws.com/jk1.png");
        inclusionProperties.add(inclusionProperty);


        setInclusionAdapter(inclusionProperties);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Properites");

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
        // Glide.with(mContext).load(mData.get(position).getCoverImage()).apply(options).into(holder.propertyImage);
        GlideUtil.getInstance().loadImage(this,imageView, productMTB.getImage1(), R.drawable.placeholder);

      /*  securityMoney.setText("Rs. " + price);
        priceView.setText("Rs. " + price);*/


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
