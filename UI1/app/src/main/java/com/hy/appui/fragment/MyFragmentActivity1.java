package com.hy.appui.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;

import com.hy.app.ui1.R;


/**
静态加载fragment
 */
public class MyFragmentActivity1 extends AppCompatActivity {

    private Button frist;
    private Button two;
    private Button back_btn;
    private FragmentManager mFragmentManager;
    private FrameLayout framelayout;
    private Fragment mFragmentOne, mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);

        FragmentManager manager = getFragmentManager();



    }
}
