package com.ust.jupiter.jupiter.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ust.jupiter.jupiter.R;
import com.ust.jupiter.jupiter.primitives.ConsensusUnit;
import com.ust.jupiter.jupiter.utils.CommonUtils;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;


public class CUCreationFragment extends Fragment {

    private Button createButton;
    private Context context;
    private ConsensusUnit consensusUnit = new ConsensusUnit();
    private CommonUtils commonUtils = new CommonUtils();
    private EditText cuName;
    private EditText maxCUMember;
    private RadioGroup radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cu_overview, container, false);
        this.createButton = (Button) view.findViewById(R.id.button_create_cu);
        this.context = getActivity();
        this.cuName = (EditText) view.findViewById(R.id.text_cu_name);
        this.maxCUMember = (EditText) view.findViewById(R.id.text_cu_max_number);
        this.radioGroup = (RadioGroup) view.findViewById(R.id.radio_group_cu_type);
        this.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consensusUnit.setName(cuName.getText().toString());
                consensusUnit.setMaxCUmember(Integer.parseInt(maxCUMember.getText().toString()));
                consensusUnit.setAddress(UUID.randomUUID().toString());
                consensusUnit.setId(UUID.randomUUID().toString());
                consensusUnit.setBuildDate(new Date());
                System.out.println(DateFormat.getDateTimeInstance().format(consensusUnit.getBuildDate()));
                if (radioGroup.getCheckedRadioButtonId() == R.id.radio_is_public_cu) {
                    consensusUnit.setCUType(true);
                } else {
                    consensusUnit.setCUType(false);
                }
                createCU(context, consensusUnit);
            }
        });
        return view;
    }


    private Boolean createCU(Context cont, ConsensusUnit consensusUnit) {
        SharedPreferences sharedPreferences = cont.getSharedPreferences("cuData", cont.MODE_PRIVATE);
        SharedPreferences.Editor editor = cont.getSharedPreferences("cuData", cont.MODE_PRIVATE).edit();
        String address = sharedPreferences.getString("address", "");
        if (!address.isEmpty()) {
            Toast.makeText(cont,"Create CU failed, CU already exist",Toast.LENGTH_SHORT).show();
            System.out.println("Create CU failed, CU already exist");
        } else {
            editor.putString("address", consensusUnit.getAddress());
            editor.putInt("maxmember", consensusUnit.getMaxCUmember());
            editor.putString("name", consensusUnit.getName());
            editor.putString("id", consensusUnit.getId());
            editor.putString("date", DateFormat.getDateTimeInstance().format(consensusUnit.getBuildDate()));
            editor.putBoolean("type", true);
            editor.apply();
        }
        return true;
    }
}
