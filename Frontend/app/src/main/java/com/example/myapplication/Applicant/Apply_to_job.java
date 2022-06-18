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
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.UserAcc;
import com.example.myapplication.R;
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
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Apply_to_job extends AppCompatActivity {

    ImageView img_logocompany, img_CV;
    TextView tv_namecompany, tv_namejob, tv_address, tv_salary, tv_typejob, tv_amount;
    Button bt_uploadCV, bt_applyJob;
    EditText edt_name, edt_email, edt_phone;

    Job congviec;
    int IdUser;

    private static final int PICK_FILE = 1;
    Uri UriImage;
    String miUrlOk;
    private StorageTask uploadTask;
    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicant_apply_to_job);

        GetDataIntent();
        Anhxa();

        storageRef = FirebaseStorage.getInstance().getReference("CV");

        Picasso.get().load(congviec.getLogo())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.errorimg)
                .into(img_logocompany);

        tv_namecompany.setText(congviec.getTencty());
        tv_namejob.setText(congviec.getTenjob());
        tv_address.setText(congviec.getDiachicty());
        tv_salary.setText(congviec.getMinsalary() + "đ -" + congviec.getMaxsalary() + "đ");
        tv_typejob.setText(congviec.getTenloaihinhcv());
        tv_amount.setText(congviec.getSoluongtuyendung().toString());

        GetDataUserByIdUer(IdUser);

    }

    private void GetDataUserByIdUer(int idUser) {
        Dataservice dataservice = APIService.getService();
        Call<UserAcc> callback = dataservice.GetDataUserByIdUser(IdUser);
        callback.enqueue(new Callback<UserAcc>() {
            @Override
            public void onResponse(Call<UserAcc> call, Response<UserAcc> response) {
                UserAcc userAcc = response.body();

                edt_name.setText(userAcc.getHoten());
                edt_email.setText(userAcc.getEmail());
                edt_phone.setText(userAcc.getDienthoai());
            }

            @Override
            public void onFailure(Call<UserAcc> call, Throwable t) {
                Toast.makeText(Apply_to_job.this, "Lấy dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetDataIntent() {
        IdUser = (int) getIntent().getSerializableExtra("idUserAcc");
        congviec = (Job) getIntent().getSerializableExtra("id_job");
    }

    private void Anhxa() {
        img_logocompany = findViewById(R.id.imgv_logocty);
        img_CV = findViewById(R.id.img_cvtoapply);
        tv_namecompany = findViewById(R.id.tv_namecompany);
        tv_namejob = findViewById(R.id.tv_namejob);
        tv_address = findViewById(R.id.tv_addresscompany);
        tv_salary = findViewById(R.id.tv_salary);
        tv_typejob = findViewById(R.id.tv_typeJob);
        tv_amount = findViewById(R.id.tv_amount);
        bt_uploadCV = findViewById(R.id.bt_uploadCV);
        bt_applyJob = findViewById(R.id.bt_applyJob);
        edt_name = findViewById(R.id.edt_fullname);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);


    }


    public void ApplyCVtoJob(View view){
        uploadCV();
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = formatter.format(todayDate);

        Dataservice dataservice = APIService.getService();
        Call<Void> callback = dataservice.ApplyCVtoJob(IdUser, congviec.getIdCongviec(), miUrlOk, todayString);
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(Apply_to_job.this, "Nộp CV thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Apply_to_job.this, ApplicantHomeActivity.class);
                intent.putExtra("idUserAcc", IdUser);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Apply_to_job.this, "Nộp CV thất bại! Vui lòng thử lại!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void UploadCV(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/* video/* application/pdf");
        startActivityForResult(intent, PICK_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE || resultCode == RESULT_OK || data != null || data.getData() != null) {
            UriImage = data.getData();
            img_CV.setImageURI(UriImage);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    void uploadCV() {
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

                        Toast.makeText(Apply_to_job.this, "LINK" + miUrlOk, Toast.LENGTH_SHORT).show();

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
}