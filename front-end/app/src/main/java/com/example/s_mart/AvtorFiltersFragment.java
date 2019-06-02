package com.example.s_mart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AvtorFiltersFragment extends Fragment {

    public AvtorFiltersFragment() {
    }

    public static AvtorFiltersFragment newInstance() {
        return new AvtorFiltersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_avtor_filters, container, false);
    }
}
