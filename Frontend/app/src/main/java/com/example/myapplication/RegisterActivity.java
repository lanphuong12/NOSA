package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    RadioButton roleA, roleHR, roleBoth;
    EditText ed_Phone, ed_Pass;
    Button bt_cancel, bt_register;
    int roleUserAcc;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Anhxa();
    }

    private void Anhxa() {
        roleA = findViewById(R.id.role_applicant);
        roleHR = findViewById(R.id.role_hr);
        roleBoth = findViewById(R.id.role_both);
        ed_Phone = findViewById(R.id.edt_phone);
        ed_Pass = findViewById(R.id.edt_Pass);
        bt_cancel = findViewById(R.id.bt_cancel);
        bt_register = findViewById(R.id.bt_createNewAcc);
    }

    public void Cancel(View view) {
        Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent1);
    }

    private boolean checkPhone(String phone){
        Dataservice dataservice = APIService.getService();
        Call<String> callback = dataservice.CheckPhone(phone);
        callback.enqueue(new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String sdt = response.body();
                if (sdt.length() != 0){
                    check = true;
                }
                else {
                    check = false;
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return check;
    }

    public void Register(View view) {
        String phone = ed_Phone.getText().toString();
        String pass =  ed_Pass.getText().toString();
        if (checkPhone(phone)){
            Toast.makeText(this, "Số điện thoại đã được đăng ký! ", Toast.LENGTH_SHORT).show();
        }
        else {
            Dataservice dataservice = APIService.getService();
            Call<String> callback = dataservice.CheckPhone(phone);
        }
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.role_applicant:
                if (checked)
                    roleUserAcc = 1;
                break;
            case R.id.role_hr:
                if (checked)
                    roleUserAcc = 2;
                break;
            case R.id.role_both:
                if (checked)
                    roleUserAcc = 0;
                break;
        }
    }
}