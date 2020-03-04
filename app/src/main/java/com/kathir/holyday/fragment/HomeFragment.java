package com.kathir.holyday.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kathir.holyday.R;
import com.kathir.holyday.home.ProductPaginationAdapter;
import com.kathir.holyday.utils.AppUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Utils;


public class HomeFragment extends Fragment {

    RecyclerView mProductRecycler;
    ProductPaginationAdapter mProductPagination;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProductRecycler=view.findViewById(R.id.productrecyclerview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mProductRecycler.setLayoutManager(mLayoutManager);
        // notificationLayout.mNotiRecyclerView.addItemDecoration(new VerticalLineDecorator(2));
        mProductPagination=new ProductPaginationAdapter(getActivity());
         mProductRecycler.setAdapter(mProductPagination);
        mProductPagination.addAll(AppUtils.getProductList());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
