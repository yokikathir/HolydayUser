package com.kathir.holyday.mvvm;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.io.Serializable;

@DynamoDBTable(tableName="IAM_USER_MTB")
public class UserMtb implements Serializable {

    @DynamoDBHashKey(attributeName="id")
    String regID;
    @DynamoDBAttribute(attributeName="MOBILE_NUMBER")
    private String mNo;
    @DynamoDBAttribute(attributeName="DISPLAY_NAME")
    private String displayName;
    @DynamoDBAttribute(attributeName="EMP_ID")
    private String empID;
    @DynamoDBAttribute(attributeName="DOB")
    private String dob;
    @DynamoDBAttribute(attributeName="STAFF_TYPE")
    private String staff;
    @DynamoDBAttribute(attributeName="MEMBERSHIP_TYPE")
    private String memberShip;
    @DynamoDBAttribute(attributeName="EMAIL_ID")
    private String emailID;
    @DynamoDBAttribute(attributeName="BRANCH_ID")
    private String branch;
    @DynamoDBAttribute(attributeName="GENDER_ID")
    private String gender;
    @DynamoDBAttribute(attributeName="PUSH_NOTIFICATION_STATUS")
    private String pushStatus;
    @DynamoDBAttribute(attributeName="DEVICE_ID")
    private String mDeviceID;
    @DynamoDBAttribute(attributeName="USER_STATUS")
    private String status;
    @DynamoDBAttribute(attributeName="PAYMENT_STATUS")
    private String paymentStatus;
    @DynamoDBAttribute(attributeName="IPADDRESS")
    private String ipaddres;
    @DynamoDBAttribute(attributeName="LAST_LOGIN_DATE")
    private String lastlogindate;
    @DynamoDBAttribute(attributeName="CREATE_DAT")
    private String createdDate;
    @DynamoDBAttribute(attributeName="MPIN_ID")
    private String mPIN;


    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public String getmNo() {
        return mNo;
    }

    public void setmNo(String mNo) {
        this.mNo = mNo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
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

    public String getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(String memberShip) {
        this.memberShip = memberShip;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    public String getmDeviceID() {
        return mDeviceID;
    }

    public void setmDeviceID(String mDeviceID) {
        this.mDeviceID = mDeviceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getIpaddres() {
        return ipaddres;
    }

    public void setIpaddres(String ipaddres) {
        this.ipaddres = ipaddres;
    }

    public String getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(String lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getmPIN() {
        return mPIN;
    }

    public void setmPIN(String mPIN) {
        this.mPIN = mPIN;
    }
}
