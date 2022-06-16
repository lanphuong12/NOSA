package com.example.myapplication.Applicant.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;

public class NganhngheQuantamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Danhmucnganhnghe> listitems;
    private OnDMNNListener mOnDMNNListener;

    public NganhngheQuantamAdapter(ArrayList<Danhmucnganhnghe> listitems, OnDMNNListener mOnDMNNListener) {
        this.listitems = listitems;
        this.mOnDMNNListener = mOnDMNNListener;
    }

    public void setData(ArrayList<Danhmucnganhnghe> list) {
        this.listitems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nganhnghequantam_adapter, parent, false);
        return new VocabViewHolder(view, mOnDMNNListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Danhmucnganhnghe dmnn = listitems.get(position);
        VocabViewHolder vocabViewHolder = (VocabViewHolder) holder;
        vocabViewHolder.tenDMNNQT.setText(dmnn.getTendanhmuc());
    }

    @Override
    public int getItemCount() {
        if (listitems != null) {
            return listitems.size();
        }
        return 0;
    }

    public class VocabViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tenDMNNQT;
        OnDMNNListener onVocabListener;

        public VocabViewHolder(@NonNull View itemView, OnDMNNListener onVocabListener) {
            super(itemView);
            tenDMNNQT = itemView.findViewById(R.id.tv_danhmucnganhnghe);
            this.onVocabListener = onVocabListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onVocabListener.OnDMNNClick(getAdapterPosition());
        }
    }

    public interface OnDMNNListener {
        void OnDMNNClick(int position);
    }
}
