package com.example.yodut.ui.tugas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yodut.MainActivity;
import com.example.yodut.R;
import com.example.yodut.TambahTugasActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FragmentTugas extends Fragment {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private TugasAdaptor.TugasViewHolder mTugasViewHolder;
    private RecyclerView recyclerView;
    private TugasViewModel tugasViewModel;


    public FragmentTugas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tugas, container, false);

//        fab = view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), TambahTugasActivity.class);
//                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//            }
//        });
//        FloatingActionButton fab = view.findViewById(R.id.fab);
//        fab.setOnClickListener(View -> {
//            Intent intent = new Intent(getContext(), TambahTugasActivity.class);
//            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        TugasAdaptor tugasAdaptor = new TugasAdaptor(new TugasAdaptor.WordDiff());

        //   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FragmentTugas.this);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tugasAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(
                getActivity().getApplication())).get(TugasViewModel.class);
        tugasViewModel.getmAllTugas().observe(getViewLifecycleOwner(), tugas -> {
            // Update the cached copy of the words in the adapter.
            tugasAdaptor.submitList(tugas);
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }



//    public void getData()
//    {
//        tugasArrayList = new ArrayList<>();
//        tugasArrayList.add(new Tugas("Buat Mind Map", "4 April 2021","PPL 1 Praktik"));
//        tugasArrayList.add(new Tugas("Resume Jurnal", "30 Maret 2021","PKN"));
//        tugasArrayList.add(new Tugas("Eksplorasi Sensor", "28 Maret 2021","PPL 4"));
//        tugasArrayList.add(new Tugas("Buat Aplikasi Keuangan", "4 April 2021","PPB"));
//        tugasArrayList.add(new Tugas("Latihan Statistika Deskriptif", "2 Maret 2021","Statistika"));
//        tugasArrayList.add(new Tugas("Buat MindMap", "4 Maret","PPL 1 Praktik"));
//        tugasArrayList.add(new Tugas("Buat Mind Map", "4 Maret","PPL 1 Praktik"));
//        tugasArrayList.add(new Tugas("Buat Mind Map", "4 Maret","PPL 1 Praktik"));
//        tugasArrayList.add(new Tugas("Buat Mind Map", "4 Maret","PPL 1 Praktik"));
//    }

//    @Override
//    public void gotoDetailTugas(Tugas tugas) {
//        Intent intent = new Intent(recyclerView.getContext(), DetailTugasActivity.class);
//        recyclerView.getContext().startActivity(intent);
//
//    }
}