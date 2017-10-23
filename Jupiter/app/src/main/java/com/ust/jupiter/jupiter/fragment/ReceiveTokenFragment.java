package com.ust.jupiter.jupiter.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ust.jupiter.jupiter.R;
import com.ust.jupiter.jupiter.activity.RegisterActivity;

import butterknife.OnClick;


public class ReceiveTokenFragment extends Fragment {

    private Function functions = new Function();
    private TextView outputTxtView;
    private Button button;
    ImageView qrcode1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receive_token, container, false);
        button = (Button) view.findViewById(R.id.button_receive);
        final EditText editText = (EditText) view.findViewById(R.id.text_receive_address);
        outputTxtView = (TextView) view.findViewById(R.id.text_receive_address_hash);
        qrcode1 = (ImageView) view. findViewById(R.id.image_cu_qr_address);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = functions.hashText((editText).getText().toString());
                qrcode1.setImageBitmap(QRCode.createQRCode(output));
            }
        });
         return view;
    }
}
