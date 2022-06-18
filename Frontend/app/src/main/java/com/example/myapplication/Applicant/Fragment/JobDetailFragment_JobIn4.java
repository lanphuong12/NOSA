package com.example.myapplication.Applicant.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
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

    TextView tv_requestjob, tv_salary, tv_amount, tv_typejob, tv_timejob, tv_description;

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


                tv_salary.setText("Lương: "+ jobDetail.getMinsalary() + "đ - " +jobDetail.getMaxsalary()+"đ");
                tv_amount.setText("Số lượng tuyển dụng: "+ jobDetail.getSoluongtuyendung().toString());
                tv_typejob.setText("Loại hình công việc: "+jobDetail.getTenloaihinhcv());
                tv_timejob.setText("Loại công việc: "+ jobDetail.getTenloaicv());
                tv_description.setText(Html.fromHtml(jobDetail.getMota()));
                tv_requestjob.setText(Html.fromHtml(jobDetail.getKinhnghiemchitiet()));

            }

            @Override
            public void onFailure(Call<JobDetail> call, Throwable t) {
                Toast.makeText(mJopJobDetailActivity, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        tv_salary = mView.findViewById(R.id.tv_salary);
        tv_amount = mView.findViewById(R.id.tv_soluongtuyendung);
        tv_typejob = mView.findViewById(R.id.tv_loaihinhcongviec);
        tv_timejob = mView.findViewById(R.id.tv_loaicongviec);
        tv_description = mView.findViewById(R.id.tv_jobdescription);
        tv_requestjob = mView.findViewById(R.id.tv_expJob);
    }
}