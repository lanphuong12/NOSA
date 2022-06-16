package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Applicant.ApplicantHomeActivity;
import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.ResertPass.ResertpassEnterphoneActivity;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText ed_phone, ed_pass;
    Button bt_forgotpass, bt_register, bt_login;
    UserAcc user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Anhxa();

    }

    private void Anhxa() {
        ed_phone = findViewById(R.id.ed_user);
        ed_pass = findViewById(R.id.ed_pass);
        bt_forgotpass = findViewById(R.id.bt_forgotpass);
        bt_register = findViewById(R.id.bt_create);
        bt_login = findViewById(R.id.bt_login);
        user = new UserAcc();
    }

    public void Login(String phone, String pass){
        Dataservice dataservice = APIService.getService();
        Call<UserAcc> callback = dataservice.Login(phone, pass);
        callback.enqueue(new Callback<UserAcc>() {
            @Override
            public void onResponse(Call<UserAcc> call, Response<UserAcc> response) {
                user = (UserAcc) response.body();
                if(user == null){
                    Toast.makeText(LoginActivity.this, "Phone and Pass wrong!! Please try again", Toast.LENGTH_LONG).show();
                }
                else {
                    int role = Integer.parseInt(user.getRole().toString());
                    if (role== 1){ // 1 is HR
                        Intent intent1 = new Intent(LoginActivity.this, HrHomeActivity.class);
                        intent1.putExtra("idUserAcc", user.getIdUser());
                        startActivity(intent1);
                    }
                    if (role == 2){ // 2 is Applicant
                        Intent intent2 = new Intent(LoginActivity.this, ApplicantHomeActivity.class);
                        intent2.putExtra("idUserAcc", user.getIdUser());
                        startActivity(intent2);
                    }
                }
            }

            @Override
            public void onFailure(Call<UserAcc> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Log_in(View view) {
        String phone = ed_phone.getText().toString().trim();
        String pass = ed_pass.getText().toString().trim();
        Login(phone, pass);
    }

    public void Create_new(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void ForgotPass(View view) {
        Intent intent = new Intent(LoginActivity.this, ResertpassEnterphoneActivity.class);
        startActivity(intent);
    }
}