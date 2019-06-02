package com.example.day05disitao.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.SanActivity;
import com.example.day05disitao.R;
import com.example.day05disitao.adapter.AdapterSj;
import com.example.day05disitao.bean.SjBean;
import com.example.day05disitao.dao.Mapp;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoucangFragment extends Fragment {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRvv;
    private ArrayList<SjBean> mList;
    private AdapterSj mAdapterSj;

    public ShoucangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shoucang, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRvv = (RecyclerView) inflate.findViewById(R.id.rvv);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvv.setLayoutManager(manager);

        mList = new ArrayList<>();

        mAdapterSj = new AdapterSj(mList, getContext());
        mRvv.setAdapter(mAdapterSj);

        initchaun();
        mAdapterSj.setOnLongClickListener(new AdapterSj.OnLongClickListener() {
            @Override
            public void OnLongClickListener(int position) {
                Intent intent = new Intent(getContext(), SanActivity.class);
                intent.putExtra("a",mList.get(position).getFood_str());
                intent.putExtra("b",mList.get(position).getTitle());
                intent.putExtra("c",mList.get(position).getPic());
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initchaun();
        }
        else {
            if (mList!=null&&mList.size()>0){
                mList.clear();
            }
        }
    }

    private void initchaun() {
        Mapp mapp = new Mapp().getMapp();
        List<SjBean> sjBeans = mapp.loallAll();
        mList.addAll(sjBeans);
        mAdapterSj.notifyDataSetChanged();
    }
}
