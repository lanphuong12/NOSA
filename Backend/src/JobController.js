const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetJobByIdJob = async (req, res) => {

    const listDanhmucnganhnghe= await dao.sequelize.query(
        `Exec GetAllDanhmucnganhnghe ` , { raw: true, nest: true }
    )
    return res.status(200).send(listDanhmucnganhnghe)

}

const UpdateJob = async (req, res) => {

}

const GetJobByIdSkillJob = async (req, res) => {

}

const AddJob = async (req, res) => {

}

const GetJobBySalary = async (req, res) => {

}

const GetJobByName = async (req, res) => {

}

module.exports = {
    GetJobByIdJob,
    UpdateJob,
    GetJobByIdSkillJob,
    AddJob,
    GetJobBySalary,
    GetJobByName
}