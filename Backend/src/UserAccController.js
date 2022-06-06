const Sequelize = require('sequelize');
const DataTypes = Sequelize.DataTypes;
const account = require('../Model/User_Acc').account;
const dao = require('../Dao/Connection')

/*function*/
const login = async (req, res) => {

    const UserAcc = await dao.sequelize.query("exec LoginbyPhone @phone= '" + req.body.dienthoai + "', @password= '" + req.body.matkhau + "'", { raw: true, nest: true })
    if (UserAcc === undefined) {

        res.status(401).json("Wrong username or password")

    } else {
        console.log(UserAcc)
        if (req.body.dienthoai == UserAcc.dienthoai && req.body.matkhau == UserAcc.matkhau) {
            return res.status(200).json({
                UserAcc
            })
        }
        return res.status(401).json("Wrong username or password");
        
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