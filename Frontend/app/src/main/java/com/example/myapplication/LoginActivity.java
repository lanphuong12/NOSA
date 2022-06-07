package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.Applicant.Adapter.DanhmucnganhngheAdapter;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.Nganhnghe;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ArrayList<Danhmucnganhnghe> mang_danhmucnn;
    ArrayList<Nganhnghe> mang_nganhnghe;
    DanhmucnganhngheAdapter danhmucnn_adapter;
    ListView lv_dmnn;
    ArrayList<Integer> arrIdnganhnghe;
    Button btSaveDMNN;
    int id_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Anhxa();
    }

    private void Anhxa() {
    }

    public void Log_in(View view) {
    }

    public void Create_new(View view) {

    }
}