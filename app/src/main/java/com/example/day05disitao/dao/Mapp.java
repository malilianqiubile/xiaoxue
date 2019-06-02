package com.example.day05disitao.dao;

import android.app.Application;

import com.example.day05disitao.bean.SjBean;
import com.example.lizhengjun.dao.DaoMaster;
import com.example.lizhengjun.dao.DaoSession;
import com.example.lizhengjun.dao.SjBeanDao;

import java.util.List;

/**
 * Created by 小乐乐 on 2019/6/1.
 */

public class Mapp extends Application {
    private static Mapp mMapp;
    private SjBeanDao mSjBeanDao;


    @Override
    public void onCreate() {
        super.onCreate();
        mMapp=this;
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "wu.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mSjBeanDao = daoSession.getSjBeanDao();
    }

    public static Mapp getMapp() {
        if (mMapp==null){
            synchronized (Mapp.class){
                if (mMapp==null){
                    mMapp=new Mapp();
                }
            }
        }
        return mMapp;
    }

    //插入
    public long insertItem(SjBean sjBean){
        if (isHash(sjBean)){
            long insert = mSjBeanDao.insertOrReplace(sjBean);
            return insert;

        }
        return -1;
    }
    private boolean isHash(SjBean sjBean){
       List<SjBean> list= mSjBeanDao.queryBuilder().where(SjBeanDao.Properties.Food_str.eq(sjBean.getFood_str())).list();
        if (list!=null&&list.size()>0){
            return true;
        }
        return false;
    }

    //查询
    public List<SjBean> loallAll(){
        return  mSjBeanDao.loadAll();
    }

}
