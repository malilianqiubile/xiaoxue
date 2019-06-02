package com.example.day05disitao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//惠微乐
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳转
     */
    private Button mBtTiaozhuan;
    /**
     * 欢迎来到积云教育
     */
    private TextView mTvJiyun;
    private ImageView mIvJianbian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mBtTiaozhuan = (Button) findViewById(R.id.bt_tiaozhuan);
        mBtTiaozhuan.setOnClickListener(this);
        mTvJiyun = (TextView) findViewById(R.id.tv_jiyun);
        mIvJianbian = (ImageView) findViewById(R.id.iv_jianbian);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        mIvJianbian.startAnimation(alphaAnimation);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_tiaozhuan:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
