package com.example.myapplication.Applicant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Applicant.Adapter.DanhmucnganhngheAdapter;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AddSkillUser extends AppCompatActivity {

    ListView lv_dmnn;
    ArrayList<Integer> arrIdSkill;
    Button btSaveDMNN, btcancel;
    int id_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicant_apply_to_job);
        Anhxa();
    }

    public void Cancel(View view) {

    }

    public void Save(View view) {

    }

    private void Anhxa() {

        lv_dmnn = findViewById(R.id.lv_danhmucnganhnghe);
//        mang_danhmucnn = new ArrayList<>();
//        danhmucnn_adapter = new DanhmucnganhngheAdapter(mang_danhmucnn,ChooseDanhmucnganhngheActivity.this);
//        lv_dmnn.setAdapter(danhmucnn_adapter);
//        arrIdnganhnghe = new ArrayList<>();;
        btSaveDMNN = findViewById(R.id.bt_savengangnghe);
        btcancel = findViewById(R.id.cancel_button);
        btcancel.setText("Skip");
    }
}
