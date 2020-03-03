package com.kathir.holyday.mvvm;

import android.widget.Toast;

public class UserModel {

    private String username;
    private String password;
    private String empno;
    private String dob;
    private String staff;
    private String membership;
    private String phoneno;
    private String gmail;
    private String gender;

    public UserModel(String username, String empno, String dob, String staff, String membership, String phoneno, String gmail, String gender) {
        this.username = username;
        this.empno = empno;
        this.dob = dob;
        this.staff = staff;
        this.membership = membership;
        this.phoneno = phoneno;
        this.gmail = gmail;
        this.gender=gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }


    public int checkUserValidity(String username, String password){
        if (username.trim().equals("")||password.trim().equals("")){

            return -1;
        }else{
            return 0;
        }

    }
}
