package com.ust.jupiter.jupiter.fragment;


import android.content.Context;
import android.content.SharedPreferences;
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
    private Context context;
    private TextView cuAddress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cu_joining, container, false);
        this.context = getActivity();
        this.cuName = (TextView) view.findViewById(R.id.text_cu_joining_name);
        this.cuType = (TextView) view.findViewById(R.id.text_cu_joining_type);
        this.cuBuildTime = (TextView) view.findViewById(R.id.text_cu_joining_build_time);
        this.cuMaxmember = (TextView) view.findViewById(R.id.text_cu_joining_number);
        this.cuAddress = (TextView) view.findViewById(R.id.text_current_cu_address);
        SharedPreferences sharedPreferences = context.getSharedPreferences("cuData",context.MODE_PRIVATE);
        cuName.setText(sharedPreferences.getString("name",""));
        if(sharedPreferences.getBoolean("type",false)) {
            cuType.setText("Public");
        }
        cuMaxmember.setText(String.valueOf(sharedPreferences.getInt("maxmember",0)));
        cuAddress.setText(sharedPreferences.getString("address",""));
        cuBuildTime.setText(sharedPreferences.getString("date",""));
        return view;
}


}
