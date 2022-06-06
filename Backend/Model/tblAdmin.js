const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('tblAdmin', {
    Id: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    TaiKhoan: {
      type: DataTypes.STRING(30),
      allowNull: true
    },
    MatKhau: {
      type: DataTypes.STRING(100),
      allowNull: true
    },
    HoVaTen: {
      type: DataTypes.STRING(50),
      allowNull: true
    },
    SoDienThoai: {
      type: DataTypes.STRING(20),
      allowNull: true
    },
    Email: {
      type: DataTypes.STRING(50),
      allowNull: true
    },
    NgayTao: {
      type: DataTypes.DATE,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'tblAdmin',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK__tblAdmin__3214EC07D2539166",
        unique: true,
        fields: [
          { name: "Id" },
        ]
      },
    ]
  });
};
