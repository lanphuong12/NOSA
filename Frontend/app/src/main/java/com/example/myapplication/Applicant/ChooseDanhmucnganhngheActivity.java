package com.example.myapplication.Applicant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Applicant.Adapter.DanhmucnganhngheAdapter;
import com.example.myapplication.Applicant.Adapter.NganhngheAdapter;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseDanhmucnganhngheActivity extends AppCompatActivity {

    ArrayList<Danhmucnganhnghe> mang_danhmucnn;
    DanhmucnganhngheAdapter danhmucnn_adapter;
    ListView lv_dmnn;
    ArrayList<Integer> arrIdnganhnghe;
    Button btSaveDMNN, btcancel;
    int id_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_danhmucnganhnghe);

        Anhxa();
        GetDataDanhmucNN();
        lv_dmnn.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idDM = mang_danhmucnn.get(position).getIdDanhmucnganh();
                ArrayList<Nganhnghe> mang_nganhnghe = new ArrayList<>();
                //GetDataDanhsachNNByIDdanhmuc(idDM, mang_nganhnghe);
                DialogChooseNganhnghe(idDM);

            }
        });
    }
    private void DialogChooseNganhnghe(int idDM){
        Dialog dialog = new Dialog(ChooseDanhmucnganhngheActivity.this);
        dialog.setContentView(R.layout.choose_nganhnghe);
        dialog.show();

        ListView lv_nganhnghe = (ListView) dialog.findViewById(R.id.list_view_with_checkbox);
        Button btSAVE = (Button) dialog.findViewById(R.id.bt_savengangnghe);
        Button btCANCEL = (Button) dialog.findViewById(R.id.bt_cancelngangnghe);
        ArrayList<Nganhnghe> list_nn = GetDataDanhsachNNByIDdanhmuc(idDM);
        lv_nganhnghe.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        NganhngheAdapter nganhngheAdapter = new NganhngheAdapter(getApplicationContext(), list_nn);
        nganhngheAdapter.notifyDataSetChanged();

        lv_nganhnghe.setAdapter(nganhngheAdapter);

        lv_nganhnghe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object itemObject = parent.getAdapter().getItem(position);
                Nganhnghe nn = (Nganhnghe) itemObject;
                CheckBox itemCheckbox = (CheckBox) view.findViewById(R.id.list_view_item_checkbox);
                if(nn.isChecked())
                {
                    itemCheckbox.setChecked(false);
                    nn.setChecked(false);
                }else
                {
                    itemCheckbox.setChecked(true);
                    nn.setChecked(true);
                }
            }
        });

        btSAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printSelectedItems(lv_nganhnghe);
                dialog.dismiss();
            }
        });

        btCANCEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
    }

    // When user click "Print Selected Items".
    public void printSelectedItems(ListView lv)  {

        SparseBooleanArray sp = lv.getCheckedItemPositions();

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                Nganhnghe nn= (Nganhnghe) lv.getItemAtPosition(i);
                int s= nn.getIdNganh();
                arrIdnganhnghe.add(s);
            }
        }
        Toast.makeText(this, "Selected items are: "+sb.toString(), Toast.LENGTH_LONG).show();
    }

    private void GetDataDanhmucNN() {
        Dataservice dataservice = APIService.getService();
        Call<List<Danhmucnganhnghe>> callback = dataservice.GetAllDanhmucnganhnghe();
        callback.enqueue(new Callback<List<Danhmucnganhnghe>>() {

            @Override
            public void onResponse(Call<List<Danhmucnganhnghe>> call, Response<List<Danhmucnganhnghe>> response) {
                ArrayList<Danhmucnganhnghe> dmn = (ArrayList<Danhmucnganhnghe>) response.body();
                //Log.d("api",response.toString());
                for (Danhmucnganhnghe dm: dmn){
                    mang_danhmucnn.add(dm);
                }
                danhmucnn_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Danhmucnganhnghe>> call, Throwable t) {

                Toast.makeText(ChooseDanhmucnganhngheActivity.this, "L???y d??? li???u th???t b???i ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetDataDanhsachNNByIDdanhmuc(int idDM, ArrayList<Nganhnghe> arr) {
        Dataservice dataservice = APIService.getService();
        Call<List<Nganhnghe>> callback = dataservice.GetAllNganhngheByIDdanhmuc(idDM);
        callback.enqueue(new Callback<List<Nganhnghe>>() {

            @Override
            public void onResponse(Call<List<Nganhnghe>> call, Response<List<Nganhnghe>> response) {
                ArrayList<Nganhnghe> dsnn = (ArrayList<Nganhnghe>) response.body();
                System.out.println("s??? l?????ng ng??nh ngh??? " + dsnn.size());
                //Log.d("api",response.toString());
                for (Nganhnghe nn: dsnn){
                    arr.add(nn);
                }
            }

            @Override
            public void onFailure(Call<List<Nganhnghe>> call, Throwable t) {

                Toast.makeText(ChooseDanhmucnganhngheActivity.this, "L???y d??? li???u th???t b???i ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<Nganhnghe> GetDataDanhsachNNByIDdanhmuc(int idDM) {
        ArrayList<Nganhnghe> nganhngheArrayList = new ArrayList<>();
        Dataservice dataservice = APIService.getService();
        Call<List<Nganhnghe>> callback = dataservice.GetAllNganhngheByIDdanhmuc(idDM);
        callback.enqueue(new Callback<List<Nganhnghe>>() {

            @Override
            public void onResponse(Call<List<Nganhnghe>> call, Response<List<Nganhnghe>> response) {
                ArrayList<Nganhnghe> dsnn = (ArrayList<Nganhnghe>) response.body();
                System.out.println("s??? l?????ng ng??nh ngh??? " + dsnn.size());
                //Log.d("api",response.toString());
                for (Nganhnghe nn: dsnn){
                    for (int j =0; j< arrIdnganhnghe.size(); j++){
                        if (arrIdnganhnghe.get(j) == nn.getIdNganh()){
                            nn.setChecked(true);
                            break;
                        }
                        else {
                            nn.setChecked(false);
                        }
                    }
                    nganhngheArrayList.add(nn);
                }
            }

            @Override
            public void onFailure(Call<List<Nganhnghe>> call, Throwable t) {

                Toast.makeText(ChooseDanhmucnganhngheActivity.this, "L???y d??? li???u th???t b???i ", Toast.LENGTH_SHORT).show();
            }
        });

        return nganhngheArrayList;
    }

    private void Anhxa() {

        lv_dmnn = findViewById(R.id.lv_danhmucnganhnghe);
        mang_danhmucnn = new ArrayList<>();
        danhmucnn_adapter = new DanhmucnganhngheAdapter(mang_danhmucnn,ChooseDanhmucnganhngheActivity.this);
        lv_dmnn.setAdapter(danhmucnn_adapter);
        arrIdnganhnghe = new ArrayList<>();;
        btSaveDMNN = findViewById(R.id.bt_savengangnghe);
        btcancel = findViewById(R.id.cancel_button);
        btcancel.setVisibility(View.INVISIBLE);
    }

    public void SaveNNquantam(View view) {
        if (arrIdnganhnghe.size() < 3){
            Toast.makeText(this, "Please choose atless 3 careers", Toast.LENGTH_SHORT).show();
        }
        else{
            // th???c hi???n l??u l???i danh s??ch ng??nh ngh??? quan t??m theo IDUser
            SaveNNquantamByIdUser(id_User);
            Intent intent = new Intent(ChooseDanhmucnganhngheActivity.this, AddExp.class);
            intent.putExtra("id_user", id_User);
            startActivity(intent);
        }
    }

    private void SaveNNquantamByIdUser(int IdU) {
        for (int i =0; i<= arrIdnganhnghe.size(); i++){
            Dataservice dataservice = APIService.getService();
            Call<Void> callback = dataservice.SaveAllNganhngheQuantam(IdU, arrIdnganhnghe.get(i));
            callback.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(ChooseDanhmucnganhngheActivity.this, "Th??m ng??nh ngh??? quan t??m th???t b???i! vui l??ng th??? l???i", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}