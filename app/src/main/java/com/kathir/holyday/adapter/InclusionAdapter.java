package com.kathir.holyday.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.kathir.holyday.R;
import com.kathir.holyday.model.InclusionProperty;
import com.kathir.holyday.utils.GlideUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InclusionAdapter extends  RecyclerView.Adapter<InclusionAdapter.MyViewHolder> {
    RequestOptions options ;
    private Context mContext ;
    private List<InclusionProperty> minclusion;
    public InclusionAdapter(Context context , List list){
        this.mContext=context;
        this.minclusion=list;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_home_black_24dp)
                .error(R.drawable.ic_local_phone_black_24dp);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.single_inclusion_layout,viewGroup,false);
        return new InclusionAdapter.MyViewHolder(view);
       // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {
       myViewHolder.textView.setText(minclusion.get(i).getText());
       //myViewHolder.textView.s
      //  Glide.with(mContext).load(minclusion.get(i).getImage()).apply(options).into(myViewHolder.imageView);
        GlideUtil.getInstance().loadImage(mContext,myViewHolder.imageView,minclusion.get(i).getImage(), R.drawable.placeholder);
    }

    @Override
    public int getItemCount() {
        return minclusion.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.iclusion_image);
            textView=itemView.findViewById(R.id.inclusion_text);

        }
    }
}
