package com.example.yodut.ui.kalendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.yodut.DetailTugasActivity;
import com.example.yodut.R;
import com.example.yodut.ui.tugas.Tugas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentKalendar extends Fragment {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kalendar, container, false);



        return view;
    }
}