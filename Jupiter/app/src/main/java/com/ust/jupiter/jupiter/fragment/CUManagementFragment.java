package com.ust.jupiter.jupiter.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ust.jupiter.jupiter.R;


public class CUManagementFragment extends Fragment {
    TextView txCUBlockNumber;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cu_management, container, false);
        txCUBlockNumber = (TextView) view.findViewById(R.id.text_cu_mangement_block_num);


        return view;
    }

}
