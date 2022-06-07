const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetApplicant = async (req, res) => {

    const listDanhmucnganhnghe= await dao.sequelize.query(
        `Exec GetAllDanhmucnganhnghe ` , { raw: true, nest: true }
    )
    return res.status(200).send(listDanhmucnganhnghe)

}

const GetJobCreated = async (req, res) => {
    
}

const GetCompanyCreated = async (req, res) => {
    
}

// Get CV có trạng thái chờ duyệt / xem xét
const GetAllCVApplied = async (req, res) => {
    
}

const GetAllCVAppliedByIdJob = async (req, res) => {
    
}

const UpdateStatusCV = async (req, res) => {
    
}

const GetCVrejected = async (req, res) => {
    
}

const GetCVwaiting = async (req, res) => {
    
}

const GetCVapproved = async (req, res) => {
    
}

const GetCVconsider = async (req, res) => {
    
}

module.exports = {
    GetApplicant,
    GetJobCreated,
    GetCompanyCreated,
    GetAllCVApplied,
    GetAllCVAppliedByIdJob,
    UpdateStatusCV,
    GetCVrejected,
    GetCVwaiting,
    GetCVapproved,
    GetCVconsider
}