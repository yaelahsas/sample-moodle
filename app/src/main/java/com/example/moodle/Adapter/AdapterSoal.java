package com.example.moodle.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moodle.databinding.ItemQuisBinding;
import com.example.moodle.model.ModelQuiz;
import com.example.moodle.model.ModelSoal;

import java.util.ArrayList;
import java.util.List;

public class AdapterSoal extends RecyclerView.Adapter<AdapterSoal.ViewHolder> {

    ArrayList<ModelSoal> listSoal = new ArrayList<>();
    Context context;
    AdapterQuiz adapterQuiz;


    public AdapterSoal(ArrayList<ModelSoal> listSoal, Context context) {
        this.listSoal.clear();
        this.listSoal = listSoal;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemQuisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<ModelSoal> item = listSoal;
        List<ModelQuiz> quiz = item.get(position).getPilihannya();
        adapterQuiz = new AdapterQuiz((ArrayList<ModelQuiz>) quiz, context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.binding.listPilihan.setLayoutManager(linearLayoutManager);
        holder.binding.listPilihan.setAdapter(adapterQuiz);

        holder.binding.judulQuis.setText(item.get(position).getPertanyaan());
    }


    @Override
    public int getItemCount() {
        return listSoal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemQuisBinding binding;

        public ViewHolder(@NonNull ItemQuisBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
