const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetApplicant = async (req, res) => {

    const listApplicant = await dao.sequelize.query(
        "exec GetApplicantAdapterForHR @idUser= '" + req.body.id_user + "'",
    )
    return res.status(200).send(listApplicant)

}

const GetJobCreated = async (req, res) => {
    
}

const GetCompanyCreated = async (req, res) => {
    const listCompany= await dao.sequelize.query(
        "exec GetCompanyCreatedByIdHR @idUser= '" + req.body.id_user + "'",
    )
    return res.status(200).send(listCompany)

}

// Get CV có trạng thái chờ duyệt / xem xét
const GetAllCVApplied = async (req, res) => {
    
}

const GetAllCVAppliedByIdJob = async (req, res) => {
    
}

const UpdateStatusCV = async (req, res) => {
    
}

const GetCVbyStatus = async (req, res) => {
    
}

module.exports = {
    GetApplicant,
    GetJobCreated,
    GetCompanyCreated,
    GetAllCVApplied,
    GetAllCVAppliedByIdJob,
    UpdateStatusCV,
    GetCVbyStatus
}