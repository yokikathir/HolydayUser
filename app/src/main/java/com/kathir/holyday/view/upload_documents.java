package com.kathir.holyday.view;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.kathir.holyday.R;


import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ru.slybeaver.slycalendarview.SlyCalendarDialog;


public class upload_documents extends AppCompatActivity implements SlyCalendarDialog.Callback {
    // View customView ;
    static final int CAMERA_REQUEST = 1888, CAMERA_REQUEST_back = 1999;
    static final int MY_CAMERA_PERMISION = 1, MY_CAMERA_PERMISSION_2 = 2;
    ImageButton frontFace, backFace,increamentbtn,decreamentbtn;
    AlertDialog alertDialog, alertDialog1;
    LayoutInflater inflater, inflater_back;
    Double priceDouble;
    CheckBox checkBox;
    Boolean isForntUpload = false, isBackUpload = false;
    Button checkout;
    RadioGroup radioGroup;
    String documentsType = null;
    String CoverImage, adress, fulladdress, uid, price;
    String UserName, UserEmail, FirstDate = "", SecondDate = "", BookingType = "";
    TextView BookingFor, monthlyMoney, securityMoney, userNameTextView, userEmailTextView,countbtn;
    EditText dateFrom, dateTo;
    ProgressDialog progressDialog;
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> user = new HashMap<>();
    private RadioButton adhaar, passport;
    private int mCount=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upload_documents);
        frontFace = (ImageButton) findViewById(R.id.front_face);
        backFace = (ImageButton) findViewById(R.id.back_face);
        decreamentbtn = (ImageButton) findViewById(R.id.decbtn);
        increamentbtn = (ImageButton) findViewById(R.id.incbtn);
        countbtn = (TextView) findViewById(R.id.countadult);
        checkout = (Button) findViewById(R.id.checkout);
        inflater = LayoutInflater.from(this);
        inflater_back = LayoutInflater.from(this);
        radioGroup = (RadioGroup) findViewById(R.id.radioDoc);
        adhaar = (RadioButton) findViewById(R.id.radioAdhaar);
        passport = (RadioButton) findViewById(R.id.radioPassport);
        BookingFor = (TextView) findViewById(R.id.header);
        checkBox = (CheckBox) findViewById(R.id.advanceCheckBox);
        monthlyMoney = (TextView) findViewById(R.id.monthly_payment);
        securityMoney = (TextView) findViewById(R.id.security_money);
        userNameTextView = (TextView) findViewById(R.id.booking_person_name);
        userEmailTextView = (TextView) findViewById(R.id.booking_person_email);
        dateFrom = (EditText) findViewById(R.id.date_from);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);

        final View customView = inflater.inflate(R.layout.custom_dialog, null, false);
        final View CustomViewBAck = inflater_back.inflate(R.layout.custom_dialog, null, false);
        alertDialog = new AlertDialog.Builder(upload_documents.this).create();
        alertDialog1 = new AlertDialog.Builder(upload_documents.this).create();
        alertDialog1.setTitle("Please Read this");
        alertDialog.setTitle("Please read this");
        // alertDialog.setContentView(R.layout.custom_location);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setView(customView);
        alertDialog1.setCanceledOnTouchOutside(false);
        alertDialog1.setView(CustomViewBAck);
        //sql lite data from database



        Toast.makeText(getApplicationContext(), "" + user, Toast
                .LENGTH_SHORT).show();
        try {
            BookingFor.setText("Booking for Name");
            securityMoney.setText("Rs. " + "100");
            monthlyMoney.setText("Rs. " + "200");
            userNameTextView.setText("User name");
            userEmailTextView.setText("User Email");

            priceDouble = 0.0;
            priceDouble = Double.valueOf(Integer.parseInt(price));

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()) {
                        priceDouble = 1000.00;
                        checkout.setText("Pay (" + priceDouble + ")");
                        BookingType = "Advance Payment Booking";
                    } else {
                        priceDouble = Double.valueOf(Integer.parseInt(price));
                        checkout.setText("Pay (" + priceDouble * 2 + ")");
                        BookingType = "Booking ";
                    }
                }
            });
            String textCheckOutButton = null;
            textCheckOutButton = "Pay (" + priceDouble * 2 + ")";
            checkout.setText(textCheckOutButton);
        } catch (Exception e) {
            e.printStackTrace();
        }


        dateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    genaretedate();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioAdhaar) {
                    //Toast.makeText(getApplicationContext() , ""+checkedId ,Toast.LENGTH_SHORT).show();
                    documentsType = "Adhaar Card";
                } else if (checkedId == R.id.radioPassport) {
                    documentsType = "Passport";
                    //  Toast.makeText(getApplicationContext() , ""+checkedId,Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog1.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISION);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST_back);
                }
            }
        });
        // alertDialog.setButton("Yes",);
        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_PERMISION);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        frontFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    alertDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        backFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // alertDialog.show();
                    alertDialog1.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(documentsType)) {
                    if (isForntUpload == true && isBackUpload == true) {
                        progressDialog.setMessage("Please Wait");
                        progressDialog.show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Upload  document ", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "select document ", Toast.LENGTH_LONG).show();
                }
            }
        });
        decreamentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount>1) {
                    decrement();
                }else {
                    Toast.makeText(getApplicationContext(), "Not allowed", Toast.LENGTH_LONG).show();
                }
            }
        });

        increamentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount<=4) {
                    increment();
                }else {
                    Toast.makeText(getApplicationContext(), "Not allowed", Toast.LENGTH_LONG).show();

                }
            }
        });

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count");
            countbtn.setText(String.valueOf(mCount));
        }

    }

    private void genaretedate() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String str1 = sdf1.format(cal.getTime());
        String str2 = sdf2.format(cal.getTime());
        Date startDate = sdf1.parse(str1);
        Date endDate = sdf2.parse(str2);
        new SlyCalendarDialog()
                .setSingle(false)
                .setFirstMonday(false)
                .setSelectedColor(R.color.themeColor)
                .setHeaderColor(R.color.themeColor)
                .setStartDate(startDate)
                .setCallback(upload_documents.this)
                .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Toast.makeText(getApplicationContext() , "Camera Permission Denied",Toast.LENGTH_SHORT).show();
                Intent cameraIntent = new
                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        } else {
            Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            // startActivityForResult();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            //photo=(Bitmap)data.getData().get
            frontFace.setImageBitmap(photo);
            frontFace.setEnabled(false);

        } else if (requestCode == CAMERA_REQUEST_back && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            backFace.setImageBitmap(photo);
            backFace.setEnabled(false);
        }

    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bmp, 400, 580, false);
        resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    @Override
    public void onCancelled() {
//
    }


    private void decrement() {
        mCount--;
        countbtn.setText(String.valueOf(mCount+" Guest"));
    }

    private void increment() {
        mCount++;
        countbtn.setText(String.valueOf(mCount+" Guest"));
    }
    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            if (secondDate == null) {
                firstDate.set(Calendar.HOUR_OF_DAY, hours);
                firstDate.set(Calendar.MINUTE, minutes);
                // Toast.makeText(getApplicationContext() , new SimpleDateFormat(getString(R.string.timeFormat),Locale.getDefault()).format(firstDate.getTime()) , Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Please Select Last date ", Toast.LENGTH_SHORT).show();
            } else {
                  /*  Toast.makeText(
                            this,
                            getString(
                                    R.string.period,
                                    new SimpleDateFormat(getString(R.string.dateFormat), Locale.getDefault()).format(firstDate.getTime()),
                                    new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault()).format(secondDate.getTime())
                            ),
                            Toast.LENGTH_LONG

                    ).show();*/
                String date = null;
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                String str1 = sdf1.format(firstDate.getTime());
                date = sdf1.format(secondDate.getTime());
                dateFrom.setText(str1 + " to " + date);
                FirstDate = str1;
                SecondDate = date;

            }
        }
    }


}
