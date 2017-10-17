package com.ust.jupiter.jupiter.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContentResolverCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import com.ust.jupiter.jupiter.R;

public class OverviewFragment extends Fragment {

    private Context context;
    private Button button;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        this.context = getActivity();
        this.button = (Button) view.findViewById(R.id.create_account);
        this.textView = (TextView) view.findViewById(R.id.text_current_last_block);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("fuck");
                save(context);
            }
        });

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
        String address = sharedPreferences.getString("address","");
        System.out.println(address);
    }

    public static void saveAccount(String fileName, Context context) {
        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("hkust DB");
            writer.write("hkust123");
            writer.write("0x16obUsfXvcYq6mXXC2XxyUGyq57MRFjCKu");
            System.out.println("fuck");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
