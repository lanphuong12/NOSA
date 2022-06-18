const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetApplicantforHr = async (req, res) => {

    const listUngVien = await dao.sequelize.query(
        "exec GetApplicantAdapterForHR @idUser= '" + req.body.id_user + "'", { raw: true, nest: true })
    return res.status(200).json(listUngVien)

}

const GetJobCreated = async (req, res) => {
    const listJobCreated = await dao.sequelize.query(
        "exec GetJobCreatedByIdHR @idUser= '" + req.body.id_user + "'", { raw: true, nest: true })
    return res.status(200).json(listJobCreated)
}

const GetCompanyCreated = async (req, res) => {

    const listCompany= await dao.sequelize.query(
        "exec GetCompanyCreatedByIdHR @idUser= '" + req.body.id_user + "'", { raw: true, nest: true })
    return res.status(200).send(listCompany)

}

// Get CV có trạng thái chờ duyệt / xem xét
const GetAllCVApplied = async (req, res) => {
    const listCV= await dao.sequelize.query(
        "exec GetAllCVByIdIdHr @idUser= '" + req.body.id_user + "'", { raw: true, nest: true })
    return res.status(200).send(listCV)
}

const GetAllCVAppliedByIdJob = async (req, res) => {
    const listCV= await dao.sequelize.query(
        "exec GetCVByIdJob @idJob= '" + req.body.id_congviec + "'", { raw: true, nest: true })
    return res.status(200).send(listCV)
}

const UpdateStatusCV = async (req, res) => {
    const CV= await dao.sequelize.query(
        "exec SetupStatusCV @idcv= '" + req.body.id_nopcv 
                        + "',@status= '" + req.body.trangthai +  "'", { raw: true, nest: true })
    return res.status(200).send(CV)
}

const GetCVbyStatus = async (req, res) => {
    const listCV= await dao.sequelize.query(
        "exec GetAllCVByIdIdHr_Status @status= '" + req.body.trangthai 
                                + "',@idUser= '" + req.body.id_user +  "'", { raw: true, nest: true })
    return res.status(200).send(listCV)
}

const GetJobByIdCty = async (req, res) => {
    const listJob= await dao.sequelize.query(
        "exec GetJobByIdCompany @idCty= '" + req.body.id_congty +  "'", { raw: true, nest: true })
    return res.status(200).send(listJob)
}

module.exports = {
    GetApplicantforHr,
    GetJobCreated,
    GetCompanyCreated,
    GetAllCVApplied,
    GetAllCVAppliedByIdJob,
    UpdateStatusCV,
    GetCVbyStatus,
    GetJobByIdCty
}