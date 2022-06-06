var DataTypes = require("sequelize").DataTypes;
var _Congty = require("./Congty");
var _Congviec = require("./Congviec");
var _Danhmucnganh = require("./Danhmucnganh");
var _Experiences_of_User = require("./Experiences_of_User");
var _Kynang = require("./Kynang");
var _Loaicongviec = require("./Loaicongviec");
var _Loaihinhcongviec = require("./Loaihinhcongviec");
var _Loaikynang = require("./Loaikynang");
var _Luucongviec = require("./Luucongviec");
var _Nganhnghe = require("./Nganhnghe");
var _Nganhnghe_User = require("./Nganhnghe_User");
var _NopCV = require("./NopCV");
var _Skills_of_Job = require("./Skills_of_Job");
var _Skills_of_User = require("./Skills_of_User");
var _Trinhdohocvan = require("./Trinhdohocvan");
var _User_Acc = require("./User_Acc");
var _tblAdmin = require("./tblAdmin");
var _tblDanToc = require("./tblDanToc");
var _tblLinhVuc = require("./tblLinhVuc");

function initModels(sequelize) {
  var Congty = _Congty(sequelize, DataTypes);
  var Congviec = _Congviec(sequelize, DataTypes);
  var Danhmucnganh = _Danhmucnganh(sequelize, DataTypes);
  var Experiences_of_User = _Experiences_of_User(sequelize, DataTypes);
  var Kynang = _Kynang(sequelize, DataTypes);
  var Loaicongviec = _Loaicongviec(sequelize, DataTypes);
  var Loaihinhcongviec = _Loaihinhcongviec(sequelize, DataTypes);
  var Loaikynang = _Loaikynang(sequelize, DataTypes);
  var Luucongviec = _Luucongviec(sequelize, DataTypes);
  var Nganhnghe = _Nganhnghe(sequelize, DataTypes);
  var Nganhnghe_User = _Nganhnghe_User(sequelize, DataTypes);
  var NopCV = _NopCV(sequelize, DataTypes);
  var Skills_of_Job = _Skills_of_Job(sequelize, DataTypes);
  var Skills_of_User = _Skills_of_User(sequelize, DataTypes);
  var Trinhdohocvan = _Trinhdohocvan(sequelize, DataTypes);
  var User_Acc = _User_Acc(sequelize, DataTypes);
  var tblAdmin = _tblAdmin(sequelize, DataTypes);
  var tblDanToc = _tblDanToc(sequelize, DataTypes);
  var tblLinhVuc = _tblLinhVuc(sequelize, DataTypes);


  return {
    Congty,
    Congviec,
    Danhmucnganh,
    Experiences_of_User,
    Kynang,
    Loaicongviec,
    Loaihinhcongviec,
    Loaikynang,
    Luucongviec,
    Nganhnghe,
    Nganhnghe_User,
    NopCV,
    Skills_of_Job,
    Skills_of_User,
    Trinhdohocvan,
    User_Acc,
    tblAdmin,
    tblDanToc,
    tblLinhVuc,
  };
}
module.exports = initModels;
module.exports.initModels = initModels;
module.exports.default = initModels;
