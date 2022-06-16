package com.example.myapplication.Applicant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Applicant.Adapter.JobtoApplicantAdapter;
import com.example.myapplication.Model.Job;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListJob extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ImageButton bt_search;
    ListView lv_jobtoapplicant;
    JobtoApplicantAdapter jobtoApplicantAdapter;
    ArrayList<Job> mang_job;
    int IdSkill, IdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_job);
        GetDataIntent();
        getDataJobtoApplicant(IdSkill);
        Anhxa();
        lv_jobtoapplicant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListJob.this, JobDetailActivity.class);
                intent.putExtra("idUserAcc", IdUser);
                intent.putExtra("id_job", mang_job.get(position));
                startActivity(intent);
            }
        });
    }

    private void getDataJobtoApplicant(int idSkill) {
        Dataservice dataservice = APIService.getService();
        Call<List<Job>> callback = dataservice.GetJobbyIdSkill(idSkill);
        callback.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                ArrayList<Job> congviec = (ArrayList<Job>) response.body();
                for (Job job : congviec){
                    mang_job.add(job);
                }
                jobtoApplicantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Toast.makeText(ListJob.this, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetDataIntent() {
        IdSkill = (int) getIntent().getSerializableExtra("id_skilljob");
        IdUser = (int) getIntent().getSerializableExtra("idUserAcc");
    }

    private void Anhxa() {
        autoCompleteTextView =findViewById(R.id.edt_search_word);
        bt_search = findViewById(R.id.imgbt_search);
        lv_jobtoapplicant = findViewById(R.id.lv_jobtoApplicant);
        mang_job = new ArrayList<>();
        jobtoApplicantAdapter = new JobtoApplicantAdapter(mang_job, ListJob.this);
        lv_jobtoapplicant.setAdapter(jobtoApplicantAdapter);
    }

}
