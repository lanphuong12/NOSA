package com.example.myapplication.Applicant.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.JobDetail;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetailFragment_JobIn4 extends Fragment {

    TextView tv_namejob, tv_salary, tv_amount, tv_typejob, tv_timejob, tv_description;

    JobDetailActivity mJopJobDetailActivity;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.job_detail_fragment_job_in4, container, false);
        mJopJobDetailActivity = (JobDetailActivity) getActivity();
        Anhxa();
        int IdJob = mJopJobDetailActivity.getIdJob();
        GetDataJobByIdJob(IdJob);
        return mView;
    }

    private void GetDataJobByIdJob(int idJob) {
        Dataservice dataservice = APIService.getService();
        Call<JobDetail> callback = dataservice.GetJobByIdJob(idJob);
        callback.enqueue(new Callback<JobDetail>() {
            @Override
            public void onResponse(Call<JobDetail> call, Response<JobDetail> response) {
                JobDetail jobDetail = response.body();

                tv_namejob.setText(jobDetail.getTenjob());
                tv_salary.setText(jobDetail.getMinsalary() + "đ - " +jobDetail.getMaxsalary()+"đ");
                tv_amount.setText(jobDetail.getSoluongtuyendung().toString());
                tv_typejob.setText(jobDetail.getTenloaihinhcv());
                tv_timejob.setText(jobDetail.getTenloaicv());
                tv_description.setText(jobDetail.getMota());

            }

            @Override
            public void onFailure(Call<JobDetail> call, Throwable t) {
                Toast.makeText(mJopJobDetailActivity, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        tv_namejob = mView.findViewById(R.id.tv_namejob);
        tv_salary = mView.findViewById(R.id.tv_salary);
        tv_amount = mView.findViewById(R.id.tv_soluongtuyendung);
        tv_typejob = mView.findViewById(R.id.tv_loaihinhcongviec);
        tv_timejob = mView.findViewById(R.id.tv_loaicongviec);
        tv_description = mView.findViewById(R.id.tv_jobdescription);
    }
}