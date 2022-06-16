package com.example.myapplication.Applicant.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.Model.SkillJob;
import com.example.myapplication.R;

import java.util.ArrayList;

public class SkillJob_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<SkillJob> listitems;
    private OnSkillJobListener mOnskillJobListener;

    public SkillJob_adapter(ArrayList<SkillJob> listitems, OnSkillJobListener mOnskillJobListener) {
        this.listitems = listitems;
        this.mOnskillJobListener = mOnskillJobListener;
    }

    public void setData(ArrayList<SkillJob> list) {
        this.listitems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_job_adapter, parent, false);
        return new SkillJobViewHolder(view, mOnskillJobListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SkillJob skillJob = listitems.get(position);
        SkillJobViewHolder vocabViewHolder = (SkillJobViewHolder) holder;
        vocabViewHolder.tenSkillJob.setText(skillJob.getTen());
    }

    @Override
    public int getItemCount() {
        if (listitems != null) {
            return listitems.size();
        }
        return 0;
    }

    public class SkillJobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tenSkillJob;
        OnSkillJobListener onSkillJobListener;

        public SkillJobViewHolder(@NonNull View itemView, OnSkillJobListener onSkillJobListener) {
            super(itemView);
            tenSkillJob = itemView.findViewById(R.id.tv_skilljob);
            this.onSkillJobListener = onSkillJobListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSkillJobListener.OnSkillJobClick(getAdapterPosition());
        }
    }

    public interface OnSkillJobListener {
        void OnSkillJobClick(int position);
    }
}