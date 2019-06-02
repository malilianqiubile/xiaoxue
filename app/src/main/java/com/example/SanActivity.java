package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.day05disitao.R;

public class SanActivity extends AppCompatActivity {

    private ImageView mIvShuju1;
    /**  */
    private EditText mTvShuju2;
    /**  */
    private EditText mTvShuju3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san);
        initView();


    }

    private void initView() {
        Intent intent = getIntent();
        String shu1 = intent.getStringExtra("a");
        String shu2 = intent.getStringExtra("b");
        String shu3 = intent.getStringExtra("c");

        mIvShuju1 = (ImageView) findViewById(R.id.iv_shuju1);
        mTvShuju2 = (EditText) findViewById(R.id.tv_shuju2);
        mTvShuju3 = (EditText) findViewById(R.id.tv_shuju3);

//        mIvShuju1.setImageResource(mIvShuju1);
        mTvShuju2.setText(shu2);
        mTvShuju3.setText(shu3);
    }
}
