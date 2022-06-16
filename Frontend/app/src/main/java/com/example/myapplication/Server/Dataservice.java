package com.example.myapplication.Server;

import com.example.myapplication.Model.AppliedJob;
import com.example.myapplication.Model.Danhmucnganhnghe;
import com.example.myapplication.Model.ExpUser;
import com.example.myapplication.Model.Job;
import com.example.myapplication.Model.Kynang;
import com.example.myapplication.Model.Loaikynang;
import com.example.myapplication.Model.Nganhnghe;
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
    Call<UserAcc> Login(@Field("dienthoai") String phone,
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
//
//    @GET("Classes")
//    Call<List<Class>> GetDataClass();
//
//    @POST("students/searchHV/{word}")
//    Call<List<Student>> SearchHV(String word);
//
//    @DELETE("vocabularies/deletevocab/{Id_vocab}")
//    Call<Void> DeleteVocab(@Path("Id_vocab") int id_vocab);
//
//    @PUT("vocabularies/update/{Id_vocab}")
//    Call<Void> UpdateVocab(@Path("Id_vocab") int id_vocab, @Body Vocab tumoi);
//
//    @PUT("students/Update/{Id_HV}")
//    Call<Void> UpdateHV(@Path("Id_HV") int id, @Body Student hocvien);
//
//    @GET("students/getbyidclass/{Id_class}")
//    Call<List<Student>> GetStudent(@Path("Id_class") int id_class);
//
//    @GET("students/getbyemail/{Email}")
//    Call<Student> GetStudentEmail(@Path("Email") String email);
//
//    @GET("students/getbyidHV/{Id_HV}")
//    Call<List<Student>> GetStudentID(@Path("Id_HV") int id_HV);
//
//    @GET("vocabularies/getbyid/{Id_theme}")
//    Call<List<Vocab>> GetVocabulary(@Path("Id_theme") int id_theme);
//
//    @GET("themes/getbyid/{Id_book}")
//    Call<List<Theme>> GetTheme_book(@Path("Id_book") int id_book);
//
//    @FormUrlEncoded
//    @POST("themes/AddTheme")
//    Call<Book> addBook(@Field("Name_book") String name_theme, @Field("Image_book") String id_lession);
//
//    @FormUrlEncoded
//    @POST("vocabularies/AddVocab")
//    Call<Vocab> addVocab(@Field("Id_theme") int id_theme ,@Field("Word") String word, @Field("Meaning") String meaning);
//
//    @FormUrlEncoded
//    @POST("themes/AddTheme")
//    Call<Theme> addTheme(@Field("Id_book") int id_book ,@Field("Name_theme") String name_theme, @Field("Id_lession") String id_lession);
//
//    @FormUrlEncoded
//    @POST("Students/AddStudent")
//    Call<Student> addHV(@Field("Name_HV") String nameHV, @Field("Id_class") int id_class,
//                        @Field("Tuition") int hocphi, @Field("Name_PH") String namePH,
//                        @Field("Phone_PH") String phone, @Field("Email") String email,
//                        @Field("Address_HV") String address, @Field("Date_of_birth") Date ngay);
//
//    @FormUrlEncoded
//    @POST("Taikhoans/AddTaikhoan")
//    Call<User> addTK(@Field("Email") String email, @Field("Type_persional") String type);
}
