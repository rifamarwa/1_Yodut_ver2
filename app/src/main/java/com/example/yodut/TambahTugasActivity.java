package com.example.yodut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class TambahTugasActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditNamaTugas, mEditDeadline, mEditMataKuliah, mEditDeskripsi;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_tugas);
        mEditNamaTugas = findViewById(R.id.editNamaTugas);
        mEditDeadline = findViewById(R.id.editDeadline);
        mEditMataKuliah = findViewById(R.id.editMataKuliah);
        mEditDeskripsi = findViewById(R.id.editDeskripsi);
        save = findViewById(R.id.buttonSave);

        save.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNamaTugas.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String namaTugas = mEditNamaTugas.getText().toString();
                String deadline = mEditDeadline.getText().toString();
                String mataKuliah = mEditMataKuliah.getText().toString();
                String deskripsi = mEditDeskripsi.getText().toString();

                replyIntent.putExtra(EXTRA_REPLY, namaTugas);
                replyIntent.putExtra("Deadline", deadline);
                replyIntent.putExtra("MataKuliah", mataKuliah);
                replyIntent.putExtra("Deskripsi", deskripsi);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }
}