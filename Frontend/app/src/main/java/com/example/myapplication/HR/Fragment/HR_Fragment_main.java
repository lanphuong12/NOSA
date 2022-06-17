package com.example.myapplication.HR.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HR_Fragment_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HR_Fragment_main extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.hr_fragment_main, container, false);
    }
}