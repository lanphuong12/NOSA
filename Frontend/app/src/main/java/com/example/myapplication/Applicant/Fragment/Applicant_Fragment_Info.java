package com.example.myapplication.Applicant.Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.DanhmucnganhngheAdapter;
import com.example.myapplication.Applicant.Adapter.NganhngheQuantamAdapter;
import com.example.myapplication.Applicant.ApplicantHomeActivity;
import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Applicant_Fragment_Info extends Fragment implements NganhngheQuantamAdapter.OnDMNNListener {

    private View mView;
    ApplicantHomeActivity mAppHomActivity;

    int Idser;
    UserAcc userAcc = new UserAcc();
    ImageView img_avatar;
    TextView tv_name, tv_age, tv_gender, tv_add, tv_email, tv_phone;
    Button bt_updateInfo, bt_detailInfo, bt_expU, bt_skillU;
    RecyclerView rcv_nganhngheqt;

    private ArrayList<Danhmucnganhnghe> listDMNNQT;
    NganhngheQuantamAdapter nganhngheQuantamAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.applicant_fragment_info, container, false);
        Anhxa();
        Idser = mAppHomActivity.getIdUser();
        GetDataUse(Idser);
        GetDataDMNNByIdUser(Idser);
        return mView;
    }

    private void GetDataDMNNByIdUser(int IdUser) {
        Dataservice dataservice = APIService.getService();
        Call<List<Danhmucnganhnghe>> callback = dataservice.GetDataDMNNByIdUser(IdUser);
        callback.enqueue(new Callback<List<Danhmucnganhnghe>>() {
            @Override
            public void onResponse(Call<List<Danhmucnganhnghe>> call, Response<List<Danhmucnganhnghe>> response) {
                ArrayList<Danhmucnganhnghe> dmn = (ArrayList<Danhmucnganhnghe>) response.body();
                //Log.d("api",response.toString());
                for (Danhmucnganhnghe dm: dmn){
                    listDMNNQT.add(dm);
                }
                nganhngheQuantamAdapter.setData(listDMNNQT);
                rcv_nganhngheqt.setAdapter(nganhngheQuantamAdapter);
            }

            @Override
            public void onFailure(Call<List<Danhmucnganhnghe>> call, Throwable t) {

            }
        });
    }

    private void GetDataUse(int IdUser) {
        Dataservice dataservice = APIService.getService();
        Call<UserAcc> callback = dataservice.GetDataUserByIdUser(IdUser);
        callback.enqueue(new Callback<UserAcc>() {
            @Override
            public void onResponse(Call<UserAcc> call, Response<UserAcc> response) {
                userAcc = response.body();
                Picasso.get().load(userAcc.getAnh())
                        .placeholder(R.drawable.noimg)
                        .error(R.drawable.errorimg)
                        .into(img_avatar);
                tv_name.setText(userAcc.getHoten());
                tv_age.setText(userAcc.getTuoi());
                tv_gender.setText(userAcc.getGioitinh());
                tv_add.setText(userAcc.getDiachi());
                tv_email.setText(userAcc.getEmail());
                tv_phone.setText(userAcc.getDienthoai());
            }

            @Override
            public void onFailure(Call<UserAcc> call, Throwable t) {
                Toast.makeText(getActivity(), "Lấy dữ liệu thất bại ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        img_avatar = mView.findViewById(R.id.img_avatarU);
        tv_name = mView.findViewById(R.id.tv_nameU);
        tv_age = mView.findViewById(R.id.tv_age);
        tv_gender = mView.findViewById(R.id.tv_gender);
        tv_add = mView.findViewById(R.id.tv_address);
        tv_email = mView.findViewById(R.id.tv_email);
        tv_phone = mView.findViewById(R.id.tv_phonenumber);
        bt_updateInfo = mView.findViewById(R.id.bt_updateIn4);
        bt_detailInfo = mView.findViewById(R.id.bt_see_detailin4);
        bt_expU = mView.findViewById(R.id.bt_experiences);
        bt_skillU = mView.findViewById(R.id.bt_skills);
        rcv_nganhngheqt = mView.findViewById(R.id.lv_nganhnghequantam);

        listDMNNQT = new ArrayList<>();

    }

    @Override
    public void OnDMNNClick(int position) {
        Danhmucnganhnghe dmnn = listDMNNQT.get(position);
        Dialog dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.list);

        ArrayList nganhnghes = new ArrayList();
        nganhnghes = GetDataNNQTByIdUIdDMNN(Idser, dmnn.getIdDanhmucnganh());

        ArrayAdapter dsnn = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, nganhnghes);

        ListView lvDemo = dialog.findViewById(R.id.list_view_NNQT);
        lvDemo.setAdapter(dsnn);

        dialog.show();
    }

    private ArrayList<String> GetDataNNQTByIdUIdDMNN(int idser, Integer idDanhmucnganh) {
        ArrayList arr = new ArrayList();
        Dataservice dataservice = APIService.getService();
        Call<List<Nganhnghe>> callback = dataservice.GetDataNNByIdUserIdDMNN(idser, idDanhmucnganh);
        callback.enqueue(new Callback<List<Nganhnghe>>() {
            @Override
            public void onResponse(Call<List<Nganhnghe>> call, Response<List<Nganhnghe>> response) {
                ArrayList<Nganhnghe> nn = (ArrayList<Nganhnghe>) response.body();
                //Log.d("api",response.toString());
                for (Nganhnghe nganhnghe: nn){
                    arr.add(nganhnghe.getTennganh());
                }
            }

            @Override
            public void onFailure(Call<List<Nganhnghe>> call, Throwable t) {
                Toast.makeText(getActivity(), "Lấy dữ liệu thất bại ", Toast.LENGTH_SHORT).show();
            }
        });
        return arr;
    }

    public void ExpUser(View view) {

    }

    public void SkillUser(View view) {
    }
}