package com.kathir.holyday.home;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.kathir.core.repository.ProductMTB;
import com.kathir.holyday.R;
import com.kathir.holyday.utils.GlideUtil;
import com.kathir.holyday.utils.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Suleiman on 19/10/16.
 */

public class ProductPaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private RecyclerViewClickListener mListener;

    private List<ProductMTB> productLists;
    private Context context;
    private RelativeLayout mainLayout;
    private boolean isLoadingAdded = false;


    public ProductPaginationAdapter(Context context, RecyclerViewClickListener listener) {
        this.context = context;
        productLists = new ArrayList<>();
        mListener = listener;

    }

    public List<ProductMTB> getProductLists() {
        return productLists;
    }

    public void setProductList(List<ProductMTB> movieResults) {
        this.productLists = movieResults;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_loading, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.producthome, parent, false);
        viewHolder = new ProductView(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProductMTB result = productLists.get(position); // Movie

        switch (getItemViewType(position)) {
            case ITEM:
                final ProductView productView = (ProductView) holder;

                productView.prouctname.setText(result.getTittle());
                productView.discountAmount.setText("₹ "+result.getStaffMemberAmt());
                      GlideUtil.getInstance().loadImage(context, productView.productImage, result.getImage1(), R.drawable.placeholder);

                break;

            case LOADING:
//                Do nothing
                break;
        }
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // viewHolder.mainLayout.setClickable(false);
                mListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productLists == null ? 0 : productLists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == productLists.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(ProductMTB r) {
        productLists.add(r);
        notifyItemInserted(productLists.size() - 1);
    }

    public void addAll(List<ProductMTB> moveResults) {
        for (ProductMTB result : moveResults) {
            add(result);
        }
    }

    public void remove(ProductMTB r) {
        int position = productLists.indexOf(r);
        if (position > -1) {
            productLists.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new ProductMTB());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = productLists.size() - 1;
        ProductMTB result = getItem(position);

        if (result != null) {
            productLists.remove(position);
            notifyItemRemoved(position);
        }
    }

    public ProductMTB getItem(int position) {
        return productLists.get(position);
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class ProductView extends RecyclerView.ViewHolder {

        ImageView productImage;


        TextView prouctname,amount,discountAmount;
        View rootView;

        public ProductView(View itemView) {
            super(itemView);

            rootView = itemView;

            mainLayout = (RelativeLayout) itemView.findViewById(R.id.mainlayoutt);
            prouctname = (TextView) itemView.findViewById(R.id.productname);

            discountAmount = (TextView) itemView.findViewById(R.id.discountamount);
            productImage = (ImageView) itemView.findViewById(R.id.logoview);

        }
    }


    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


}
