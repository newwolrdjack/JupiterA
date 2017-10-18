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
import com.ust.jupiter.jupiter.net.LocalStatus;
import com.ust.jupiter.jupiter.net.Network;

import java.util.UUID;

public class OverviewFragment extends Fragment {

    Context context;
    TextView txCurrentCUAddress;
    TextView txCurrentSumCUMember;
    TextView txCurrentActiveCUMember;
    TextView txLastBlockNumber;
    TextView txCurrentExternalPeers;
    Network network = new Network();
    LocalStatus localStatus = new LocalStatus();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        txCurrentCUAddress = (TextView) view.findViewById(R.id.text_overview_current_cu_address);
        txCurrentActiveCUMember = (TextView) view.findViewById(R.id.text_overview_current_cu_active_peers);
        txCurrentSumCUMember = (TextView) view.findViewById(R.id.text_overview_current_cu_total_peers);
        txLastBlockNumber = (TextView) view.findViewById(R.id.text_overview_current_last_block);
        txCurrentExternalPeers = (TextView) view.findViewById(R.id.text_overview_current_p2p_total_peers);

        this.context = getActivity();
        SharedPreferences userShared = this.context.getSharedPreferences("user", Context.MODE_APPEND);
        SharedPreferences cuShared = this.context.getSharedPreferences("cuData", Context.MODE_APPEND);
        if(userShared.getString("account","").isEmpty()) {
            this.save(context);
        } else {
            txCurrentCUAddress.setText(getCurrentCUAddress(cuShared));
            txCurrentSumCUMember.setText(getCurrentCUMaxMember(cuShared));
            txLastBlockNumber.setText(String.valueOf(localStatus.getCurrentLatestBlockNumber()));
            txCurrentActiveCUMember.setText(String.valueOf(network.getSumOfCUActiveMember("")));
            txCurrentExternalPeers.setText(String.valueOf(network.getCurrentExtenalPeers()));

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
