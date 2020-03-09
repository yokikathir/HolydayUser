package com.kathir.core.repository;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.io.Serializable;

@DynamoDBTable(tableName="PRODUCT_MTB")
public class ProductMTB implements Serializable {
    @DynamoDBHashKey(attributeName="id")
    String id;
    @DynamoDBAttribute(attributeName="atm")
    String atm;
    @DynamoDBAttribute(attributeName="childrenplay")
    String childrenplay;
    @DynamoDBAttribute(attributeName="description")
    String description;
    @DynamoDBAttribute(attributeName="gym")
    String gym;
    @DynamoDBAttribute(attributeName="mapurl")
    String mapurl;
    @DynamoDBAttribute(attributeName="security")
    String security;
    @DynamoDBAttribute(attributeName="swimmng")
    String swimmng;
    @DynamoDBAttribute(attributeName="tittle")
    String tittle;
    @DynamoDBAttribute(attributeName="retiredamt")
    String retiredamt;
    @DynamoDBAttribute(attributeName="staff-member")
    String staffMemberAmt;

    public String getStaffNonMemberAmt() {
        return staffNonMemberAmt;
    }

    public void setStaffNonMemberAmt(String staffNonMemberAmt) {
        this.staffNonMemberAmt = staffNonMemberAmt;
    }

    @DynamoDBAttribute(attributeName="staff-nonmember")
    String staffNonMemberAmt;


    @DynamoDBAttribute(attributeName="image1")
    String image1;
    @DynamoDBAttribute(attributeName="image2")
    String image2;
    @DynamoDBAttribute(attributeName="image3")
    String image3;
    @DynamoDBAttribute(attributeName="image4")
    String image4;
    @DynamoDBAttribute(attributeName="image5")
    String image5;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getChildrenplay() {
        return childrenplay;
    }

    public void setChildrenplay(String childrenplay) {
        this.childrenplay = childrenplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getMapurl() {
        return mapurl;
    }

    public void setMapurl(String mapurl) {
        this.mapurl = mapurl;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getSwimmng() {
        return swimmng;
    }

    public void setSwimmng(String swimmng) {
        this.swimmng = swimmng;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getRetiredamt() {
        return retiredamt;
    }

    public void setRetiredamt(String retiredamt) {
        this.retiredamt = retiredamt;
    }

    public String getStaffMemberAmt() {
        return staffMemberAmt;
    }

    public void setStaffMemberAmt(String staffMemberAmt) {
        this.staffMemberAmt = staffMemberAmt;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }
}
