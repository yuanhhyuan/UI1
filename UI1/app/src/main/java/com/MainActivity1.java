package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hy.app.ui1.R;
import com.hy.appui.basic.BasicUIActivity;
import com.hy.appui.dialog.DialogActivity;
import com.hy.appui.dialog.PopwindowActivity;
import com.hy.appui.fragment.MyFragmentActivity;
import com.hy.appui.fragment.MyFragmentActivity1;
import com.hy.appui.menu.MenuActivity;
import com.hy.appui.notification.NotificationActivity;

/**
 * Activity标准形式
 *
 */
public class MainActivity1 extends AppCompatActivity {
    Button mbasicui;
    Button mdialog;
    Button fragment;
    Button fragment1;
    Button notification;
    Button mpopwindow;
    Button mmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidui);

        Log.v("060", "MainActivity1 : ");

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView(){
        mbasicui = (Button) findViewById(R.id.mbasicui);
        mdialog = (Button)findViewById(R.id.dialog);
        fragment = (Button) findViewById(R.id.fragment);
        fragment1 = (Button) findViewById(R.id.fragment1);
        notification = (Button) findViewById(R.id.notification);
        mpopwindow = (Button)findViewById(R.id.mpopwindow);
        mmenu = (Button)findViewById(R.id.mmenu);
    }

    private void initListener(){
        mbasicui.setOnClickListener(new MyListener());
        mdialog.setOnClickListener(new MyListener());
        fragment.setOnClickListener(new MyListener());
        fragment1.setOnClickListener(new MyListener());
        notification.setOnClickListener(new MyListener());
        mpopwindow.setOnClickListener(new MyListener());
        mmenu.setOnClickListener(new MyListener());
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.mbasicui:
                    newBasicUIActivity();
                    break;
                case R.id.dialog:
                    newDialogActivity();
                    break;
                case R.id.fragment:
                    newMyFragmentActivity();
                    break;
                case R.id.fragment1:
                    newMyFragmentActivity1();
                    break;
                case R.id.notification:
                    newNotificationActivity();
                    break;
                case R.id.mpopwindow:
                    newPopwindowActivity();
                    break;
                case R.id.mmenu:
                    newMenuActivity();
                    break;
                default:
                    break;
            }
        }
    }

    private void newBasicUIActivity(){
        Log.v("060", "newBasicUIActivity : ");
        Intent i = new Intent(MainActivity1.this,BasicUIActivity.class);
        startActivity(i);
    }
    private void newMyFragmentActivity(){
        Intent i = new Intent(MainActivity1.this,MyFragmentActivity.class);
        startActivity(i);
    }
    private void newMyFragmentActivity1(){
        Intent i = new Intent(MainActivity1.this,MyFragmentActivity1.class);
        startActivity(i);
    }
    private void newNotificationActivity(){
        Intent i = new Intent(MainActivity1.this,NotificationActivity.class);
        startActivity(i);
    }
    private void newDialogActivity(){
        Intent i = new Intent(MainActivity1.this,DialogActivity.class);
        startActivity(i);
    }
    private void newPopwindowActivity(){
        Intent i = new Intent(MainActivity1.this,PopwindowActivity.class);
        startActivity(i);
    }
    private void newMenuActivity(){
        Intent i = new Intent(MainActivity1.this,MenuActivity.class);
        startActivity(i);
    }

}
