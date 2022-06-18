package com.example.myapplication.Applicant.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.Model.Company;
import com.example.myapplication.Model.JobDetail;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobDetail_Fragment_CompanyIn4 extends Fragment {
    TextView  tv_addCty, tv_emailCty, tv_phoneCty, tv_urlcty, tv_ctydescription;
    JobDetailActivity mJopJobDetailActivity;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.job_detail_fragment_company_in4, container, false);
        mJopJobDetailActivity = (JobDetailActivity) getActivity();
        Anhxa();
        int IdJob = mJopJobDetailActivity.getIdJob();
        GetDataCompanyByIdJob(IdJob);
        return mView;
    }

    private void GetDataCompanyByIdJob(int idJob) {
        Dataservice dataservice = APIService.getService();
        Call<Company> callback = dataservice.GetCompanybyIdJob(idJob);
        callback.enqueue(new Callback<Company>() {
            @Override
            public void onResponse(Call<Company> call, Response<Company> response) {
                Company cty = response.body();

                tv_addCty.setText("Địa chỉ: "+ cty.getDiachi());
                tv_emailCty.setText("Email: "+ cty.getEmail());
                tv_phoneCty.setText("Số điện thoại: "+ cty.getDienthoai());
                tv_urlcty.setText(cty.getUrlWebsite());
                tv_ctydescription.setText(Html.fromHtml(cty.getGioithieu()));

            }

            @Override
            public void onFailure(Call<Company> call, Throwable t) {
                Toast.makeText(mJopJobDetailActivity, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        tv_addCty = mView.findViewById(R.id.tv_addresscompany);
        tv_emailCty = mView.findViewById(R.id.tv_emailcompany);
        tv_phoneCty = mView.findViewById(R.id.tv_phonecompany);
        tv_urlcty = mView.findViewById(R.id.tv_urlwebsite);
        tv_ctydescription = mView.findViewById(R.id.tv_companydescription);
    }
}