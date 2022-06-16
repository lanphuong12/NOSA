package com.example.myapplication.Applicant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.HR.HrHomeActivity;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
import com.example.myapplication.RegisterActivity;
import com.example.myapplication.Server.APIService;
import com.example.myapplication.Server.Dataservice;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class UpdateInfoPersionalActivity extends AppCompatActivity {
    ImageView imv_avatar;
    private static final int PICK_FILE = 1;
    Uri UriImage;
    Button bt_save, bt_cancel;
    String miUrlOk, gender;
    EditText edt_name, edt_email, edt_birth, edt_address;
    Spinner sp_trinhdo;
    int check, role, idUser;
    RadioButton boy, girl;
    private StorageTask uploadTask;
    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_info_persional);
        GetDataIntentCheck();
        Anhxa();
        storageRef = FirebaseStorage.getInstance().getReference("avatar");

        imv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                it.setType("image/* video/*");
                startActivityForResult(it, PICK_FILE);
            }
        });

    }

    private void GetDataIntentCheck() {
        // nếu check =1 thì sẽ hiển thị nút cancel - check != 1 thì sẽ hiển thị nút cancel
        check = 1;
        idUser = 1;
    }

    private void Anhxa() {
        imv_avatar = findViewById(R.id.imv_avatar);
        bt_save = findViewById(R.id.bt_cancel);
        bt_cancel = findViewById(R.id.bt_cancel);
        if (check != 1){
            bt_cancel.setVisibility(View.INVISIBLE);
        }

        edt_name = findViewById(R.id.et_name);
        edt_email = findViewById(R.id.edt_email);
        boy = findViewById(R.id.rb_boy);
        girl = findViewById(R.id.rb_girl);
        edt_birth = findViewById(R.id.ed_date_of_b);
        edt_address = findViewById(R.id.et_address);
        sp_trinhdo = findViewById(R.id.planets_spinner);
    }

    public void Cancel(View view) {
        if (role == 1){
            Intent intent1 = new Intent(UpdateInfoPersionalActivity.this, ApplicantHomeActivity.class);
            intent1.putExtra("idUserAcc", idUser);
            startActivity(intent1);
        }
        if (role == 2){
            Intent intent2 = new Intent(UpdateInfoPersionalActivity.this, HrHomeActivity.class);
            intent2.putExtra("idUserAcc", idUser);
            startActivity(intent2);
        }
    }

    public void Save(View view) {
        uploadimage();
        String ten = edt_name.getText().toString();
        String email = edt_email.getText().toString();
        String birth = edt_birth.getText().toString() ;
        String address = edt_address.getText().toString();
        Integer idTrinhdo = 0;
        Dataservice dataservice = APIService.getService();
        Call<UserAcc> callback = dataservice.UpdateAcc(idUser, ten, email, gender, birth, address, idTrinhdo, miUrlOk);
        callback.enqueue(new Callback<UserAcc>() {
            @Override
            public void onResponse(Call<UserAcc> call, Response<UserAcc> response) {
                Toast.makeText(UpdateInfoPersionalActivity.this, "Update thông tin thành công!", Toast.LENGTH_SHORT).show();
                    if (role == 1){
                        Intent intent1 = new Intent(UpdateInfoPersionalActivity.this, ChooseDanhmucnganhngheActivity.class);
                        intent1.putExtra("idUserAcc", idUser);
                        startActivity(intent1);
                    }
                    if (role == 2){
                        Intent intent2 = new Intent(UpdateInfoPersionalActivity.this, HrHomeActivity.class);
                        intent2.putExtra("idUserAcc", idUser);
                        startActivity(intent2);
                    }
            }

            @Override
            public void onFailure(Call<UserAcc> call, Throwable t) {
                Toast.makeText(UpdateInfoPersionalActivity.this, "Update thông tin thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void uploadimage() {
        if (UriImage != null) {
            final StorageReference fileReference = storageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(UriImage));

            uploadTask = fileReference.putFile(UriImage);


            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        miUrlOk = downloadUri.toString();

                        Toast.makeText(UpdateInfoPersionalActivity.this, "LINK" + miUrlOk, Toast.LENGTH_SHORT).show();

                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        } else {

        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE || resultCode == RESULT_OK || data != null || data.getData() != null) {
            UriImage = data.getData();
            imv_avatar.setImageURI(UriImage);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_boy:
                if (checked)
                    gender = "nam";
                break;
            case R.id.rb_girl:
                if (checked)
                    gender = "nữ";
                break;
        }
    }
}