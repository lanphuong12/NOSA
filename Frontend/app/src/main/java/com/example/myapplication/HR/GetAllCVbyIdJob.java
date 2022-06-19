package com.example.myapplication.HR;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Applicant.Adapter.AlliedJobAdapter;
import com.example.myapplication.HR.Adapter.JobnewAdapter;
import com.example.myapplication.HR.Fragment.HR_Fragment_CV_Manager;
import com.example.myapplication.HR.Fragment.HR_Fragment_Companymanager;
import com.example.myapplication.HR.Fragment.HR_Fragment_Jobmanager;
import com.example.myapplication.HR.Fragment.HR_Fragment_main;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllCVbyIdJob extends AppCompatActivity {

    ListView lv_listcvapplied;
    AlliedJobAdapter alliedJobAdapter;
    ArrayList<AppliedJob> mangCV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        int idJob = (int) getIntent().getSerializableExtra("id_job");
        int idUser = (int) getIntent().getSerializableExtra("idUserAcc");
        Anhxa();

        Toolbar TopActivityToolbar = findViewById(R.id.toolbar);
        TopActivityToolbar.setTitle("Danh sách CV");
        TopActivityToolbar.inflateMenu(R.menu.home);

        // and finally set click listener
        TopActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent = new Intent(GetAllCVbyIdJob.this, HR_Fragment_main.class);
                        intent.putExtra("idUserAcc", idUser);
                        startActivity(intent);
                        break;
                    default:break;
                }
                return false;
            }
        });

        lv_listcvapplied.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllCVbyIdJob.this, GetAllCVbyIdJob.class);
                intent.putExtra("idUserAcc", idUser);
                intent.putExtra("id_cv", mangCV.get(position).getIdNopcv());
                startActivity(intent);
            }
        });

        lv_listcvapplied.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu p = new PopupMenu(GetAllCVbyIdJob.this, view);
                MenuInflater inflater = p.getMenuInflater();
                inflater.inflate(R.menu.update_cv, p.getMenu());
                p.show();
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.reject:
                                SetStatusCVapplied(idJob,mangCV.get(position).getIdNopcv(), 0);
                                break;
                            case R.id.consider:
                                SetStatusCVapplied(idJob, mangCV.get(position).getIdNopcv(), 3);
                                break;
                            case R.id.approve:
                                SetStatusCVapplied(idJob, mangCV.get(position).getIdNopcv(), 2);
                                break;
                            default:break;
                        }
                        return false;
                    }
                });
                return true;
            }
        });
        GetAllCVappliedByIdJob(idJob);

    }

    private void SetStatusCVapplied(Integer idJob, Integer idNopcv, int status) {
        Dataservice dataservice = APIService.getService();
        Call<Void> callback = dataservice.UpdateStatusCV(idNopcv, status);
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (status == 0){
                    Toast.makeText(GetAllCVbyIdJob.this, "Bạn đã loại CV này!", Toast.LENGTH_SHORT).show();
                }
                if (status == 2){
                    Toast.makeText(GetAllCVbyIdJob.this, "Bạn đã chấp nhận CV này!", Toast.LENGTH_SHORT).show();
                }
                if (status == 3){
                    Toast.makeText(GetAllCVbyIdJob.this, "Bạn cần xem xét lại CV này!", Toast.LENGTH_SHORT).show();
                }
                GetAllCVappliedByIdJob(idJob);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(GetAllCVbyIdJob.this, "Update trạng thái CV thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetAllCVappliedByIdJob(int idJob) {
        mangCV.clear();
        Dataservice dataservice = APIService.getService();
        Call<List<AppliedJob>> callback = dataservice.GetCVByIdJob(idJob);
        callback.enqueue(new Callback<List<AppliedJob>>() {
            @Override
            public void onResponse(Call<List<AppliedJob>> call, Response<List<AppliedJob>> response) {
                ArrayList<AppliedJob> cvapplied = (ArrayList<AppliedJob>) response.body();
                //Log.d("api",response.toString());
                for (AppliedJob cv: cvapplied){
                    mangCV.add(cv);
                }
                alliedJobAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AppliedJob>> call, Throwable t) {

            }
        });
    }


    private void Anhxa() {
        lv_listcvapplied = findViewById(R.id.list_view_NNQT);
        mangCV = new ArrayList<>();
        alliedJobAdapter = new AlliedJobAdapter(mangCV, GetAllCVbyIdJob.this);
        lv_listcvapplied.setAdapter(alliedJobAdapter);
    }

}
