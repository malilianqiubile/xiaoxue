package com.example.day05disitao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day05disitao.fragment.LiebiaoFragment;
import com.example.day05disitao.fragment.ShoucangFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragments;
    private ShoucangFragment mShoucangFragment;
    private LiebiaoFragment mLiebiaoFragment;
    private ArrayList<String> mList;
    private ViewPager mVip;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();



    }

    private void initView() {
        mVip = (ViewPager) findViewById(R.id.vip);
        mTab = (TabLayout) findViewById(R.id.tab);



        mFragments = new ArrayList<>();
        mShoucangFragment = new ShoucangFragment();
        mLiebiaoFragment = new LiebiaoFragment();
        mFragments.add(mLiebiaoFragment);
        mFragments.add(mShoucangFragment);

        mList = new ArrayList<>();
        mList.add("首页");
        mList.add("收藏");

        Myolder myolder = new Myolder(getSupportFragmentManager(), mFragments, mList);
        mVip.setAdapter(myolder);
        mTab.setupWithViewPager(mVip);

    }

    class Myolder extends FragmentStatePagerAdapter {

        private ArrayList<Fragment> mFragments;
        private ArrayList<String> mList;

        public Myolder(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> list) {
            super(fm);
            mFragments = fragments;
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position);
        }
    }
}
