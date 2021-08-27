package com.example.moodle.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moodle.databinding.ItemQuizCourseBinding;
import com.example.moodle.model.ModelQuizByCourse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AdapterQuizByCourse extends RecyclerView.Adapter<AdapterQuizByCourse.ViewHolder> {


    ArrayList<ModelQuizByCourse> userCourseArrayList = new ArrayList<>();
    Context context;
    int klik = 0;


    public AdapterQuizByCourse(ArrayList<ModelQuizByCourse> userCourseArrayList, Context context) {
        this.userCourseArrayList.clear();
        this.userCourseArrayList = userCourseArrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemQuizCourseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<ModelQuizByCourse> item = userCourseArrayList;

        holder.binding.quizNama.setText(item.get(position).name);

        if (item.get(position).attempts == 0) {
            holder.binding.quizBisa.setText("Tidak Ada Kesempatan");
        } else {
            holder.binding.quizDitutup.setText(createDate(item.get(position).timeclose));
            holder.binding.quizWaktu.setText(createTime(item.get(position).timelimit));
            holder.binding.quizKesempatan.setText(String.valueOf(item.get(position).attempts));
            holder.binding.quizBisa.setText(" Ada Kesempatan");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (klik == 0 && item.get(position).attempts != 0) {
                    holder.binding.layoutKerjakan.setVisibility(View.VISIBLE);
                    klik++;
                } else {
                    holder.binding.layoutKerjakan.setVisibility(View.GONE);
                    klik--;
                }
            }
        });
    }

    public String createDate(long timestamp) {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        c.setTimeInMillis(timestamp * 1000L);
        Date d = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return sdf.format(d);
    }

    public String createTime(long timestamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        Date d = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(d);
    }

    @Override
    public int getItemCount() {
        return userCourseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemQuizCourseBinding binding;

        public ViewHolder(@NonNull ItemQuizCourseBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
