const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/

const GetUserById = async (req, res) => {
    const UserAcc = await dao.sequelize.query("exec GetUserById @idUser= '" + req.body.id_user +  "'", { raw: true, nest: true })

        return res.status(200).send(UserAcc)
}

const GetAllDanhmucnganhnghe = async (req, res) => {

    const listDanhmucnganhnghe= await dao.sequelize.query(
        `Exec GetAllDanhmucnganhnghe ` , { raw: true, nest: true }
    )
    return res.status(200).send(listDanhmucnganhnghe)

}

const GetAllnganhngheByIdDMNN = async (req, res) => {

    const listnganhnghebtIdDMNN= await dao.sequelize.query(
        `Exec GetAllNganhngheByIDdanhmuc @iddanhmucnganh = ` + req.body.id_danhmucnganh, { raw: true, nest: true }
    )
    return res.status(200).send(listnganhnghebtIdDMNN)

}

const AddNganhnghequantam = async (req, res) => {
    const nganhnghequantam= await dao.sequelize.query(
        "exec Add_Nganhnghe_User @idUser= '" + req.body.id_user + "', @idNganhnghe= '" + req.body.id_nganhnghe + "'", { raw: true, nest: true }
    )
    return res.status(200).send(nganhnghequantam)
} 

const GetExpByIdUser = async (req, res) => {
    const ExperienceUser = await dao.sequelize.query(
        "exec GetExperienceByIdUser @iduser= '" + req.body.id_user +  "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(ExperienceUser)
}

const AddExperience = async (req, res) => {
    const ExperienceUser = await dao.sequelize.query(
        "exec AddExperienceByIdUser @iduser= '" + req.body.id_user + "', @name_experience= '" + req.body.name_experience 
            + "', @amount_years= '" + req.body.amount_years +"', @mota= '" + req.body.mota + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(ExperienceUser)
}

const UpdateExperience = async (req, res) => {
    const ExperienceUser = await dao.sequelize.query(
        "exec UpdateExperienceByIdUser @id_expU= '" + req.body.id + "', @name_experience= '" + req.body.name_experience 
            + "', @amount_years= '" + req.body.amount_years +"', @mota= '" + req.body.mota + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(ExperienceUser)
}

const DeleteExperience = async (req, res) => {
    const ExperienceUser = await dao.sequelize.query(
        "exec DeleteExperienceByIdUser @id_expU= '" + req.body.id + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(ExperienceUser)
}

const GetSkillByIdUser = async (req, res) => {
    const SkillUser = await dao.sequelize.query(
        "exec GetSkillByIdUser @iduser= '" + req.body.id_user + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(SkillUser)
}

const AddSkill = async (req, res) => {
    const SkillUser = await dao.sequelize.query(
        "exec AddSkillByIdUser @iduser= '" + req.body.id_user + "', @id_skill= '" + req.body.id_skill 
            + "', @mota= '" + req.body.mota + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(SkillUser)
}

const UpdateSkill = async (req, res) => {
    const SkillUser = await dao.sequelize.query(
        "exec UpdateSkillByIdUser @id_skillU= '" + req.body.id + "', @id_skill= '" + req.body.id_skill 
        + "', @mota= '" + req.body.mota + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(SkillUser)
}

const DeleteSkill = async (req, res) => {
    const SkillUser = await dao.sequelize.query(
        "exec DeleteSkillByIdUser @id_skillU= '" + req.body.id + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(SkillUser)
}

const GetDanhmucnganhNgheByIdUser = async (req, res) => {
    const dmnnquantam = await dao.sequelize.query(
        "exec GetDanhmucnganhNgheByIdUser @idUser= '" + req.body.id_user +  "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(dmnnquantam)
}

const GetNganhNgheByIdUserIddmnn = async (req, res) => {
    const dmnnquantam = await dao.sequelize.query(
        "exec GetDanhmucnganhNgheByIdUser @idUser= '" + req.body.id_user + "', @iddmnn= '" + req.body.id_danhmucnganh +  "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(dmnnquantam)
}

const GetJobtoApplicant = async (req, res) => {
    const JobtoApplicant = await dao.sequelize.query(
        "exec JobtoApplicant @idUser= " + req.body.id_user +  "",
    { raw: true, nest: true }
    )
    return res.status(200).send(JobtoApplicant)
}

const GetSavedJob = async (req, res) => {
    const SavedJob = await dao.sequelize.query(
        "exec GetSavedJob @idUser= '" + req.body.id_user + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(SavedJob)
}

const GetAppliedJob = async (req, res) => {
    const AppliedJob = await dao.sequelize.query(
        "exec GetAppliedJob @idUser= '" + req.body.id_user + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(AppliedJob)
}

const GetAppliedJobByStatus = async (req, res) => {
    const StatusJob = await dao.sequelize.query(
        "exec GetAppliedJobByStatus @idUser= '" + req.body.id_user + "', @status= '" + req.body.trangthai + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(StatusJob)
}

const GetDataTrinhdohocvan = async (req, res) => {
    const StatusJob = await dao.sequelize.query(
        "exec GetDataTrinhdohocvan ", { raw: true, nest: true }
    )
    return res.status(200).send(StatusJob)
}

const GetDataLoaiSkill = async (req, res) => {
    const StatusJob = await dao.sequelize.query(
        "exec GetDataLoaiSkill ", { raw: true, nest: true }
    )
    return res.status(200).send(StatusJob)
}

const GetDataSkillByIdLoaiSkill = async (req, res) => {
    const StatusJob = await dao.sequelize.query(
        "exec GetDataSkillByIdLoaiSkill @idLoaikynang= '" + req.body.id_loaikynang + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(StatusJob)
}

const ApplyJob = async (req, res) => {
    const apply = await dao.sequelize.query(
        "exec ApplyJob @idUser= '" + req.body.id_user + "', @idcongviec= '" + req.body.id_congviec 
        + "', @cv= '" + req.body.CV + "', @ngaynop= '" + req.body.ngaynop +"'",
    { raw: true, nest: true }
    )
    return res.status(200).send(apply)
}

const SaveJob = async (req, res) => {
    const save = await dao.sequelize.query(
        "exec SaveJob @idUser= '" + req.body.id_user + "', @idcongviec= '" + req.body.id_congviec + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(save)
}

module.exports = {
    GetUserById,
    GetAllDanhmucnganhnghe,
    GetAllnganhngheByIdDMNN,
    AddNganhnghequantam,
    GetExpByIdUser,
    AddExperience,
    UpdateExperience,
    DeleteExperience,
    GetSkillByIdUser,
    AddSkill,
    UpdateSkill,
    DeleteSkill,
    GetDanhmucnganhNgheByIdUser,
    GetNganhNgheByIdUserIddmnn,
    GetJobtoApplicant,
    GetSavedJob,
    GetAppliedJob,
    GetAppliedJobByStatus,
    GetDataTrinhdohocvan,
    GetDataLoaiSkill,
    GetDataSkillByIdLoaiSkill,
    ApplyJob,
    SaveJob
}