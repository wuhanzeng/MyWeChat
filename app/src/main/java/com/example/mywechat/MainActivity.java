package com.example.mywechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment mTab01 = new WeChat_BlankFragment();
    private Fragment mTab02 = new friend_BlankFragment();
    private Fragment mTab03 = new find_BlankFragment();
    private Fragment mTab04 = new settings_BlankFragment();

    private LinearLayout mTabWeChat;
    private LinearLayout mTabFrd;
    private LinearLayout mTabFind;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeChat;
    private ImageButton mImgFrd;
    private ImageButton mImgFind;
    private ImageButton mImgSettings;

    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);*/
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        initEvent();
        selectFragment(0);
    }

    private void initFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mTab01);
        transaction.add(R.id.id_content, mTab02);
        transaction.add(R.id.id_content, mTab03);
        transaction.add(R.id.id_content, mTab04);
        transaction.commit();
    }

    private void resetImgs() {
        mImgWeChat.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgFind.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);

    }

    private void initView() {
        mTabWeChat = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabFind = (LinearLayout) findViewById(R.id.id_tab_contact);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);

        mImgWeChat = (ImageButton) findViewById(R.id.id_tab_WeChat_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgFind = (ImageButton) findViewById(R.id.id_tab_contact_img);
        mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_img);

    }

    private void selectFragment(int i) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        //把图片设置为亮的
        //设置内容区域
        switch (i) {
            case 0:
                Log.d("setSelect", "1");
                transaction.show(mTab01);
                mImgWeChat.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgFind.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void initEvent() {
        mTabWeChat.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabFind.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }

    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);

    }

    @Override
    public void onClick(View v) {
        Log.d("onClick", "1");
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                Log.d("onClick", "2");
                selectFragment(0);
                break;
            case R.id.id_tab_frd:
                selectFragment(1);
                break;
            case R.id.id_tab_contact:
                selectFragment(2);
                break;
            case R.id.id_tab_settings:
                selectFragment(3);
                break;
            default:
                break;
        }
    }
}