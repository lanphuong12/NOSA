const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Loaihinhcongviec', {
    id_loaihinhcv: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    tenloaihinhcv: {
      type: DataTypes.STRING(150),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Loaihinhcongviec',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Loaihinhcongviec_1",
        unique: true,
        fields: [
          { name: "id_loaihinhcv" },
        ]
      },
    ]
  });
};
