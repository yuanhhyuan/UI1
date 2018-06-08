package com.hy.appui.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hy.app.ui1.R;


/**
动态加载fragment
 */
public class MyFragmentActivity extends AppCompatActivity implements View.OnClickListener,FragmentOne.OnItemClickedListener {

    private Button frist;
    private Button two;
    private Button back_btn;
    private FragmentManager mFragmentManager;
    private FrameLayout framelayout;
    private Fragment mFragmentOne,mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initView();
        initDefaultFragment();

    }

    //初始化默认fragment的加载
    private void initDefaultFragment() {

        //开启一个事务
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        //add：往碎片集合中添加一个碎片；
        //replace：移除之前所有的碎片，替换新的碎片（remove和add的集合体）(很少用，不推荐，因为是重新加载，所以消耗流量)。参数：1.公共父容器的的id  2.fragment的碎片
        //        fragmentTransaction.add(R.id.framelayout, mFragmentOne);
        fragmentTransaction.replace(R.id.framelayout, mFragmentOne);


        //提交事务
        fragmentTransaction.commit();
    }

    private void initView() {
        frist = (Button) findViewById(R.id.frist);
        two = (Button) findViewById(R.id.two);
        back_btn = (Button) findViewById(R.id.back_btn);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);

        frist.setOnClickListener(this);
        two.setOnClickListener(this);
        back_btn.setOnClickListener(this);

        //实例化FragmentOne
        mFragmentTwo = new FragmentTwo();
        mFragmentOne = new FragmentOne();

        //获取碎片管理者
        mFragmentManager = getFragmentManager();
    }

    //通过点击事件跳转到对应的fragment上
    @Override
    public void onClick(View v) {
        //开启一个事务
//        FragmentTransaction fragmentTransaction1 = mFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.frist:
//                fragmentTransaction1.replace(R.id.framelayout,mFragmentOne);
//                fragmentTransaction1.addToBackStack("one");

                FragmentOne fragment = new FragmentOne();
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Hello Fragment!!!");
                fragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.framelayout, fragment, "content_fragment");
                transaction.addToBackStack("one");
                transaction.commit();

                break;
            case R.id.two:
                FragmentManager manager1 = getFragmentManager();
                FragmentTransaction transaction1 = manager1.beginTransaction();
                transaction1.replace(R.id.framelayout,mFragmentTwo);
                transaction1.addToBackStack("two");
                transaction1.commit();
//                fragmentTransaction1.replace(R.id.framelayout,mFragmentTwo);
//                fragmentTransaction1.addToBackStack("two");
//                fragmentTransaction1.commit();
                break;
            case R.id.back_btn:
                mFragmentManager.popBackStack();
        }
    }


    @Override
    public void onClick(String info) {
        // 实际项目中，我们是将Fragment_A传给宿主的信息拿到后，再通过setArguments()传递给Fragment_B。
        //这样就实现了两个Fragment之间的数据传递。
        Toast.makeText(this,info, Toast.LENGTH_SHORT).show();
        Log.e("060",info);
    }
}

/**
 Fragment详解
 http://blog.csdn.net/harvic880925/article/details/44917955

 动态添加Fragment主要分为4步：
 1.获取到FragmentManager，在V4包中通过getSupportFragmentManager，在系统中原生的Fragment是通过getFragmentManager获得的。
 2.开启一个事务，通过调用beginTransaction方法开启。
 3.向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
 4.提交事务，调用commit方法提交。


 FragmentTransaction事务回滚使用方法

 要使用回滚功能，只需要要使用下面两个代码：
 在transaction.commit()之前，使用addToBackStack()将其添加到回退栈中。
 [java] view plain copy
 transaction.addToBackStack(String tag);
 在需要回退时，使用popBackStack()将最上层的操作弹出回退栈。
 [java] view plain copy
 manager.popBackStack();
 这里的popBackStack()是弹出默认的最上层的栈顶内容。



 安卓Fragment使用详解
 http://blog.csdn.net/wuqingyidongren/article/details/51480412


 */