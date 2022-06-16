const Sequelize = require('sequelize');
const dao = require('../Dao/Connection')

/*function*/
const login = async (req, res) => {

    const User = await dao.sequelize.query("exec LoginbyPhone @phone= '" + req.body.dienthoai + "', @password= '" + req.body.matkhau + "'", { raw: true, nest: true })
    return res.status(200).json({
        UserAcc: User[0]
    })

}

const checkPhone = async (req, res) => {

    const phone = await dao.sequelize.query("exec CheckPhone @phone= '" + req.body.dienthoai + "'", { raw: true, nest: true })
    
    return res.status(200).send(phone)

}

const createUser = async (req, res) => {

    
    const Acc = await dao.sequelize.query("SELECT TOP 1 id_user FROM User_Acc ORDER BY id_user DESC", { raw: true, nest: true })

    return res.status(200).send(Acc)

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

const UpdateUserAcc = async (req, res) => {
    const UserAcc = await dao.sequelize.query("exec Update_User @idUser= '" + req.body.id_user 
    + "', @hoten= '" + req.body.hoten +"', @email= '" + req.body.email 
    + "', @gender= '" + req.body.gioitinh + "', @birth= '" + req.body.ngaysinh 
    + "', @address= '" + req.body.diachi + "', @trinhdo= '" + req.body.id_trinhdo 
    + "', @anh = '" + req.body.anh + "'", { raw: true, nest: true })

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
    changePassword,
    UpdateUserAcc
}