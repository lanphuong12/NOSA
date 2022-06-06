const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('tblDanToc', {
    Id: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    TenDanToc: {
      type: DataTypes.STRING(100),
      allowNull: true
    },
    TieuDe: {
      type: DataTypes.STRING(250),
      allowNull: true
    },
    MoTa: {
      type: DataTypes.STRING(300),
      allowNull: true
    },
    TuKhoa: {
      type: DataTypes.STRING(300),
      allowNull: true
    },
    TrangThai: {
      type: DataTypes.INTEGER,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'tblDanToc',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK__tblDanToc__3214EC07A250F52A",
        unique: true,
        fields: [
          { name: "Id" },
        ]
      },
    ]
  });
};
