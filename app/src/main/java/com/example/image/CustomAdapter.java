package com.example.image;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Dictionary> mList = null;
    private Activity context = null;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView product;
        protected ImageView prod_img;


        public CustomViewHolder(View view) {
            super(view);
            this.product = (TextView) view.findViewById(R.id.product_listitem);
            this.prod_img = (ImageView) view.findViewById(R.id.prod_img_listitem);
        }
    }


    public CustomAdapter(Activity context, ArrayList<Dictionary> list) {
        this.context = context;
        this.mList = list;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }






    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {


        /*
        viewholder.product.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.prod_img.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        viewholder.product.setGravity(Gravity.CENTER);
        viewholder.prod_img.setGravity(Gravity.CENTER); */


        viewholder.product.setText(mList.get(position).getProduct());
        Glide.with(viewholder.prod_img.getContext())
                .load(mList.get(position))
                .into(viewholder.prod_img);
        /*Glide.with(this).load(prod_img).into(healthImg);
        viewholder.prod_img.setText(mList.get(position).getProd_img()); */
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
