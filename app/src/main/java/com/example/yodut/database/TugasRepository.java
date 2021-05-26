package com.example.yodut.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.yodut.ui.tugas.Tugas;
import com.example.yodut.database.TugasDao;
import com.example.yodut.database.TugasRoomDatabase;

import java.util.List;

public class TugasRepository {

    private TugasDao mTugasDao;
    private LiveData<List<Tugas>> mAllTugas;

    public TugasRepository(Application application)
    {
        TugasRoomDatabase tugasRoomDatabase = TugasRoomDatabase.getDatabase(application);
        mTugasDao = tugasRoomDatabase.tugasDao();
        mAllTugas = mTugasDao.getAlphabetizedWords();
    }

    public LiveData<List<Tugas>> getmAllTugas(){
        return mAllTugas;
    }

    public void insert(Tugas tugas)
    {
        TugasRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTugasDao.insert(tugas);
        });
    }
}
