const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const GetCompanyByIdJob = async (req, res) => {

    const company= await dao.sequelize.query(
        "exec GetCompanybyIdJob @idJob= '" + req.body.id_congviec +  "'" , { raw: true, nest: true }
    )
    return res.status(200).send(company[0])

}

const UpdatedCompanyByIdCompany = async (req, res) => {

    const company= await dao.sequelize.query(
        "exec UpdateCompanyCreatedByIdHR @idCty= '" + req.body.id_congty 
                                    + "', @nameCty= '" + req.body.ten 
                                    + "', @email= '" + req.body.email 
                                    + "', @address= '" + req.body.diachi 
                                    + "', @phone= '" + req.body.dienthoai 
                                    + "', @logo= '" + req.body.logo 
                                    + "', @guest= '" + req.body.gioithieu 
                                    + "', @website= '" + req.body.url_website +  "'" , { raw: true, nest: true }
    )
    return res.status(200).send(company)

}

const AddCompany = async (req, res) => {

}
module.exports = {
    GetCompanyByIdJob,
    UpdatedCompanyByIdCompany,
    AddCompany
}