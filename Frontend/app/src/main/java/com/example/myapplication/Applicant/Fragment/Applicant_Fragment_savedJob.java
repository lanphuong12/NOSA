package com.example.myapplication.Applicant.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.JobtoApplicantAdapter;
import com.example.myapplication.Applicant.ApplicantHomeActivity;
import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.Model.Job;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Applicant_Fragment_savedJob extends Fragment {

    ListView lv_savedJob;
    JobtoApplicantAdapter jobtoApplicantAdapter;
    ArrayList<Job> mang_job;

    ApplicantHomeActivity mAppHomActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.applicant_fragment_saved_job, container, false);

        mAppHomActivity = (ApplicantHomeActivity) getActivity();
        int User = mAppHomActivity.getIdUser();
        getDataSavedJob(User);
        initUI();

        lv_savedJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idJob = mang_job.get(position).getIdCongviec();
                Intent intent = new Intent(getActivity(), JobDetailActivity.class);
                intent.putExtra("id_job", idJob);
                startActivity(intent);
            }
        });
        return mView;
    }

    private void getDataSavedJob(int User) {
        Dataservice dataservice = APIService.getService();
        Call<List<Job>> callback = dataservice.GetSavedJob(User);
        callback.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                ArrayList<Job> job = (ArrayList<Job>) response.body();
                //Log.d("api",response.toString());
                for (Job cv: job){
                    mang_job.add(cv);
                }
                jobtoApplicantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Toast.makeText(getActivity(), "Lấy dữ liệu thất bại ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initUI() {
        lv_savedJob = mView.findViewById(R.id.lv_savedjob);
        mang_job = new ArrayList<>();
        jobtoApplicantAdapter = new JobtoApplicantAdapter(mang_job, getActivity());
        lv_savedJob.setAdapter(jobtoApplicantAdapter);
    }

}