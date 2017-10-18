package com.ust.jupiter.jupiter.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ust.jupiter.jupiter.R;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OverviewFragment extends Fragment {

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        this.context = getActivity();
        return view;
    }

    public static void save(Context cont) {
//        SharedPreferences.Editor editor = cont.getSharedPreferences("account", Context.MODE_PRIVATE).edit();
//        editor.putString("address", "0x16obUsfXvcYq6mXXC2XxyUGyq57MRFjCKu");
//        editor.putString("account", "hkust");
//        editor.putString("password", "hkust123");
//        editor.apply();
//        editor.commit();
        SharedPreferences sharedPreferences = cont.getSharedPreferences("account", Context.MODE_PRIVATE);
        String address = sharedPreferences.getString("address", "");
        System.out.println(address);
    }

}
