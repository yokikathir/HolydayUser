package com.kathir.core.repository;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.kathir.holyday.mvvm.UserMtb;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkatzioura on 9/22/16.
 */
public class UserMapperRepository {

    private DynamoDBMapper dynamoDBMapper;

    public UserMapperRepository(AmazonDynamoDB amazonDynamoDB) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public void insert(UserMtb user) {

        dynamoDBMapper.save(user);
    }

    public void insert(List<UserMtb> users) {

        dynamoDBMapper.batchWrite(users,new ArrayList<>());
    }




    public void delete(List<UserMtb> users) {
        dynamoDBMapper.batchDelete(users);
    }

    public UserMtb getUser(String email) {

        UserMtb user = dynamoDBMapper.load(UserMtb.class,email);

        return user;
    }

}
