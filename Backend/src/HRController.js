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