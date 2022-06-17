package com.example.myapplication.Applicant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_Info;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_cvApplied;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_main;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_savedJob;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ApplicantHomeActivity extends AppCompatActivity {

    private ActionBar toolbar;
    BottomNavigationView btn;

    int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicant_home);


        Anhxa();
        GetData_intent();

        toolbar = getSupportActionBar();
        // Đặt Fragment mặc định
        toolbar.setTitle("Applicant Main");
        loadFragment(new Applicant_Fragment_main());

        btn.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.applicantmain:
                        toolbar.setTitle("Trang chủ");
                        fragment = new Applicant_Fragment_main();
                        loadFragment(fragment);
                        return true;
                    case R.id.savedjob:
                        toolbar.setTitle("Job saved");
                        fragment = new Applicant_Fragment_savedJob();
                        loadFragment(fragment);
                        return true;
                    case R.id.appliedcv:
                        toolbar.setTitle("CV applied");
                        fragment = new Applicant_Fragment_cvApplied();
                        loadFragment(fragment);
                        return true;
                    case R.id.info:
                        toolbar.setTitle("Information");
                        fragment = new Applicant_Fragment_Info();
                        loadFragment(fragment);
                        return true;
                }
                return true;
            }
        });

    }

    private void GetData_intent() {
        idUser = (int) getIntent().getSerializableExtra("idUserAcc");
    }

    private void Anhxa() {
        btn = findViewById(R.id.bt_navigation);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                Intent intent = new Intent(ApplicantHomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        // load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public int getIdUser() {
        idUser = (int) getIntent().getSerializableExtra("idUserAcc");
        return idUser;
    }
}