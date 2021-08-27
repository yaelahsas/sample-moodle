package com.example.moodle.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moodle.databinding.ItemPilihanBinding;
import com.example.moodle.model.ModelQuiz;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterQuiz extends RecyclerView.Adapter<AdapterQuiz.ViewHolder> {

    private static RadioButton lastChecked = null;
    private static int lastCheckedPos = 0;
    ArrayList<ModelQuiz> listHistori = new ArrayList<>();
    Context context;


    public AdapterQuiz(ArrayList<ModelQuiz> listHistori, Context context) {
        this.listHistori.clear();
        this.listHistori = listHistori;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemPilihanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<ModelQuiz> item = listHistori;
        holder.binding.namaPertanyaan.setText(item.get(position).getSoal());
        holder.binding.pilihanQuis.setSelected(item.get(position).isSelected());

        if (holder.binding.pilihanQuis.isChecked()) {
            item.get(position).setSelected(true);
            lastChecked = holder.binding.pilihanQuis;
            lastCheckedPos = position;
        }
        holder.binding.pilihanQuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButton = (RadioButton) v;
                if (radioButton.isChecked()) {
                    if (lastChecked != null) {
                        lastChecked.setChecked(false);
                        item.get(position).setSelected(false);
                    }
                    lastChecked = radioButton;
                    lastCheckedPos = position;
                } else {
                    lastChecked = null;
                    item.get(position).setSelected(radioButton.isChecked());
                }
            }
        });

    }


    public String change(int value) {
        Locale localeID1 = new Locale("in", "ID");
        NumberFormat nettonya = NumberFormat.getCurrencyInstance(localeID1);
        nettonya.setMaximumFractionDigits(0);
        return nettonya.format(Double.parseDouble(String.valueOf(value)));
    }

    @Override
    public int getItemCount() {
        return listHistori.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPilihanBinding binding;

        public ViewHolder(@NonNull ItemPilihanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
