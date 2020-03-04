package com.kathir.holyday.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kathir.holyday.R;
import com.kathir.holyday.view.LoginActivity;
import com.kathir.holyday.view.MainActivity;
import com.kathir.holyday.view.MpinSetupActivity;
import com.kathir.holyday.view.OTPActivity;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    RegisterViewModel regidterViewModel;
    List<String> categories = new ArrayList<String>();
    List<String>stafflist=new ArrayList<>();
    private Button registerBtn, gotoLoginBtn;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText regName, regGmail, regPhoneno, regGender, regDob, regEmpid;
    private Spinner regmebership,regSatff;
    private ProgressBar progressBar;
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        initUI();
        calendar();
        stafflist.add("Select Staff");
        stafflist.add("Staff");
        stafflist.add("Ex Staff");

        ArrayAdapter<String>staffadapter=new ArrayAdapter<String>(RegisterActivity.this,R.layout.spinner_item,R.id.textview,stafflist);
        regSatff.setAdapter(staffadapter);


        categories.add("Select Category");
        categories.add("Membership");
        categories.add("Non Membership");
        categories.add("Retired");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.spinner_item, R.id.textview, categories);
        regmebership.setAdapter(arrayAdapter);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regResult();
                progressBar.setVisibility(View.VISIBLE);

/*
                if (valiadate()) {
                    showError();
                } else {

                    showPopup();
                }*/
            }
        });
        regidterViewModel = ViewModelProviders.of(RegisterActivity.this).get(RegisterViewModel.class);
        regidterViewModel.regStatus.observe(RegisterActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("Login Fail")){
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                  //  startActivity(new Intent(RegisterActivity.this, OTPActivity.class));
                    String fPhone = regPhoneno.getText().toString().trim();

                    Intent intent = new Intent(RegisterActivity.this, OTPActivity.class);
                    intent.putExtra("mobile", fPhone);
                    startActivity(intent);

                }

            }
        });


        gotoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void regResult() {
        String fname = regName.getText().toString().trim();
        String fPhone = regPhoneno.getText().toString().trim();
        String fGmail = regGmail.getText().toString().trim();
        String fEmpno = regEmpid.getText().toString().trim();
        String fDob = regDob.getText().toString().trim();
        String fstaff = regSatff.getSelectedItem().toString().trim();
        String fGender = regGender.getText().toString().trim();
        String fMembership = regmebership.getSelectedItem().toString().trim();

        regidterViewModel.doLogin(fname, fEmpno, fDob, fstaff, fMembership, fPhone, fGmail, fGender);

    }

    private void initUI() {
        regName = findViewById(R.id.etRegName);
        regEmpid = findViewById(R.id.eRegEmpNo);
        regDob = findViewById(R.id.eRegDob);
        regmebership = findViewById(R.id.eRegMembership);
        regGmail = findViewById(R.id.etRegGmail);
        regPhoneno = findViewById(R.id.etRegPhone);
        regSatff = findViewById(R.id.eRegstaff);
        regGender = findViewById(R.id.ereggender);
        progressBar = findViewById(R.id.progress_login);
        registerBtn = findViewById(R.id.btnRegLogin);
        gotoLoginBtn = findViewById(R.id.btnGotoLogin);
        progressBar.setVisibility(View.INVISIBLE);


    }

    private void showError() {
        if (regName.getText().toString().trim().length() == 0) {
            regName.setError("Name is not entered");
            regName.requestFocus();
        } else if (regEmpid.getText().toString().trim().length() == 0) {
            regEmpid.setError("Emp No is not entered");
            regEmpid.requestFocus();
        } else if (regDob.getText().toString().trim().length() == 0) {
            regDob.setError("DOB is not entered");
            regDob.requestFocus();
        } else if (regGender.getText().toString().trim().length() == 0) {
            regGender.setError("Gender is not entered");
            regGender.requestFocus();
        } else if (regSatff.getSelectedItemPosition() == 0) {
            Toast.makeText(RegisterActivity.this, "Please Select Staff/Ex Staff", Toast.LENGTH_SHORT).show();
        } else if (regmebership.getSelectedItemPosition() == 0) {
            Toast.makeText(RegisterActivity.this, "Please Select the Membership", Toast.LENGTH_SHORT).show();
        } else if (regPhoneno.length() != 10) {
            regPhoneno.setError(" Please enter a valid phone number");
            regPhoneno.requestFocus();
        } else if (regGmail.getText().toString().trim().length() == 0) {
            regGmail.setError("Email is not entered");
            regGmail.requestFocus();
        }
    }

    private boolean valiadate() {
        if (regName.getText().toString().trim().length() == 0) {
            return true;
        } else if (regEmpid.getText().toString().trim().length() == 0) {
            return true;
        } else if (regDob.getText().toString().trim().length() == 0) {
            return true;
        } else if (regGender.getText().toString().trim().length() == 0) {
            return true;
        } else if (regSatff.getSelectedItemPosition() == 0) {
            return true;
        } else if (regmebership.getSelectedItemPosition() == 0) {
            return true;
        } else if (regPhoneno.length() != 10) {
            return true;
        } else if (regGmail.getText().toString().trim().length() == 0) {
            return true;
        }
        return false;
    }

    private void showPopup() {
        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
        alert.setMessage("Are you sure want to Register?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", null);
        AlertDialog alert1 = alert.create();
        alert1.show();
    }


    private void calendar() {
        final DatePickerDialog.OnDateSetListener date = new
                DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }

                };
        regDob.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard(RegisterActivity.this, v);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new DatePickerDialog(RegisterActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                }
                return false;
            }
        });

    }
    private void updateLabel() {

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        regDob.setText(sdf.format(myCalendar.getTime()));
    }
    private void hideKeyboard(Context context, View view) {
        view = RegisterActivity.this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) RegisterActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
