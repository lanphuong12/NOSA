package com.example.myapplication.Applicant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.NganhngheQuantamAdapter;
import com.example.myapplication.Applicant.Adapter.SkillJob_adapter;
import com.example.myapplication.Applicant.Fragment.Applicant_Fragment_main;
import com.example.myapplication.Applicant.Fragment.JobDetailFragment_JobIn4;
import com.example.myapplication.Applicant.Fragment.JobDetail_Fragment_CompanyIn4;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.SkillJob;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetailActivity extends AppCompatActivity implements SkillJob_adapter.OnSkillJobListener {

    ImageView img_logocompany;
    TextView tv_namecompany, tv_namejob;
    RecyclerView rcv_listskilljob;
    Button bt_jobdetail, bt_companydetail, bt_savejob, bt_applycvtojob;
    Job congviec;
    ArrayList<SkillJob> listSkillJob = new ArrayList<>();
    SkillJob_adapter skillJob_adapter;
    int IdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_detail);
        Anhxa();
        GetDataIntent();
        GetSkillJobbyIdJob(congviec.getIdCongviec());

        Picasso.get().load(congviec.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(img_logocompany);
        tv_namecompany.setText(congviec.getTencty());
        tv_namejob.setText(congviec.getTenjob());

        loadFragment(new JobDetailFragment_JobIn4());
        bt_jobdetail.setBackgroundResource(R.drawable.button5);
    }

    private void GetDataIntent() {
        IdUser = (int) getIntent().getSerializableExtra("idUserAcc");
        congviec = (Job) getIntent().getSerializableExtra("id_job");
    }

    private void GetSkillJobbyIdJob(int idCongviec) {
        Dataservice dataservice = APIService.getService();
        Call<List<SkillJob>> callback = dataservice.GetSkillJobbyIdJob(idCongviec);
        callback.enqueue(new Callback<List<SkillJob>>() {
            @Override
            public void onResponse(Call<List<SkillJob>> call, Response<List<SkillJob>> response) {
                ArrayList<SkillJob> arr = (ArrayList<SkillJob>) response.body();
                for (SkillJob skillJob : arr) {
                    listSkillJob.add(skillJob);
                }

                skillJob_adapter.setData(listSkillJob);
                rcv_listskilljob.setAdapter(skillJob_adapter);
            }

            @Override
            public void onFailure(Call<List<SkillJob>> call, Throwable t) {

            }
        });
    }

    private void Anhxa() {
        img_logocompany = findViewById(R.id.imgv_logocty);
        tv_namecompany = findViewById(R.id.tv_namecpmpany);
        tv_namejob = findViewById(R.id.tv_namejob);
        rcv_listskilljob = findViewById(R.id.lv_skillsjob);
        bt_jobdetail = findViewById(R.id.bt_jobdetail);
        bt_companydetail = findViewById(R.id.bt_companydetail);
        bt_savejob = findViewById(R.id.bt_savejob);
        bt_applycvtojob = findViewById(R.id.bt_applyto);

        listSkillJob = new ArrayList<>();
        skillJob_adapter = new SkillJob_adapter(listSkillJob, this);
    }

    private void loadFragment(Fragment fragment) {
        // load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public int getIdJob() {
        congviec = (Job) getIntent().getSerializableExtra("id_job");
        return congviec.getIdCongviec();
    }

    public void JobDetail(View view) {
        Fragment fragment;
        bt_jobdetail.setBackgroundResource(R.drawable.button5);
        bt_companydetail.setBackgroundResource(R.drawable.button1);
        fragment = new JobDetailFragment_JobIn4();
        loadFragment(fragment);
    }

    public void CompanyDetail(View view) {
        Fragment fragment;
        bt_jobdetail.setBackgroundResource(R.drawable.button1);
        bt_companydetail.setBackgroundResource(R.drawable.button5);
        fragment = new JobDetail_Fragment_CompanyIn4();
        loadFragment(fragment);
    }

    public void SaveJob(View view) {
        Dataservice dataservice = APIService.getService();
        Call<Void> callback = dataservice.SaveJob(IdUser, congviec.getIdCongviec());
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(JobDetailActivity.this, "Lưu công việc thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(JobDetailActivity.this, ApplicantHomeActivity.class);
                intent.putExtra("idUserAcc",IdUser);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(JobDetailActivity.this, "Lưu công việc thất bại! Vui lòng thử lại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ApplyCVtoJob(View view) {
        Intent intent = new Intent(JobDetailActivity.this, Apply_to_job.class);
        intent.putExtra("idUserAcc", IdUser);
        intent.putExtra("id_job", congviec);
        startActivity(intent);
    }

    @Override
    public void OnSkillJobClick(int position) {
        SkillJob skillJob = listSkillJob.get(position);
        Intent intent = new Intent(JobDetailActivity.this, ListJob.class);
        intent.putExtra("idUserAcc",IdUser);
        intent.putExtra("id_skilljob", skillJob.getIdSkill());
        startActivity(intent);
    }
}