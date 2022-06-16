package com.example.myapplication.Applicant.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.AlliedJobAdapter;
import com.example.myapplication.Applicant.Adapter.JobtoApplicantAdapter;
import com.example.myapplication.Applicant.ApplicantHomeActivity;
import com.example.myapplication.Applicant.CVDetailActivity;
import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Job;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Applicant_Fragment_cvApplied extends Fragment {

    ListView lv_appliedJob;
    AlliedJobAdapter AppliedJobAdapter;
    ArrayList<AppliedJob> mang_job;

    ApplicantHomeActivity mAppHomActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.applicant_fragment_cv_applied, container, false);
        mAppHomActivity = (ApplicantHomeActivity) getActivity();
        int User = mAppHomActivity.getIdUser();
        getDataAppliedJob(User);
        initUI();

        lv_appliedJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idCV = mang_job.get(position).getIdNopcv();
                Intent intent = new Intent(getActivity(), CVDetailActivity.class);
                intent.putExtra("id_CV", idCV);
                startActivity(intent);
            }
        });
        return mView;
    }

    private void getDataAppliedJob(int User) {
        Dataservice dataservice = APIService.getService();
        Call<List<AppliedJob>> callback = dataservice.GetAppliedJob(User);
        callback.enqueue(new Callback<List<AppliedJob>>() {
            @Override
            public void onResponse(Call<List<AppliedJob>> call, Response<List<AppliedJob>> response) {
                ArrayList<AppliedJob> job = (ArrayList<AppliedJob>) response.body();
                //Log.d("api",response.toString());
                for (AppliedJob cv: job){
                    mang_job.add(cv);
                }
                AppliedJobAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AppliedJob>> call, Throwable t) {
                Toast.makeText(getActivity(), "Lấy dữ liệu thất bại ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initUI() {
        lv_appliedJob = mView.findViewById(R.id.lv_jobapplied);
        mang_job = new ArrayList<>();
        AppliedJobAdapter = new AlliedJobAdapter(mang_job, getActivity());
        lv_appliedJob.setAdapter(AppliedJobAdapter);
    }

}