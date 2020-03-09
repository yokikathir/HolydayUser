package com.kathir.holyday.home;


import com.kathir.core.repository.ProductMTB;

import java.util.List;

public interface HomeMVPView {

    interface View{

        void validationError(String errorCode);


        void showProductsList(List<ProductMTB> mProductList);


        void showPopUp();
        void dismissPopUp();

    }

    interface presenter
    {
        void  getAllProduct();
        void getAllPost(String registerID, int start, int end);
        void uploadPost(ProductMTB mProduct);
        void getUserDetail(String regID);
        void getpushList(String regID);

    }
}
