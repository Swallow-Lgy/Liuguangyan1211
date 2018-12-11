package com.example.recyclerviewl.adpter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerviewl.R;
import com.example.recyclerviewl.bean.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GridAdpter extends RecyclerView.Adapter<GridAdpter.ViewHolder> {
      private List<User.DataBean> mDatas;
      public GridAdpter(){
          mDatas = new ArrayList<>();
      }
    public void setmDatas(List<User.DataBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }
    //创建viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item,viewGroup,false);
        return new ViewHolder(view);
    }
     public void remove(int psiontion){
          mDatas.remove(psiontion);
          //notifyItemRemoved(psiontion);
         notifyDataSetChanged();
     }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
         viewHolder.title.setText(mDatas.get(i).getName());
        ImageLoader.getInstance().displayImage(mDatas.get(i).getIcon(),viewHolder.imageView);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mclick!=null){
                    mclick.OnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          public ImageView imageView;
          public TextView title;
          private LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.grid_image);
            title = itemView.findViewById(R.id.grid_title);
            linearLayout = itemView.findViewById(R.id.ll_recycle_grid);
        }
    }
    //定义全局变量
    Click mclick;
    public void setClickListener(Click click){
        mclick = click;
    }
    //定义接口
    public interface  Click{
        void OnClick(int position);
    }
}
