package com.hy.appui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.hy.app.ui1.R;


/**
 PopupWindow是可以指定显示位置的，随便哪个位置都可以，更加灵活
 */
public class PopwindowActivity extends Activity implements CustomPopupWindow.OnItemClickListener {

    private CustomPopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwindow);

        mPop = new CustomPopupWindow(this);
        mPop.setOnItemClickListener(this);

        findViewById(R.id.id_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置PopupWindow中的位置
                mPop.showAtLocation(PopwindowActivity.this.findViewById(R.id.id_start), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
    }
    @Override
    public void setOnItemClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.id_btn_take_photo:
                Toast.makeText(getApplicationContext(), "拍照", Toast.LENGTH_LONG).show();
                break;
            case R.id.id_btn_select:
                Toast.makeText(getApplicationContext(),"从相册中选择", Toast.LENGTH_LONG).show();
                break;
            case R.id.id_btn_cancelo:
                mPop.dismiss();
                break;
        }
    }
}
