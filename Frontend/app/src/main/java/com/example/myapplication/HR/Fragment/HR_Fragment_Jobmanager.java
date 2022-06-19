package com.example.myapplication.HR.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Applicant.Adapter.JobtoApplicantAdapter;
import com.example.myapplication.HR.Adapter.CandidateAdapter;
import com.example.myapplication.HR.Adapter.JobnewAdapter;
import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HR_Fragment_Jobmanager extends Fragment {

    ListView lv_job;
    JobnewAdapter jobnewAdapter;
    ArrayList<Jobnew> mang_job;

    HrHomeActivity hrHomeActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.hr_fragment_jobmanager, container, false);
        hrHomeActivity = (HrHomeActivity) getActivity();
        int User = hrHomeActivity.getIdUser();
        initUI();

        Toolbar TopActivityToolbar = mView.findViewById(R.id.toolbar);
        TopActivityToolbar.setTitle("HR main");
        TopActivityToolbar.inflateMenu(R.menu.log_out);

        // and finally set click listener
        TopActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.logout:
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:break;
                }
                return false;
            }
        });

        getAllJobCreated(User);

        return mView;
    }

    private void getAllJobCreated(int user) {
        Dataservice dataservice = APIService.getService();
        Call<List<Jobnew>> callback = dataservice.GetAllJobCreatedbyidHR(user);
        callback.enqueue(new Callback<List<Jobnew>>() {
            @Override
            public void onResponse(Call<List<Jobnew>> call, Response<List<Jobnew>> response) {
                ArrayList<Jobnew> job = (ArrayList<Jobnew>) response.body();
                //Log.d("api",response.toString());
                for (Jobnew cv: job){
                    mang_job.add(cv);
                }
                jobnewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Jobnew>> call, Throwable t) {

            }
        });
    }

    private void initUI() {
        lv_job = mView.findViewById(R.id.lv_jobmanager);
        mang_job = new ArrayList<>();
        jobnewAdapter = new JobnewAdapter(mang_job, getActivity());
        lv_job.setAdapter(jobnewAdapter);
    }
}