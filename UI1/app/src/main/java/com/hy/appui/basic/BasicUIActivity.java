package com.hy.appui.basic;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.hy.app.ui1.R;


/**
* 基本界面组件
 *
 * TextView
 * EditText  TextInputLayout
 * 普通Button
 * ImageButton
 * 单选按钮RadioButton&RadioGroup
 * CheckBox
 * ToggleButton
 * AnalogClock&TextClock&Chronometer（时钟与简单的计时器）
 * ImageView
 * AutoCompleteTextView
 * Spinner
 *
 */
public class BasicUIActivity extends Activity {
    String tag = "060_BasicActivity";
    Button startButton;
    Button stopButton;
    Chronometer newChronometer;
    AutoCompleteTextView mAutoCompleteTextView;
    Spinner mspinner;

    //一定要使用一个成员变量，不然DbHelper内存回收会导致DB无法使用
    private DbHelper mDbHelper;
    private SQLiteDatabase mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        /**
         * TextView
         */
        TextView mtextview = findViewById(R.id.mtextview);
        mtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BasicUIActivity.this, "TextView被点击", Toast.LENGTH_SHORT);
            }
        });

        /**
         * ImageView
         */
        ImageView mimageview = findViewById(R.id.mimageview);
        mimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BasicUIActivity.this, "ImageView被点击", Toast.LENGTH_SHORT);
            }
        });


        /**
         * 自动补全文本框AutoCompleteTextView
         */
        mAutoCompleteTextView = findViewById(R.id.auto_complete_text_view);
        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                mAutoCompleteTextView.setText(textView.getText());
            }
        });

        AutoCompleteAdapter adapter = new AutoCompleteAdapter(this);
        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                if (constraint == null || constraint.length() == 0) {
                    return null;
                }

                return mDb.rawQuery("SELECT _id," + DbHelper.COL_SCHOOL_NAME
                        + " FROM " + DbHelper.SCHOOLS_TABLE_NAME
                        + " WHERE " + DbHelper.COL_SCHOOL_NAME
                        + " LIKE \'%" + constraint.toString() + "%\'", null);
            }
        });
        mAutoCompleteTextView.setAdapter(adapter);

        /**
         * 普通EditText
         */
        final EditText mname = findViewById(R.id.medittext);
        mname.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                mname.setTextColor(Color.BLUE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("060_", "smname : " + s.toString());
            }
        });

        /**
         * EditText TextInputLayout
         */
        final TextInputLayout tilname =  findViewById(R.id.til_name);
        final EditText editText = tilname.getEditText();
        tilname.setHint("Name");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 4) {
                    tilname.setError("Password error");
                    tilname.setErrorEnabled(true);
                } else {
                    tilname.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        final TextInputLayout tilpwd =  findViewById(R.id.til_pwd);
        final EditText editText1 = tilpwd.getEditText();
        tilpwd.setHint("Password");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 4) {
                    tilpwd.setError("Password error");
                    tilpwd.setErrorEnabled(true);
                } else {
                    tilpwd.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editText1.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        /**
         * 普通Button
         */
        Button mbutton = findViewById(R.id.mbutton);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(tag, "普通Button被按下");
                Toast.makeText(BasicUIActivity.this, "普通Button被点击", Toast.LENGTH_LONG);
            }
        });

        /**
         * ImageButton
         */
        ImageButton mimagebutton = findViewById(R.id.mimagebutton);
        mimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(tag, "ImageButton被按下");
                Toast.makeText(BasicUIActivity.this, "ImageButton被点击", Toast.LENGTH_LONG);
            }
        });

        /**
         * ToggleButton
         */
        ToggleButton mtogglebutton = findViewById(R.id.mtogglebutton);
        mtogglebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO: 2017/11/20
                if(isChecked){
                    Log.e(tag, "mtogglebutton被按下");
                    Toast.makeText(BasicUIActivity.this, "ToggleButton被点击", Toast.LENGTH_LONG);
                }else{

                }
            }
        });

        /**
         * 单选按钮RadioButton&RadioGroup
         *
         * RadioGroup设置默认选中，如果在xml 布局文件中需要控制一个RadioButton 默认选中，就需要给他设置一个id。如果不设置id 的话，就会导致该RadioButton 一直是选中状态。
         */
        RadioGroup group = findViewById(R.id.radioGroup);
        //绑定一个匿名监听器
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                Toast.makeText(BasicUIActivity.this, "您的性别是：" + rb.getText(), Toast.LENGTH_LONG);
                Log.e(tag, "您的性别是：" + rb.getText());
            }
        });

        /**
         * CheckBox
         */
        CheckBox beijing = findViewById(R.id.beijing);
        beijing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            //给CheckBox设置事件监听
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    Log.e(tag, buttonView.getText()+"选中");
                }else{
                    Log.e(tag, buttonView.getText()+"取消选中");
                }
            }
        });

        /**
         * AnalogClock&TextClock&Chronometer（时钟与简单的计时器）
         */
        newChronometer = findViewById(R.id.newChronometer);
        newChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {//这里chronometer是触发该监听器的对象
                if(SystemClock.elapsedRealtime()- chronometer.getBase()>60000) {
                    //SystemClock.elapsedRealtime()返回毫秒，自启动以来开始计时,包括睡眠的时间。
                    chronometer.stop();//停止计时
                    Log.v(tag, ">60000");
                }
            }
        });

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        startButton.setOnClickListener(new View.OnClickListener() {   //Chronometer开始计时button
            @Override
            public void onClick(View v) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                newChronometer.setBase(SystemClock.elapsedRealtime());
                newChronometer.start();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {   //Chronometer停止计时button
            @Override
            public void onClick(View v) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                newChronometer.stop();
            }
        });


        /**
         * DatePicker（日期选择控件）、TimePicker（时间选择控件）、DatePickerDialog（日期选择对话框）、TimePickerDialog（时间选择对话框）
         * https://www.cnblogs.com/plokmju/p/android_DatePiceker.html
         */

        /**
         * 进度条控件ProgressBar、拖动条控件SeekBar、星级评分控件RatingBar
         * https://www.cnblogs.com/plokmju/p/android_ProgressBar.html
         */

        /**
         * 下拉列表选择框Spinner
         */
        mspinner = findViewById(R.id.spinner1);
        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] bps = getResources().getStringArray(R.array.bps);
                Toast.makeText(BasicUIActivity.this, "你点击的是:" + bps[pos], Toast.LENGTH_SHORT).show();

                switch (pos) {
                    case 0:
                        // TODO: 2017/12/11
                        break;
                    case 1:
                        // TODO: 2017/12/11
                        break;
                    case 2:
                        // TODO: 2017/12/11
                        break;
                    default:
                        // TODO: 2017/12/11
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

    }
}

/**

 CheckBox
 android CheckBox控件的定义及事件监听 http://blog.csdn.net/w6980112/article/details/52457320
 android:checked="true"
 通过checkbox.isChecked();是判断后是否选中，
 checkbox.setChecked(true|false)是赋某个checkbox选中。

 ToggleButton
 http://wiki.jikexueyuan.com/project/twenty-four-Scriptures/toggle-button-switch.html
 常用的属性很简单就两个：
 android:textOff：按钮关闭时显示的文本
 android:textOn：按钮开启时显示的文本
 android:checked="true"

 AnalogClock&TextClock&Chronometer（时钟与简单的计时器）
 http://blog.csdn.net/z_kaif/article/details/51088201

 自动补全文本框AutoCompleteTextView
 http://blog.csdn.net/yjp19871013/article/details/62049125

 下拉列表选择框Spinner
 http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0105/2264.html

 DatePicker（日期选择控件）、TimePicker（时间选择控件）、DatePickerDialog（日期选择对话框）、TimePickerDialog（时间选择对话框）
 https://www.cnblogs.com/plokmju/p/android_DatePiceker.html


 */