package com.example.myapplication.Server;

import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Company;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.ExpUser;
import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.JobDetail;
import com.example.myapplication.Model.Jobnew;
import com.example.myapplication.Model.Kynang;
import com.example.myapplication.Model.Loaikynang;
import com.example.myapplication.Model.LoginResponse;
import com.example.myapplication.Model.Nganhnghe;
import com.example.myapplication.Model.SkillJob;
import com.example.myapplication.Model.SkillUser;
import com.example.myapplication.Model.Trinhdohocvan;
import com.example.myapplication.Model.UserAcc;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Dataservice {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> Login(@Field("dienthoai") String phone,
                              @Field("matkhau") String pass);

    @FormUrlEncoded
    @POST("checkPhone")
    Call<String> CheckPhone(@Field("dienthoai") String Dienthoai);

    @FormUrlEncoded
    @POST("changePassword")
    Call<UserAcc> ChangePass(@Field("id_user") Integer idUser, @Field("matkhau") String pass);

    @FormUrlEncoded
    @POST("createUser")
    Call<UserAcc> CreateAcc(@Field("dienthoai") String phones, @Field("matkhau") String pass, @Field("role") Integer role);

    @GET("applicant/GetDataTrinhdohocvan")
    Call<List<Trinhdohocvan>> GetDataTrinhdohocvan();

    @FormUrlEncoded
    @PUT("UpdateUserAcc")
    Call<UserAcc> UpdateAcc(@Field("id_user") Integer idUser,
                                  @Field("hoten") String ten,
                                  @Field("email") String email,
                                  @Field("gioitinh") String gender,
                                  @Field("ngaysinh") String birth,
                                  @Field("diachi") String address,
                                  @Field("id_trinhdo") Integer idTrinhdo,
                                  @Field("anh") String img);

    @GET("applicant/GetDataLoaiSkill")
    Call<List<Loaikynang>> GetDataLoaiSkill();

    @FormUrlEncoded
    @POST("applicant/GetDataSkillByIdLoaiSkill")
    Call<List<Kynang>> GetDataSkillByLoaiSkill(@Field("id_danhmucnganh") Integer idDanhmucnganh);

    @FormUrlEncoded
    @POST("applicant/AddSkill")
    Call<SkillUser> AddSkillUser(@Field("id_user") Integer idUser,
                                 @Field("id_skill") Integer idSkill,
                                 @Field("mota") String mota);

    @FormUrlEncoded
    @POST("applicant/AddExperience")
    Call<ExpUser> AddExpUser(@Field("id_user") Integer idU,
                             @Field("name_experience") String nameExp,
                             @Field("amount_years") Integer years,
                             @Field("mota") String des);

    @GET("applicant/getalldanhmucnganhnghe")
    Call<List<Danhmucnganhnghe>> GetAllDanhmucnganhnghe();

    @FormUrlEncoded
    @POST("applicant/GetAllnganhngheByIdDMNN")
    Call<List<Nganhnghe>> GetAllNganhngheByIDdanhmuc(@Field("id_danhmucnganh") Integer idDanhmucnganh);

    @FormUrlEncoded
    @POST("applicant/AddNganhnghequantam")
    Call<Void> SaveAllNganhngheQuantam(@Field("id_user") Integer id_User,
                                       @Field("id_nganhngheid_nganhnghe") Integer id_nn);


    @FormUrlEncoded
    @POST("applicant/GetJobtoApplicant")
    Call<List<Job>> GetJobToApplicant(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("applicant/GetSavedJob")
    Call<List<Job>> GetSavedJob(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("applicant/GetAppliedJob")
    Call<List<AppliedJob>> GetAppliedJob(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("applicant/GetUserById")
    Call<UserAcc> GetDataUserByIdUser(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("applicant/GetDanhmucnganhNgheByIdUser")
    Call<List<Danhmucnganhnghe>> GetDataDMNNByIdUser(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("applicant/GetNganhNgheByIdUserIddmnn")
    Call<List<Nganhnghe>> GetDataNNByIdUserIdDMNN(@Field("id_user") Integer idUser,
                                            @Field("id_danhmucnganh") Integer idDMNN);

    @FormUrlEncoded
    @POST("job/GetSkillJobbyIdJob")
    Call<List<SkillJob>> GetSkillJobbyIdJob(@Field("id_congviec") Integer idJob);

    @FormUrlEncoded
    @POST("job/GetJobbyIdSkill")
    Call<List<Job>> GetJobbyIdSkill(@Field("id_skill") Integer idSkill);

    @FormUrlEncoded
    @POST("job/GetJobByIdJob")
    Call<JobDetail> GetJobByIdJob(@Field("id_congviec") Integer idJob);

    @FormUrlEncoded
    @POST("company/GetCompanybyIdJob")
    Call<Company> GetCompanybyIdJob(@Field("id_congviec") Integer idJob);

    @FormUrlEncoded
    @POST("applicant/SaveJob")
    Call<Void> SaveJob(@Field("id_user") Integer idUser,
                       @Field("id_congviec") Integer idJob);

    @FormUrlEncoded
    @POST("applicant/ApplyJob")
    Call<Void> ApplyCVtoJob(@Field("id_user") Integer idUser,
                            @Field("id_congviec") Integer idJob,
                            @Field("CV") String cv,
                            @Field("ngaynop") String ngaynop);

    @FormUrlEncoded
    @POST("hr/GetApplicant")
    Call<List<UserAcc>> GetApplicant(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("hr/GetJobCreated")
    Call<List<Job>> GetAllJobCreatedbyidHR(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("hr/GetCompanyCreated")
    Call<List<Company>> GetAllCompanyCreatedbyidHR(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("hr/GetAllCVApplied")
    Call<List<AppliedJob>> GetAllCVAppliedtoHRJob(@Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("hr/UpdateStatusCV")
    Call<Void> UpdateStatusCV(@Field("id_nopcv") Integer idCV,
                              @Field("trangthai") Integer status);

    @FormUrlEncoded
    @POST("hr/GetAllCVAppliedByIdJob")
    Call<List<AppliedJob>> GetCVByIdJob(@Field("id_congviec") Integer id_cviec);

    @FormUrlEncoded
    @POST("hr/GetCVbyStatus")
    Call<List<AppliedJob>> GetAllCVAppliedbyStatustoHRJob(@Field("trangthai") Integer status,
                                                          @Field("id_user") Integer idUser);

    @FormUrlEncoded
    @POST("hr/GetAllCVAppliedByIdJob")
    Call<List<Jobnew>> GetJobByIdCty(@Field("id_congty") Integer cty);
}
