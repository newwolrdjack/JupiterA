package com.ust.jupiter.jupiter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ust.jupiter.jupiter.R;


public class CUJoiningFragment extends Fragment {

    private TextView cuName;
    private TextView cuType;
    private TextView cuBuildTime;
    private TextView cuMaxmember;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cu_joining, container, false)
        return view;
    }


}
