package com.example.myapplication.HR.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.HR.Adapter.ComanyAdapter;
import com.example.myapplication.HR.Adapter.JobnewAdapter;
import com.example.myapplication.HR.GetAllCVbyIdJob;
import com.example.myapplication.HR.GetAllJobByIdCompany;
import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.Model.CompanyHR;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HR_Fragment_Companymanager extends Fragment {

    ListView lv_job;
    ComanyAdapter comanyAdapter;
    ArrayList<CompanyHR> mang_cty;

    HrHomeActivity hrHomeActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.hr_fragment_companymanager, container, false);

        hrHomeActivity = (HrHomeActivity) getActivity();
        int User = hrHomeActivity.getIdUser();
        initUI();

        Toolbar TopActivityToolbar = mView.findViewById(R.id.toolbar);
        TopActivityToolbar.setTitle("Quản lý công ty");
        TopActivityToolbar.inflateMenu(R.menu.home2);

        // and finally set click listener
        TopActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.add:
                        ThemCongtymoi(User);
                        break;

                    case R.id.logout:
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:break;
                }
                return false;
            }
        });

        getAllCompanyCreated(User);

        lv_job.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GetAllJobByIdCompany.class);
                intent.putExtra("idUserAcc", User);
                intent.putExtra("id_company", mang_cty.get(position).getIdCongty());
                startActivity(intent);
            }
        });

        return mView;
    }

    private void ThemCongtymoi(int user) {

    }

    private void getAllCompanyCreated(int user) {
        Dataservice dataservice = APIService.getService();
        Call<List<CompanyHR>> callback = dataservice.GetAllCompanyCreatedbyidHR(user);
        callback.enqueue(new Callback<List<CompanyHR>>() {
            @Override
            public void onResponse(Call<List<CompanyHR>> call, Response<List<CompanyHR>> response) {
                ArrayList<CompanyHR> cty = (ArrayList<CompanyHR>) response.body();
                for (CompanyHR cv: cty){
                    mang_cty.add(cv);
                }
                comanyAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<CompanyHR>> call, Throwable t) {
                Toast.makeText(hrHomeActivity, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUI() {
        lv_job = mView.findViewById(R.id.lv_companymanager);
        mang_cty = new ArrayList<>();
        comanyAdapter = new ComanyAdapter(mang_cty, getActivity());
        lv_job.setAdapter(comanyAdapter);
    }
}