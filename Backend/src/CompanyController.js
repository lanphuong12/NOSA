const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetCompanyByIdJob = async (req, res) => {

    const listDanhmucnganhnghe= await dao.sequelize.query(
        `Exec GetAllDanhmucnganhnghe ` , { raw: true, nest: true }
    )
    return res.status(200).send(listDanhmucnganhnghe)

}

const UpdatedCompanyByIdCompany = async (req, res) => {

}

const AddCompany = async (req, res) => {

}
module.exports = {
    GetCompanyByIdJob,
    UpdatedCompanyByIdCompany,
    AddCompany
}