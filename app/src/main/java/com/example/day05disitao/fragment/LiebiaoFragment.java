package com.example.day05disitao.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.day05disitao.R;
import com.example.day05disitao.adapter.AdapterRx;
import com.example.day05disitao.bean.FzBean;
import com.example.day05disitao.bean.SjBean;
import com.example.day05disitao.dao.Mapp;
import com.example.day05disitao.molder.Imolder;
import com.example.day05disitao.mview.Mview;
import com.example.day05disitao.prenter.Imprenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiebiaoFragment extends Fragment implements Mview {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRv;
    private ArrayList<FzBean.DataBean> mList;
    private AdapterRx mAdapterRx;
    private Imprenter mImprenter;
    public LiebiaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_liebiao, container, false);
        initView(inflate);
        mImprenter = new Imprenter(new Imolder(), this);
        mImprenter.getData();
        return inflate;
    }


    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRv.setLayoutManager(manager);

        mList = new ArrayList<>();
        mAdapterRx = new AdapterRx(mList, getContext());
        mRv.setAdapter(mAdapterRx);
    initShoucang();
    }

    private void initShoucang() {

        mAdapterRx.setOnLongClickListener(new AdapterRx.OnLongClickListener() {
            @Override
            public void OnLongClickListener(int position) {
                Mapp mapp = new Mapp().getMapp();
                SjBean sjBean = new SjBean();
                FzBean.DataBean dataBean = mList.get(position);
              sjBean.setPic(dataBean.getPic());
              sjBean.setTitle(dataBean.getTitle());
              sjBean.setFood_str(dataBean.getFood_str());
                mapp.insertItem(sjBean);
                mAdapterRx.notifyDataSetChanged();
                Log.e("tag", "OnLongClickListener: "+mList.get(position).getTitle() );
                Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();

                }
        });
    }

    @Override
    public void Scuess(FzBean fzBean) {
        List<FzBean.DataBean> data = fzBean.getData();
        mList.addAll(data);
        mAdapterRx.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {
        Log.e("tag", "Error: "+error );
    }


}
