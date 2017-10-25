package com.ust.jupiter.jupiter.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.vondear.rxtools.*;
import butterknife.InjectView;

import com.ust.jupiter.jupiter.R;
import com.vondear.rxtools.view.RxQRCode;


public class ReceiveTokenFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_token, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_user_qr_address);

        RxQRCode.createQRCode("https://github.com/vondear/RxTools",800,800,imageView);
        return view;

    }

}
