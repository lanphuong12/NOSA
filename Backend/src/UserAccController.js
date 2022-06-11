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

const createUser = async (req, res) => {

    const UserAcc = await dao.sequelize.query("exec Create_User @phone= '" + req.body.dienthoai 
    + "', @password= '" + req.body.matkhau + "', @role= '" + req.body.trangthai + "'", { raw: true, nest: true })
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
    createUser,
    changePassword
}