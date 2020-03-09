package com.kathir.core.repository;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gkatzioura on 9/22/16.
 */
public class ProductMapperRepository {

    private DynamoDBMapper dynamoDBMapper;

    public ProductMapperRepository(AmazonDynamoDB amazonDynamoDB) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public void insert(ProductMTB user) {

        dynamoDBMapper.save(user,new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.CLOBBER));
    }

    public List<ProductMTB> getProductList()
    {

        List<ProductMTB> result = dynamoDBMapper.scan(ProductMTB.class, new DynamoDBScanExpression());
        return  result;


    }



}
