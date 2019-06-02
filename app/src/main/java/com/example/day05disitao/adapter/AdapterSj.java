package com.example.day05disitao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day05disitao.R;
import com.example.day05disitao.bean.SjBean;

import java.util.ArrayList;

/**
 * Created by 小乐乐 on 2019/6/1.
 */

public class AdapterSj extends RecyclerView.Adapter<AdapterSj.ViewHolder> {
    private ArrayList<SjBean> mList;
    private Context context;

    public AdapterSj(ArrayList<SjBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yixml, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
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


    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView mIvPic;
        TextView mTvFoodStr;
        TextView mTvTitle;
        RadioButton mRbShoucang;
        public ViewHolder(View itemView) {
            super(itemView);
            view = view;
            this.mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            this.mTvFoodStr = (TextView) itemView.findViewById(R.id.tv_food_str);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mRbShoucang = (RadioButton) itemView.findViewById(R.id.rb_shoucang);
        }
    }

    public interface OnLongClickListener{
        void  OnLongClickListener(int position);
    }
    private OnLongClickListener OnLongClickListener;

    public void setOnLongClickListener(AdapterSj.OnLongClickListener onLongClickListener) {
        OnLongClickListener = onLongClickListener;
    }
}
