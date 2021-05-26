package com.example.yodut.ui.home;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yodut.R;
import com.example.yodut.TambahTugasActivity;
import com.example.yodut.ui.kalendar.FragmentKalendar;
import com.example.yodut.ui.tugas.FragmentTugas;
import com.example.yodut.ui.tugas.Tugas;
import com.example.yodut.ui.tugas.TugasAdaptor;
import com.example.yodut.ui.tugas.TugasViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public TugasViewModel tugasViewModel;
    private Button btnTugas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        TugasAdaptor tugasAdaptor = new TugasAdaptor(new TugasAdaptor.WordDiff());
//
//        //   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FragmentTugas.this);
////        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(tugasAdaptor);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(
                getActivity().getApplication())).get(TugasViewModel.class);
//        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(View -> {
            Intent intent = new Intent(getContext(), TambahTugasActivity.class);
            startActivityForResult(intent, 1);
        });

//        btnTugas = (Button) root.findViewById(R.id.btnTugas);
//        btnTugas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTugas fragmentTugas = new FragmentTugas();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.placeholder, fragmentTugas);
//                fragmentTransaction.commit();
//
//            }
//        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Tugas tugas = new Tugas(data.getStringExtra(TambahTugasActivity.EXTRA_REPLY)
                    ,data.getStringExtra("Deadline")
                    ,data.getStringExtra("MataKuliah")
                    ,data.getStringExtra("Deskripsi"));
            //   , R.drawable.ic_launcher_background);
            tugasViewModel.insert(tugas);
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}

//        btnTugas = (Button) view.findViewById(R.id.btnTugas);
//        btnTugas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTugas fragmentTugas = new FragmentTugas();
//                fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.placeholder, fragmentTugas);
//                fragmentTransaction.commit();
//
//            }
//        });
//        btnKalendar = (Button) view.findViewById(R.id.btnKalendar);
//        btnKalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentKalendar fragmentKalendar = new FragmentKalendar();
//                fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.placeholder, fragmentKalendar);
//                fragmentTransaction.commit();
//            }
//        });


