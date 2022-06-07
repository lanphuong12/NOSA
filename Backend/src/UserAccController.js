const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const login = async (req, res) => {

    const UserAcc = await dao.sequelize.query("exec LoginbyPhone @phone= '" + req.body.dienthoai + "', @password= '" + req.body.matkhau + "'", { raw: true, nest: true })
    if (UserAcc === undefined) {

        res.status(401).json("Wrong username ors password")

    } else {
        console.log(UserAcc)
        return res.status(200).json({
            UserAcc
        })
    }

}

const changePassword = async (req, res) => {

}

const updateUserAcc = async (req, res) => {

}

module.exports = {
    login,
    changePassword,
    updateUserAcc
}