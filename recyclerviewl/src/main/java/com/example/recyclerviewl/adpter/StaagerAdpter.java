package com.example.recyclerviewl.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewl.R;
import com.example.recyclerviewl.bean.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class StaagerAdpter extends RecyclerView.Adapter<StaagerAdpter.ViewHolder> {
    private List<User.DataBean> mData;
    private Context mContext;
    //构造方法

    public StaagerAdpter(Context mContext) {
        this.mContext = mContext;
        this.mData = new ArrayList<>();
    }

    public void setmData(List<User.DataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StaagerAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.staager_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaagerAdpter.ViewHolder viewHolder, int i) {
         viewHolder.textView.setText(mData.get(i).getName());
         ImageLoader.getInstance().displayImage(mData.get(i).getIcon(),viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sta_image);
            textView = itemView.findViewById(R.id.sta_title);
        }
    }

}
