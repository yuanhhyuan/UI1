package com.hy.appui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.MainActivity1;
import com.hy.app.ui1.R;

/**
 * Activity标准形式
 *
 */
public class NotificationActivity extends AppCompatActivity {

    Button on;
    Button off;

    Context mContext = NotificationActivity.this;
    private Bitmap LargeBitmap = null;
    private NotificationManager myManager = null;
    private Notification myNotification;
    private static final int NOTIFICATION_ID_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Log.v("060", "MainActivity1 : ");

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView(){
        on = (Button) findViewById(R.id.on);
        off = (Button)findViewById(R.id.off);
    }

    private void initListener(){
        on.setOnClickListener(new MyListener());
        off.setOnClickListener(new MyListener());
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.on:
                    on();
                    break;
                case R.id.off:
                    off();
                    break;
                default:
                    break;
            }
        }
    }


    private void on(){

        //3.定义一个PendingIntent，点击Notification后启动一个Activity
        PendingIntent pi = PendingIntent.getActivity(
                mContext,
                100,
                new Intent(mContext, MainActivity1.class),
                PendingIntent.FLAG_CANCEL_CURRENT
        );


        //创建大图标的Bitmap
        LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        //1.从系统服务中获得通知管理器
        myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder myBuilder = new Notification.Builder(mContext);
        myBuilder.setContentTitle("QQ")
                .setContentText("这是内容")
                .setSubText("这是补充小行内容")
                .setTicker("您收到新的消息")
                //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(LargeBitmap)
                //设置默认声音和震动
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)//点击后取消
                .setWhen(System.currentTimeMillis())//设置通知时间
                .setPriority(Notification.PRIORITY_HIGH)//高优先级
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //android5.0加入了一种新的模式Notification的显示等级，共有三种：
                //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
                //VISIBILITY_PRIVATE 任何情况都会显示通知
                //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
                .setContentIntent(pi);  //3.关联PendingIntent
        myNotification = myBuilder.build();
        //4.通过通知管理器来发起通知，ID区分通知
        myManager.notify(NOTIFICATION_ID_1, myNotification);
    }

    private void off(){
       //除了根据ID来取消通知，还可以调用cancelAll()关闭该应用产生的所有通知
        myManager.cancel(NOTIFICATION_ID_1);
    }

}
