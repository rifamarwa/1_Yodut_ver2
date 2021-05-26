package com.example.yodut.ui.tugas;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_tugas")
public class Tugas {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "NamaTugas")
    private String namaTugas;
    @ColumnInfo(name = "Deadline")
    private String deadline;
    private String mataKuliah;
    private String deskripsi;
  //  private int idGambar;

//    public Tugas(@NonNull String namaTugas, String deadline, String mataKuliah, String deskripsi, int idGambar) {
//        this.namaTugas = namaTugas;
//        this.deadline = deadline;
//        this.mataKuliah = mataKuliah;
//        this.deskripsi = deskripsi;
//        this.idGambar = idGambar;
//    }

    public Tugas(@NonNull String namaTugas, String deadline, String mataKuliah, String deskripsi) {
        this.namaTugas = namaTugas;
        this.deadline = deadline;
        this.mataKuliah = mataKuliah;
        this.deskripsi = deskripsi;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getDeskripsi() { return deskripsi; }

    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

//    public int getIdGambar() { return idGambar; }
//
//    public void setIdGambar(int idGambar) { this.idGambar = idGambar; }
}
