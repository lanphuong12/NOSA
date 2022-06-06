const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('User_Acc', {
    id_user: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_trinhdo: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    email: {
      type: DataTypes.STRING(50),
      allowNull: true
    },
    matkhau: {
      type: DataTypes.STRING(100),
      allowNull: true
    },
    hoten: {
      type: DataTypes.STRING(100),
      allowNull: true
    },
    gioitinh: {
      type: DataTypes.STRING(10),
      allowNull: true
    },
    ngaysinh: {
      type: DataTypes.DATEONLY,
      allowNull: true
    },
    diachi: {
      type: DataTypes.STRING(150),
      allowNull: true
    },
    dienthoai: {
      type: DataTypes.STRING(20),
      allowNull: true
    },
    role: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    trangthai: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    anh: {
      type: DataTypes.CHAR(200),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'User_Acc',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_User_Acc",
        unique: true,
        fields: [
          { name: "id_user" },
        ]
      },
    ]
  });
};
