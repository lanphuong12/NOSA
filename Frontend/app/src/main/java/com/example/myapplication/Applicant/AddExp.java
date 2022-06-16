package com.example.myapplication.Applicant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.Model.ExpUser;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddExp extends AppCompatActivity {

    int idUser;
    EditText edt_nameExp, edt_desExp;
    Spinner sp_amountyearExp;
    Button bt_save, bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exp_user);
        GetIntentIduser();
        Anhxa();

    }

    private void Anhxa() {
        edt_nameExp =  findViewById(R.id.et_name);
        edt_desExp =  findViewById(R.id.edt_desExp);
        sp_amountyearExp =  findViewById(R.id.planets_spinner);
        bt_save =  findViewById(R.id.bt_save_exp_user);
        bt_cancel =  findViewById(R.id.bt_cancel);
        bt_cancel.setText("Skip");
    }

    private void GetIntentIduser() {
        idUser = 2;
    }

    public void Cancel(View view) {
        Intent intent2 = new Intent(AddExp.this, AddSkillUser.class);
        intent2.putExtra("idUserAcc", idUser);
        startActivity(intent2);
    }

    public void Save(View view) {
        String tenexp = edt_nameExp.getText().toString();
        String mota = edt_desExp.getText().toString();
        Integer sonam = 0;
        Dataservice dataservice = APIService.getService();
        Call<ExpUser> callback = dataservice.AddExpUser(idUser, tenexp, sonam, mota);
        callback.enqueue(new Callback<ExpUser>() {
            @Override
            public void onResponse(Call<ExpUser> call, Response<ExpUser> response) {
                Toast.makeText(AddExp.this, "Lưu kinh nghiệm thành công", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(AddExp.this);
                builder.setMessage("Bạn có muốn thêm 1 kinh nghiệm nữa")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent1 = new Intent(AddExp.this, AddExp.class);
                                intent1.putExtra("idUserAcc", idUser);
                                startActivity(intent1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent2 = new Intent(AddExp.this, AddSkillUser.class);
                                intent2.putExtra("idUserAcc", idUser);
                                startActivity(intent2);
                            }
                        });
                builder.create();
            }

            @Override
            public void onFailure(Call<ExpUser> call, Throwable t) {
                Toast.makeText(AddExp.this, "Lưu kinh nghiệm người dùng thất bại! Xin mời thử lại sau", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
