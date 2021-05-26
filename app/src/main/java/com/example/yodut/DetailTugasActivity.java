package com.example.yodut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailTugasActivity extends Activity {

    TextView tvNamaTugas, tvDeadline, tvMataKuliah, tvDeskripsi;
    String namaTugas, deadline, mataKuliah, deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tugas);

        tvNamaTugas = findViewById(R.id.text_nama_tugas);
        tvDeadline = findViewById(R.id.text_deadline);
        tvMataKuliah = findViewById(R.id.text_mata_kuliah);
        tvDeskripsi = findViewById(R.id.text_deskripsi);

//        Intent intent = getIntent();
//
//        namaTugas = intent.getStringExtra("nama_tugas");
//        String namaTugas = intent.getStringExtra("nama_tugas");
//        namaTugas.setText(namaTugas);

        getData();
        setData();
    }

    public void getData()
    {
        Bundle bundle = getIntent().getExtras();
        namaTugas = bundle.getString("NamaTugas");
        deadline = bundle.getString("Deadline");
        mataKuliah = bundle.getString("MataKuliah");
        deskripsi = bundle.getString("Deskripsi");
    }

    public void setData()
    {
        tvNamaTugas.setText(namaTugas);
        tvDeadline.setText(deadline);
        tvMataKuliah.setText(mataKuliah);
        tvDeskripsi.setText(deskripsi);
    }

//    public void onClick(View view)
//    {
//        Intent data = new Intent();
//        //Get the EditText view
//        EditText txt_username = (EditText) findViewById(R.id.txtUsername);
//        //Set the data to pass back
//        data.setData(Uri.parse(txt_username.getText().toString()));
//        setResult(RESULT_OK, data);
//        //Closes the activity
//        finish();
//    }
}