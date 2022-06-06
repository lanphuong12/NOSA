const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Nganhnghe', {
    id_nganh: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_danhmucnganh: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    tennganh: {
      type: DataTypes.STRING(250),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Nganhnghe',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Nganhnghe_1",
        unique: true,
        fields: [
          { name: "id_nganh" },
        ]
      },
    ]
  });
};
