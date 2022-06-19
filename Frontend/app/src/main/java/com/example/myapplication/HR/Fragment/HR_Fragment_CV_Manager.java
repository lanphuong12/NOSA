package com.example.myapplication.HR.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.AlliedJobAdapter;
import com.example.myapplication.HR.Adapter.JobnewAdapter;
import com.example.myapplication.HR.GetAllCVbyIdJob;
import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HR_Fragment_CV_Manager extends Fragment {

    ListView lv_cv;
    AlliedJobAdapter alliedJobAdapter;
    ArrayList<AppliedJob> mang_cv;

    HrHomeActivity hrHomeActivity;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.hr_fragment_cv_manager, container, false);
        hrHomeActivity = (HrHomeActivity) getActivity();
        int User = hrHomeActivity.getIdUser();
        initUI();

        getAllCVApplied(User);

        Toolbar TopActivityToolbar = mView.findViewById(R.id.toolbar);
        TopActivityToolbar.setTitle("Quản lý công việc");
        TopActivityToolbar.inflateMenu(R.menu.home4);

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
                    case R.id.reject:
                        getDataAppliedJobbyStatus(User, 0,"Reject");
                        break;
                    case R.id.consider:
                        getDataAppliedJobbyStatus(User, 3,"Consider");
                        break;
                    case R.id.waiting:
                        getDataAppliedJobbyStatus(User, 1,"Waiting");
                        break;
                    case R.id.approve:
                        getDataAppliedJobbyStatus(User, 2,"Approve");
                        break;
                    default:break;
                }
                return false;
            }
        });

        lv_cv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu p = new PopupMenu(getActivity(), view);
                MenuInflater inflater = p.getMenuInflater();
                inflater.inflate(R.menu.update_cv, p.getMenu());
                p.show();
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.reject:
                                SetStatusCVapplied(User,mang_cv.get(position).getIdNopcv(), 0);
                                break;
                            case R.id.consider:
                                SetStatusCVapplied(User, mang_cv.get(position).getIdNopcv(), 3);
                                break;
                            case R.id.approve:
                                SetStatusCVapplied(User, mang_cv.get(position).getIdNopcv(), 2);
                                break;
                            default:break;
                        }
                        return false;
                    }
                });
                return true;
            }
        });

        return mView;
    }

    private void getDataAppliedJobbyStatus(int user, int status, String trangthai) {
        mang_cv.clear();
        Dataservice dataservice = APIService.getService();
        Call<List<AppliedJob>> callback = dataservice.GetAllCVAppliedbyStatustoHRJob(user, status);
        callback.enqueue(new Callback<List<AppliedJob>>() {
            @Override
            public void onResponse(Call<List<AppliedJob>> call, Response<List<AppliedJob>> response) {
                ArrayList<AppliedJob> job = (ArrayList<AppliedJob>) response.body();
                //Log.d("api",response.toString());
                if (job.size() == 0){
                    Toast.makeText(hrHomeActivity, "Không có CV nào của bạn ở trạng thái " + trangthai +"! Vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                    getAllCVApplied(user);
                }
                else {
                    for (AppliedJob cv: job){
                        mang_cv.add(cv);
                    }
                    alliedJobAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<AppliedJob>> call, Throwable t) {
                Toast.makeText(getActivity(), "Lấy dữ liệu thất bại ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllCVApplied(int user) {
        Dataservice dataservice = APIService.getService();
        Call<List<AppliedJob>> callback = dataservice.GetAllCVAppliedtoHRJob(user);
        callback.enqueue(new Callback<List<AppliedJob>>() {
            @Override
            public void onResponse(Call<List<AppliedJob>> call, Response<List<AppliedJob>> response) {
                ArrayList<AppliedJob> cv = (ArrayList<AppliedJob>) response.body();
                for (AppliedJob civi: cv){
                    mang_cv.add(civi);
                }
                alliedJobAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AppliedJob>> call, Throwable t) {

            }
        });
    }

    private void SetStatusCVapplied(Integer user, Integer idNopcv, int status) {
        Dataservice dataservice = APIService.getService();
        Call<Void> callback = dataservice.UpdateStatusCV(idNopcv, status);
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (status == 0){
                    Toast.makeText(getActivity(), "Bạn đã loại CV này!", Toast.LENGTH_SHORT).show();
                }
                if (status == 2){
                    Toast.makeText(getActivity(), "Bạn đã chấp nhận CV này!", Toast.LENGTH_SHORT).show();
                }
                if (status == 3){
                    Toast.makeText(getActivity(), "Bạn cần xem xét lại CV này!", Toast.LENGTH_SHORT).show();
                }
                getAllCVApplied(user);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity(), "Update trạng thái CV thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUI() {
        lv_cv = mView.findViewById(R.id.lv_cvmanager);
        mang_cv = new ArrayList<>();
        alliedJobAdapter = new AlliedJobAdapter(mang_cv, getActivity());
        lv_cv.setAdapter(alliedJobAdapter);
    }
}