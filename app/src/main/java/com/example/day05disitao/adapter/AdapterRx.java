package com.example.day05disitao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day05disitao.R;
import com.example.day05disitao.bean.FzBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/6/1.
 */

public class AdapterRx extends RecyclerView.Adapter<AdapterRx.Viewolder> {
    private ArrayList<FzBean.DataBean> mList;
    private Context context;

    public AdapterRx(ArrayList<FzBean.DataBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yixml, parent, false);
        return new Viewolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewolder holder, final int position) {
        Glide.with(context).load(mList.get(position).getPic()).into(holder.mIvPic);
        holder.mTvFoodStr.setText(mList.get(position).getFood_str());
        holder.mTvTitle.setText(mList.get(position).getTitle());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (OnLongClickListener!=null){
                    OnLongClickListener.OnLongClickListener(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Viewolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvPic;
        TextView mTvFoodStr;
        TextView mTvTitle;

        public Viewolder(View itemView) {
            super(itemView);
           view = itemView;
            this.mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            this.mTvFoodStr = (TextView) itemView.findViewById(R.id.tv_food_str);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
    public  interface  OnLongClickListener{
        void OnLongClickListener(int position);
    }
    private OnLongClickListener OnLongClickListener;

    public void setOnLongClickListener(AdapterRx.OnLongClickListener onLongClickListener) {
        OnLongClickListener = onLongClickListener;
    }
}
