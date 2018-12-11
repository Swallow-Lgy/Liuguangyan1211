package com.example.recyclerviewl.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewl.R;
import com.example.recyclerviewl.bean.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class LinearAdpter extends RecyclerView.Adapter<LinearAdpter.ViewHolderr> {
    private List<User.DataBean> mDatas;
     private Context mContext;
    public LinearAdpter(Context context) {
        mContext = context;
       mDatas = new ArrayList<>();

    }

    public void setmDatas(List<User.DataBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    //创建viewholder把布局添加到里面,返回给viewholdr
    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.linear_layout,viewGroup,false);
        return new ViewHolderr(v);
    }
    //绑定个viewholder ，写入数据
    @Override
    public void onBindViewHolder(@NonNull ViewHolderr viewHolderr, int position) {

        viewHolderr.title.setText(mDatas.get(position).getName());
        ImageLoader.getInstance().displayImage(mDatas.get(position).getIcon(),viewHolderr.avatar);
    }
   //返回条目数
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
     //静态内部类 viewHoder

    public class ViewHolderr extends RecyclerView.ViewHolder {
            //列出所有需要的控件
            public TextView title;
            public ImageView avatar;
        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            //找到所有控件的id
            title = itemView.findViewById(R.id.title);
            avatar = itemView.findViewById(R.id.image);
        }
    }
}
