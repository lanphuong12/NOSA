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


module.exports = {
    GetAllDanhmucnganhnghe,
    GetAllnganhngheByIdDMNN
}