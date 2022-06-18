package com.example.myapplication.HR.Fragment;

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

import com.example.myapplication.Applicant.JobDetailActivity;
import com.example.myapplication.HR.Adapter.CandidateAdapter;
import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HR_Fragment_main extends Fragment {

    AutoCompleteTextView autoCompleteTextView;
    ImageButton bt_search;
    ListView lv_candidate;
    CandidateAdapter candidateAdapter;
    ArrayList<UserAcc> mang_candidate;

    HrHomeActivity hrHomeActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.hr_fragment_main, container, false);
        hrHomeActivity = (HrHomeActivity) getActivity();
        int User = hrHomeActivity.getIdUser();
        initUI();
        getDataCandidate(User);

        lv_candidate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), JobDetailActivity.class);
                intent.putExtra("idUserAcc", User);
                intent.putExtra("id_candidate", mang_candidate.get(position));
                startActivity(intent);
            }
        });
        return mView;
    }

    private void initUI() {
        autoCompleteTextView = mView.findViewById(R.id.edt_search_word);
        bt_search = mView.findViewById(R.id.imgbt_search);
        lv_candidate = mView.findViewById(R.id.lv_candidate);
        mang_candidate = new ArrayList<>();
        candidateAdapter = new CandidateAdapter(mang_candidate, getActivity());
        lv_candidate.setAdapter(candidateAdapter);
    }

    private void getDataCandidate(int user) {
        Dataservice dataservice = APIService.getService();
        Call<List<UserAcc>> callback = dataservice.GetApplicant(user);
        callback.enqueue(new Callback<List<UserAcc>>() {
            @Override
            public void onResponse(Call<List<UserAcc>> call, Response<List<UserAcc>> response) {
                ArrayList<UserAcc> user = (ArrayList<UserAcc>) response.body();
                //Log.d("api",response.toString());
                for (UserAcc acc: user){
                    mang_candidate.add(acc);
                }
                candidateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UserAcc>> call, Throwable t) {
                Toast.makeText(hrHomeActivity, "Lấy dữ liệu thấy bại!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}