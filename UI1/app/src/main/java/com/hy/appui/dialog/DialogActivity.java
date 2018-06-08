package com.hy.appui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.app.ui1.R;

import java.util.ArrayList;

/**
 * android 8种对话框（Dialog）使用方法汇总
 * https://www.cnblogs.com/gzdaijie/p/5222191.html
 *
 * 不能指定显示位置，只能默认显示在屏幕最中间
 */
public class DialogActivity extends Activity {
    Button mbutton1;
    Button mbutton2;
    Button mbutton3;
    Button mbutton4;
    Button mbutton5;
    Button mbutton6;
    Button mbutton7;
    Button mbutton8;
    Button mbutton9;
    Button mbutton10;

    Button mbutton11;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
        initListener();
    }

    //view
    private void initView() {
        mbutton1 =  findViewById(R.id.mbutton1);
        mbutton2 =  findViewById(R.id.mbutton2);
        mbutton3 =  findViewById(R.id.mbutton3);
        mbutton4 =  findViewById(R.id.mbutton4);
        mbutton5 =  findViewById(R.id.mbutton5);
        mbutton6 =  findViewById(R.id.mbutton6);
        mbutton7 =  findViewById(R.id.mbutton7);
        mbutton8 =  findViewById(R.id.mbutton8);
        mbutton9 =  findViewById(R.id.mbutton9);
        mbutton10 =  findViewById(R.id.mbutton10);

        mbutton11 =  findViewById(R.id.mbutton11);
        if (dialog == null) {
            dialog = MyDialog.createLoadingDialog(DialogActivity.this, "测量中....");
        }
    }

    //listener
    private void initListener() {
        mbutton1.setOnClickListener(new MyListener());
        mbutton2.setOnClickListener(new MyListener());
        mbutton3.setOnClickListener(new MyListener());
        mbutton4.setOnClickListener(new MyListener());
        mbutton5.setOnClickListener(new MyListener());
        mbutton6.setOnClickListener(new MyListener());
        mbutton7.setOnClickListener(new MyListener());
        mbutton8.setOnClickListener(new MyListener());
        mbutton9.setOnClickListener(new MyListener());
        mbutton10.setOnClickListener(new MyListener());

        mbutton11.setOnClickListener(new MyListener());
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.mbutton1:
                    showDialog1();
                    break;
                case R.id.mbutton2:
                    showDialog2();
                    break;
                case R.id.mbutton3:
                    showListDialog3();
                    break;
                case R.id.mbutton4:
                    showSingleChoiceDialog4();
                    break;
                case R.id.mbutton5:
                    showMultiChoiceDialog5();
                    break;
                case R.id.mbutton6:
                    showInputDialog();
                    break;
                case R.id.mbutton7:

                    break;
                case R.id.mbutton8:
                    showWaitingDialog();
                    break;
                case R.id.mbutton9:
                    showProgressDialog();
                    break;
                case R.id.mbutton10:
                    Log.e("060","mbutton10");
                    initCountDownDialog();
                    break;

                case R.id.mbutton11:
                    Log.e("060","mbutton11");
                    Toast.makeText(DialogActivity.this, "mbutton11", Toast.LENGTH_SHORT).show();
                    initDialogAnim();
                    break;
                default:
                    break;
            }
        }
    }

    protected void initDialogAnim() {
        Toast.makeText(DialogActivity.this, "initDialogAnim", Toast.LENGTH_SHORT).show();
        Log.e("060","initDialogAnim");
        //开启动画
        timer.start();
        dialog.show();
    }

    /**
     * ***************************************************************************************************************************
     *  系统自带的基础dialog的使用（比较难看）
     * （dialog控件是系统控件，textview\button 等）
     * ***************************************************************************************************************************
     * */

    /**
     * 确定取消dialog
     * */
    private void showDialog1() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(DialogActivity.this);
        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("确定取消Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("是",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2017/11/22
                        Toast.makeText(DialogActivity.this, "是", Toast.LENGTH_SHORT).show();
                    }
                });
        normalDialog.setNegativeButton("否",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2017/11/22
                        Toast.makeText(DialogActivity.this, "否", Toast.LENGTH_SHORT).show();
                    }
                });
        // 显示
        normalDialog.create().show();
    }

    /**
     * 多个提示信息dialog
     * */
    private void showDialog2() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(DialogActivity.this);
        normalDialog.setIcon(R.drawable.icon_dialog);
        normalDialog.setTitle("多个按钮提示框");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("是",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2017/11/22
                        Toast.makeText(DialogActivity.this, "是", Toast.LENGTH_SHORT).show();
                    }
                });
        normalDialog.setNegativeButton("否",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2017/11/22
                        Toast.makeText(DialogActivity.this, "否", Toast.LENGTH_SHORT).show();
                    }
                });
        normalDialog.setNeutralButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2017/11/22
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
        // 显示
        normalDialog.create().show();
    }

    /**
     * 列表dialog
     * */
    private void showListDialog3() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(DialogActivity.this);
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                Toast.makeText(DialogActivity.this,
                        "你点击了" + items[which],
                        Toast.LENGTH_SHORT).show();

                switch (which) {
                    case 0:
                        Toast.makeText(DialogActivity.this,
                                "你点击了" + which,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(DialogActivity.this,
                                "你点击了" + which,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(DialogActivity.this,
                                "你点击了" + which,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(DialogActivity.this,
                                "你点击了" + which,
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        listDialog.show();
    }

    /**
     * 单项选择dialog
     * */
    int mSingleChoiceID = -1;

    private void showSingleChoiceDialog4() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};

        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);

        mSingleChoiceID = -1;
        builder.setIcon(R.drawable.icon_dialog);
        builder.setTitle("单项选择");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                mSingleChoiceID = whichButton;
                Toast.makeText(DialogActivity.this,
                        "你选择的id为" + whichButton + " , " + items[whichButton],
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (mSingleChoiceID > 0) {
                    Toast.makeText(DialogActivity.this,
                            "你选择的是" + mSingleChoiceID,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Toast.makeText(DialogActivity.this,
                        "你选择的是" + mSingleChoiceID,
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    /**
     * 多项选择dialog
     * */
    ArrayList<Integer> yourChoices = new ArrayList<>();

    private void showMultiChoiceDialog5() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[] = {false, false, false, false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog =
                new AlertDialog.Builder(DialogActivity.this);
        multiChoiceDialog.setTitle("我是一个多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            yourChoices.add(which);
                        } else {
                            yourChoices.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = yourChoices.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[yourChoices.get(i)] + " ";
                        }
                        Toast.makeText(DialogActivity.this,
                                "你选中了" + str,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        multiChoiceDialog.show();
    }

    /**
     *  编辑dialog
     *  */
    private void showInputDialog() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(DialogActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(DialogActivity.this);
        inputDialog.setTitle("我是一个输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    /**
     *  等待dialog
     *  */
    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        ProgressDialog waitingDialog=
                new ProgressDialog(DialogActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    /**
     *  进度条dialog
     *  */
    private void showProgressDialog() {
    /* @setProgress 设置初始进度
     * @setProgressStyle 设置样式（水平进度条）
     * @setMax 设置进度最大值
     */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog =
                new ProgressDialog(DialogActivity.this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
    /* 模拟进度增加的过程
     * 新开一个线程，每个100ms，进度增加1
     */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress= 0;
                while (progress < MAX_PROGRESS){
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }


    /**
     * 带倒计时的Dialog
     */
    private TextView mOffTextView;
    public void initCountDownDialog(){
        final MyCountDownTimer mytimer = new MyCountDownTimer(5000, 1000);
        mytimer.start();

        mOffTextView = new TextView(this);
        android.support.v7.app.AlertDialog mDialog = new android.support.v7.app.AlertDialog.Builder(this)
                .setTitle("提示")
                .setCancelable(false)
                .setView(mOffTextView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mytimer.cancel();

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        mytimer.cancel();
                    }
                })
                .create();
        mDialog.show();
        mDialog.setCanceledOnTouchOutside(false);
    }

    /*定义一个倒计时的内部类*/
    class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {
//            Intent i = new Intent(DialogActivity.this,BasicUIActivity.class);
//            startActivity(i);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            mOffTextView.setText("    即将关闭：" + (millisUntilFinished / 1000)+ "");
        }
    }

    /**
     * MyDialog对应的定时器
     */
    private CountDownTimer timer = new CountDownTimer(3000, 1000) {
        @Override
        public void onTick(long l) {
            MyDialog.getTipTextView().setText("倒计时：" + l / 1000 + "s");
        }

        @Override
        public void onFinish() {
            dialog.cancel();
        }
    };

}
