const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Danhmucnganh', {
    id_danhmucnganh: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    tendanhmuc: {
      type: DataTypes.STRING(250),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Danhmucnganh',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Danhmucnganh_1",
        unique: true,
        fields: [
          { name: "id_danhmucnganh" },
        ]
      },
    ]
  });
};
