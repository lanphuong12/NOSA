package com.example.myapplication.Applicant;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Objects;

public class DialogNganhnghe extends DialogFragment {
    RecyclerView recyclerView;
    Button bt_cancel, bt_save;

    Context context;
    ArrayList<Nganhnghe> nnArrayList = new ArrayList<>();
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_nganhnghe, container, false);
        recyclerView = v.findViewById(R.id.lv_nganhnghe);
        bt_cancel = v.findViewById(R.id.bt_cancelngangnghe);
        bt_save = v.findViewById(R.id.bt_savengangnghe);
        return v;
    }
}
