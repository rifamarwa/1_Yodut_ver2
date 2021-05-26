package com.example.yodut.ui.tugas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yodut.DetailTugasActivity;
import com.example.yodut.R;

import java.util.ArrayList;

//RecyclerView.Adapter<TugasAdaptor.TugasViewHolder>

public class TugasAdaptor extends ListAdapter<Tugas, TugasAdaptor.TugasViewHolder> {
    public TugasAdaptor(DiffUtil.ItemCallback<Tugas> diffCallback) {

        super(diffCallback);
    }

    public TugasAdaptor(@NonNull AsyncDifferConfig<Tugas> config) {
        super(config);
    }

    @NonNull
    @Override
    public TugasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_tugas, parent, false);
        TugasViewHolder tugasViewHolder = new TugasViewHolder(view);
        return tugasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TugasViewHolder holder, int position) {
        Tugas tugas = getItem(position);
        holder.tvNamaTugas.setText(tugas.getNamaTugas());
        holder.tvDeadline.setText(tugas.getDeadline());
        holder.tvMataKuliah.setText(tugas.getMataKuliah());
     //   holder.tvGambarTugas.setImageResource(tugas.getIdGambar());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("NamaTugas", tugas.getNamaTugas());
                bundle.putString("Deadline", tugas.getDeadline());
                bundle.putString("MataKuliah", tugas.getMataKuliah());
                bundle.putString("Deskripsi", tugas.getDeskripsi());
                Intent intent = new Intent(view.getContext(), DetailTugasActivity.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
    }


    static class WordDiff extends DiffUtil.ItemCallback<Tugas> {

        @Override
        public boolean areItemsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return oldItem.getNamaTugas().equals(newItem.getNamaTugas());
        }
    }

//    @Override
//    public int getItemCount() {
//        return (listTugas != null) ? listTugas.size() :0;
//    }
//

    public class TugasViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamaTugas, tvDeadline, tvMataKuliah, tvDeskripsi;
        private ImageView tvGambarTugas;
        private RelativeLayout relativeLayout;

        public TugasViewHolder(View view){
            super(view);

            this.tvNamaTugas = view.findViewById(R.id.tvNamaTugas);
            this.tvDeadline = view.findViewById(R.id.tvDeadline);
            this.tvMataKuliah = view.findViewById(R.id.tvMataKuliah);
            this.tvDeskripsi = view.findViewById(R.id.editDeskripsi);
          //  tvGambarTugas = view.findViewById(R.id.tvGambar);
            relativeLayout = view.findViewById(R.id.relativeLayout);

//            view.setOnClickListener((v ->  {
//                Bundle bundle = new Bundle();
//                bundle.putString("nama_tugas", listTugas.get(getAdapterPosition()).getNamaTugas());
//                bundle.putString("deadline", listTugas.get(getAdapterPosition()).getDeadline());
//                bundle.putString("mata_kuliah", listTugas.get(getAdapterPosition()).getMataKuliah());
//                Intent intent = new Intent(view.getContext(), DetailTugasActivity.class);
//                intent.putExtras(bundle);
//
////                intent.putExtra("nama_tugas", listTugas.get(getAdapterPosition()).getNamaTugas());
////                intent.putExtra("deadline", listTugas.get(getAdapterPosition()).getDeadline());
////                intent.putExtra("mata_kuliah",listTugas.get(getAdapterPosition()).getMataKuliah());
//                view.getContext().startActivity(intent);
//            }));

        }

    }

//    public interface TugasRecycler {
//        void gotoDetailTugas(Tugas tugas);
//    }


}

//TugasRecycler mListener;

//    mListenerpublic TugasAdaptor(ArrayList<Tugas> listTugas, TugasRecycler mListener) {
//
//        this.listTugas = listTugas;
//        this.mListener = mListener;
//    }
//
//    public TugasAdaptor(Context context, ArrayList<Tugas> listTugas) {
//        this.listTugas = listTugasas;
//    }
