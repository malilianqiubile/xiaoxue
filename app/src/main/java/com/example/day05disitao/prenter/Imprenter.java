package com.example.day05disitao.prenter;

import com.example.day05disitao.bean.FzBean;
import com.example.day05disitao.callback.Ccallback;
import com.example.day05disitao.molder.Imolder;
import com.example.day05disitao.mview.Mview;

/**
 * Created by 小乐乐 on 2019/6/1.
 */

public class Imprenter implements Prenter, Ccallback {

    private Imolder mImolder;
    private Mview mMview;

    public Imprenter(Imolder imolder, Mview mview) {
        mImolder = imolder;
        mMview = mview;
    }

    @Override
    public void getData() {
        if (mImolder!=null){
            mImolder.getData(this);
        }
    }

    @Override
    public void Scuess(FzBean fzBean) {
        if (mMview!=null){
            mMview.Scuess(fzBean);
        }
    }

    @Override
    public void Error(String error) {
        if (mMview!=null){
            mMview.Error(error);
        }
    }
}
