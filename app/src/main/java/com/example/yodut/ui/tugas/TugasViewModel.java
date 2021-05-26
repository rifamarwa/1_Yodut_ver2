package com.example.yodut.ui.tugas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.yodut.database.TugasRepository;

import java.util.List;

public class TugasViewModel extends AndroidViewModel {

    private static TugasRepository mRepository;
    private final LiveData<List<Tugas>> mAllTugas;

    public TugasViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TugasRepository(application);
        mAllTugas = mRepository.getmAllTugas();
    }

    public LiveData<List<Tugas>> getmAllTugas()
    {
        return mAllTugas;
    }

    public static void insert(Tugas tugas) { mRepository.insert(tugas); }


}
