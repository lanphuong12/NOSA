const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
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

const AddExperience = async (req, res) => {
    const ExperienceUser = await dao.sequelize.query(
        "exec AddExperienceByIdUser @iduser= '" + req.body.id_user + "', @name_experience= '" + req.body.name_experience 
            + "', @amount_years= '" + req.body.amount_years +"', @mota= '" + req.body.mota + "'",
    { raw: true, nest: true }
    )
    return res.status(200).send(ExperienceUser)
}

const UpdateExperience = async (req, res) => {

}

const DeleteExperience = async (req, res) => {

}

const AddSkill = async (req, res) => {

}

const UpdateSkill = async (req, res) => {

}

const DeleteSkill = async (req, res) => {

}

const GetJobtoApplicant = async (req, res) => {

}

const GetSavedJob = async (req, res) => {

}

const GetAppliedJob = async (req, res) => {

}

const GetAppliedJobByStatusReject = async (req, res) => {

}

const GetAppliedJobByStatusWaiting = async (req, res) => {

}

const GetAppliedJobByStatusApproved = async (req, res) => {

}

const GetAppliedJobByStatusConsider = async (req, res) => {

}

module.exports = {
    GetAllDanhmucnganhnghe,
    GetAllnganhngheByIdDMNN,
    AddNganhnghequantam,
    AddExperience,
    UpdateExperience,
    DeleteExperience,
    AddSkill,
    UpdateSkill,
    DeleteSkill,
    GetJobtoApplicant,
    GetSavedJob,
    GetAppliedJob,
    GetAppliedJobByStatusReject,
    GetAppliedJobByStatusWaiting,
    GetAppliedJobByStatusApproved,
    GetAppliedJobByStatusConsider
    
}