package com.example.yodut.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.yodut.R;
import com.example.yodut.ui.tugas.Tugas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Tugas.class}, version = 1, exportSchema = false)
public abstract class TugasRoomDatabase extends RoomDatabase {
    public abstract TugasDao tugasDao();

    private static volatile TugasRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TugasDao dao = INSTANCE.tugasDao();
            //    dao.deleteAll();

                Tugas cobaTugas1 = new Tugas("Buat jurnal", "4 April 2021", "Pancasila", "Mengenai pengaruh pancasila pada norma sosial"
                       );
                dao.insert(cobaTugas1);
                Tugas cobaTugas2 = new Tugas("Latihan Content Provider", "4 April 2021", "PPL 1 Praktik", "Tidak ada."
                     );
                dao.insert(cobaTugas2);

            });
        }
    };

    static TugasRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TugasRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TugasRoomDatabase.class, "tugas_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }




}
