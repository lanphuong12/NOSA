package com.example.myapplication.Applicant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    BottomNavigationView btn;

    int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicant_home);

        Anhxa();
        GetData_intent();

        loadFragment(new Applicant_Fragment_main());

        btn.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.applicantmain:
                        fragment = new Applicant_Fragment_main();
                        loadFragment(fragment);
                        return true;
                    case R.id.savedjob:
                        fragment = new Applicant_Fragment_savedJob();
                        loadFragment(fragment);
                        return true;
                    case R.id.appliedcv:
                        fragment = new Applicant_Fragment_cvApplied();
                        loadFragment(fragment);
                        return true;
                    case R.id.info:
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