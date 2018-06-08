package com.hy.appui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hy.app.ui1.R;


/**
.
 */
public class FragmentTwo  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Toast.makeText(this.getActivity(), "fragment初始化提示消息", Toast.LENGTH_SHORT).show();
        return view;
    }
}
