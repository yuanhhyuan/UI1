package com.hy.appui.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hy.app.ui1.R;


/**
 menu

 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    Button mContextMenu;
    Button mPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mContextMenu = (Button) findViewById(R.id.mContextMenu);
        registerForContextMenu(mContextMenu);  //为按钮绑定上下文菜单（注意不是绑定监听器）。长按button1，才能弹出

        mPopupMenu = (Button) findViewById(R.id.mPopupMenu); //PopupMenu绑定到button2
        mPopupMenu.setOnClickListener(this);
    }

    /**
     * ******************* Options menu***********************
     */
    //创建Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //填充选项菜单（读取XML文件、解析、加载到Menu组件上）
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    //Options menu的触发事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.start:
                Toast.makeText(this, "开始游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.over:
                Toast.makeText(this, "结束游戏", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ******************* ContextMenu***********************
     */
    //创建上下文菜单ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu1, menu);
    }

    //上下文菜单ContextMenu的触发事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                Toast.makeText(this, "开始···", Toast.LENGTH_SHORT).show();
                break;

            case R.id.over:
                Toast.makeText(this, "结束···", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return super.onContextItemSelected(item);
    }

    /**
     * ******************* PopupMenu***********************
     */
    //点击按钮后，加载弹出式菜单
    @Override
    public void onClick(View v) {
        //创建弹出式菜单对象（最低版本11）
        PopupMenu popup = new PopupMenu(this, v);//第二个参数是绑定的那个view
        //获取菜单填充器
        MenuInflater inflater = popup.getMenuInflater();
        //填充菜单
        inflater.inflate(R.menu.menu1, popup.getMenu());
        //绑定菜单项的点击事件
        popup.setOnMenuItemClickListener(this);
        popup.show(); //这一行代码不要忘记了
    }

    //弹出式菜单的单击事件处理
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.start:
                Toast.makeText(this, "start···", Toast.LENGTH_SHORT).show();
                break;

            case R.id.over:
                Toast.makeText(this, "over···", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }

}

/**
 Android系列之UI组件----Menu菜单
 http://blog.csdn.net/u013256622/article/details/52799176

 一、Options menu选项菜单：
 使用Toolbar+menu的app:showAsAction属性不起作用的问题分析及解决
 http://blog.csdn.net/cekiasoo/article/details/51815140


 二、Context menu：上下文菜单


 三、Popup menu：弹出式菜单

 */