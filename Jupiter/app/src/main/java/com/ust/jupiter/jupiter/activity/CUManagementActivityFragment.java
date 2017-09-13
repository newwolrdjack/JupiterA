package com.ust.jupiter.jupiter.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ust.jupiter.jupiter.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CUManagementActivityFragment extends Fragment {

    public CUManagementActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cumanagement, container, false);
    }
}
