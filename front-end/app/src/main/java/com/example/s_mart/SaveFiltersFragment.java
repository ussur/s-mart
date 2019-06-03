package com.example.s_mart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SaveFiltersFragment extends Fragment {

    public SaveFiltersFragment() {
    }

    public static SaveFiltersFragment newInstance() {
        return new SaveFiltersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_save_filters, container, false);
    }
}
