package com.example.moodle.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moodle.activity.TampilQuiz;
import com.example.moodle.databinding.ItemCourseBinding;
import com.example.moodle.model.ModelUserCourse;

import java.util.ArrayList;

public class AdapterCourse extends RecyclerView.Adapter<AdapterCourse.ViewHolder> {


    ArrayList<ModelUserCourse> userCourseArrayList = new ArrayList<>();
    Context context;


    public AdapterCourse(ArrayList<ModelUserCourse> userCourseArrayList, Context context) {
        this.userCourseArrayList.clear();
        this.userCourseArrayList = userCourseArrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCourseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<ModelUserCourse> item = userCourseArrayList;

        holder.binding.courseNama.setText(item.get(position).fullname);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TampilQuiz.class);
                i.putExtra("course", item.get(position));
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return userCourseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCourseBinding binding;

        public ViewHolder(@NonNull ItemCourseBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
