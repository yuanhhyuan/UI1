package com.hy.appui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hy.app.ui1.R;


/**

 */
public class FragmentOne extends Fragment implements View.OnClickListener {

    private OnItemClickedListener mylistener;
    Button button;

    public interface OnItemClickedListener {
        public void onClick(String info);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i ("DetailFragment", "==onAttach()");
        if (getActivity() instanceof OnItemClickedListener) {
            mylistener = (OnItemClickedListener) getActivity();
        }
    }


    //相当于Activity的onCreate方法，用来初始化数据和视图
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //让碎片加载一个布局
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Toast.makeText(this.getActivity(), "fragment初始化提示消息", Toast.LENGTH_SHORT).show();
        initView(view);

        //获取从MyFragmentActivity传递过来的信息
        Bundle bundle = getArguments();
        if (bundle != null) {
            Toast.makeText(this.getActivity(),bundle.getString("msg"),Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this.getActivity(),"没有收到信息！",Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void initView(View view) {
        button =  view.findViewById(R.id.onclick_btn);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        mylistener.onClick("我是fragmentone传递给宿主的信息！");
        Toast.makeText(this.getActivity(), "fragment内部button按钮提示", Toast.LENGTH_SHORT).show();
    }
}
