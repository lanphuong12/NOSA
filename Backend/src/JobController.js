const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetJobByIdJob = async (req, res) => {

    const job= await dao.sequelize.query(
        "exec GetJobbyIdJob @idJob= '" + req.body.id_congviec +  "'" , { raw: true, nest: true }
    )
    return res.status(200).send(job[0])

}

const GetSkillJobbyIdJob = async (req, res) => {

    const skilljob= await dao.sequelize.query(
        "exec GetSkillJobbyIdJob @idJob= '" + req.body.id_congviec +  "'" , { raw: true, nest: true }
    )
    return res.status(200).send(skilljob)

}

const GetJobbyIdSkill = async (req, res) => {

    const job= await dao.sequelize.query(
        "exec GetJobbyIdSkill @idSkill= '" + req.body.id_skill +  "'" , { raw: true, nest: true }
    )
    return res.status(200).send(job)

}

const UpdateJob = async (req, res) => {

}

const AddJob = async (req, res) => {

}

const GetJobBySalary = async (req, res) => {

}

const GetJobByName = async (req, res) => {

}

module.exports = {
    GetJobByIdJob,
    GetSkillJobbyIdJob,
    GetJobbyIdSkill,
    UpdateJob,
    AddJob,
    GetJobBySalary,
    GetJobByName
}