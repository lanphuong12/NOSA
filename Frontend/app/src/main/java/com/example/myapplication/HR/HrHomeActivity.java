package com.example.myapplication.HR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.Applicant.ApplicantHomeActivity;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_Info;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_cvApplied;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_main;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_savedJob;
import com.example.myapplication.HR.Fragment.HR_Fragment_CV_Manager;
import com.example.myapplication.HR.Fragment.HR_Fragment_Companymanager;
import com.example.myapplication.HR.Fragment.HR_Fragment_Jobmanager;
import com.example.myapplication.HR.Fragment.HR_Fragment_main;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HrHomeActivity extends AppCompatActivity {

    BottomNavigationView btn;
    int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hr_home);

        Anhxa();
        GetData_intent();

        loadFragment(new HR_Fragment_main());

        btn.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.hrmain:
                        fragment = new HR_Fragment_main();
                        loadFragment(fragment);
                        return true;
                    case R.id.jobmanager:
                        fragment = new HR_Fragment_Jobmanager();
                        loadFragment(fragment);
                        return true;
                    case R.id.companymanager:
                        fragment = new HR_Fragment_Companymanager();
                        loadFragment(fragment);
                        return true;
                    case R.id.managercv:
                        fragment = new HR_Fragment_CV_Manager();
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
        btn = findViewById(R.id.navigation);

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