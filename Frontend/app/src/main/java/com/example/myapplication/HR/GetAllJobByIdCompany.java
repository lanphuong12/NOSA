package com.example.myapplication.HR;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.Applicant.Adapter.AlliedJobAdapter;
import com.example.myapplication.HR.Adapter.JobnewAdapter;
import com.example.myapplication.HR.Fragment.HR_Fragment_main;
import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllJobByIdCompany extends AppCompatActivity {

    ListView lv_listjob;
    JobnewAdapter jobnewAdapter;
    ArrayList<Jobnew> mangJob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        int idCompany = (int) getIntent().getSerializableExtra("id_company");
        int idUser = (int) getIntent().getSerializableExtra("idUserAcc");
        Anhxa();

        Toolbar TopActivityToolbar = findViewById(R.id.toolbar);
        TopActivityToolbar.setTitle("Danh sách CV");
        TopActivityToolbar.inflateMenu(R.menu.home1);

        // and finally set click listener
        TopActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent = new Intent(GetAllJobByIdCompany.this, HR_Fragment_main.class);
                        intent.putExtra("idUserAcc", idUser);
                        startActivity(intent);
                        break;
                    case R.id.add:
                        ThemJob(idCompany);
                        break;
                    default:break;
                }
                return false;
            }
        });

        lv_listjob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllJobByIdCompany.this, GetAllCVbyIdJob.class);
                intent.putExtra("idUserAcc", idUser);
                intent.putExtra("id_job", mangJob.get(position).getIdCongviec());
                startActivity(intent);
            }
        });

        lv_listjob.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu p = new PopupMenu(GetAllJobByIdCompany.this, view);
                MenuInflater inflater = p.getMenuInflater();
                inflater.inflate(R.menu.menu_job, p.getMenu());
                p.show();
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.detail:
                                GetInfoJobByIdJob(mangJob.get(position).getIdCongviec());
                                break;
                            case R.id.update:
                                UpdateJobbyIdJob(mangJob.get(position).getIdCongviec());
                                break;
                            case R.id.delete:
                                DeleteJobbiIdJob(mangJob.get(position).getIdCongviec());
                                break;
                            default:break;
                        }
                        return false;
                    }
                });
                return true;
            }
        });
        GetAllJobCreatedByIdCompany(idCompany);

    }

    private void ThemJob(int idCompany) {

    }

    private void GetInfoJobByIdJob(Integer idCongviec) {

    }

    private void UpdateJobbyIdJob(Integer idCongviec) {

    }

    private void DeleteJobbiIdJob(Integer idCongviec) {

    }

    private void GetAllJobCreatedByIdCompany(int idCompany) {
        mangJob.clear();
        Dataservice dataservice = APIService.getService();
        Call<List<Jobnew>> callback = dataservice.GetJobByIdCty(idCompany);
        callback.enqueue(new Callback<List<Jobnew>>() {
            @Override
            public void onResponse(Call<List<Jobnew>> call, Response<List<Jobnew>> response) {
                ArrayList<Jobnew> job = (ArrayList<Jobnew>) response.body();
                //Log.d("api",response.toString());
                for (Jobnew cv: job){
                    mangJob.add(cv);
                }
                jobnewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Jobnew>> call, Throwable t) {

            }
        });
    }


    private void Anhxa() {
        lv_listjob = findViewById(R.id.list_view_NNQT);
        mangJob = new ArrayList<>();
        jobnewAdapter = new JobnewAdapter(mangJob, GetAllJobByIdCompany.this);
        lv_listjob.setAdapter(jobnewAdapter);
    }

}
