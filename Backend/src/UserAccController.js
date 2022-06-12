const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const login = async (req, res) => {

    const UserAcc = await dao.sequelize.query("exec LoginbyPhone @phone= '" + req.body.dienthoai + "', @password= '" + req.body.matkhau + "'", { raw: true, nest: true })
    if (UserAcc.length == 0) {

        return null;

    } else {
        console.log(UserAcc)
        return res.status(200).send(UserAcc)
    }

}

const checkPhone = async (req, res) => {

    const phone = await dao.sequelize.query("exec CheckPhone @phone= '" + req.body.dienthoai + "'", { raw: true, nest: true })
    
    return res.status(200).send(phone)

}

const createUser = async (req, res) => {

    const UserAcc = await dao.sequelize.query("exec Create_User @phone= '" + req.body.dienthoai 
    + "', @password= '" + req.body.matkhau + "', @role= '" + req.body.role + "'", { raw: true, nest: true })
    if (UserAcc.length == 0) {

        return null;

    } else {
        console.log(UserAcc)
        return res.status(200).send(UserAcc)
    }

}

const changePassword = async (req, res) => {
    const UserAcc = await dao.sequelize.query("exec Change_Pass @idUser= '" + req.body.id_user 
    + "', @pass= '" + req.body.matkhau + "'", { raw: true, nest: true })
    if (UserAcc.length == 0) {

        return null;

    } else {
        console.log(UserAcc)
        return res.status(200).send(UserAcc)
    }
}


module.exports = {
    login,
    checkPhone,
    createUser,
    changePassword
}