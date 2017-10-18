package com.ust.jupiter.jupiter.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ust.jupiter.jupiter.R;
import java.util.UUID;

public class OverviewFragment extends Fragment {

    private Context context;
    private TextView txCurrentCUAddress;
    private TextView txCurrentSumCUMember;
    private TextView txCurrentActiveCUMember;
    private TextView txLastBlockNumber;
    private TextView txCurrentExtenalPeers;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        this.txCurrentCUAddress = (TextView) view.findViewById(R.id.text_overview_current_cu_address);
        this.txCurrentActiveCUMember = (TextView) view.findViewById(R.id.text_overview_current_cu_active_peers);
        this.txCurrentSumCUMember = (TextView) view.findViewById(R.id.text_overview_current_cu_total_peers);
        this.txLastBlockNumber = (TextView) view.findViewById(R.id.text_overview_current_last_block);
        this.txCurrentExtenalPeers = (TextView) view.findViewById(R.id.text_overview_current_p2p_total_peers);

        this.context = getActivity();
        SharedPreferences userShared = this.context.getSharedPreferences("user", Context.MODE_APPEND);
        SharedPreferences cuShared = this.context.getSharedPreferences("cuData", Context.MODE_APPEND);
        if(userShared.getString("account","").isEmpty()) {
            this.save(context);
        } else {
            txCurrentCUAddress.setText(getCurrentCUAddress(cuShared));
            txCurrentSumCUMember.setText(getCurrentCUMaxMember(cuShared));
        }
        return view;
    }

    public void save(Context cont) {
        SharedPreferences.Editor editor = cont.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
        editor.putString("address", UUID.randomUUID().toString());
        editor.putString("account", "Jupiter");
        editor.putString("password", "hkust123");
        editor.apply();
    }

    public String getCurrentCUAddress(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("address","");
    }

    public String getCurrentCUMaxMember(SharedPreferences sharedPreferences) {
        return String.valueOf(sharedPreferences.getInt("maxmember",0));

    }

}
