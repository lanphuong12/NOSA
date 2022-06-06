const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Loaicongviec', {
    id_loaicv: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    tenloaicv: {
      type: DataTypes.STRING(150),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Loaicongviec',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Loaicongviec_1",
        unique: true,
        fields: [
          { name: "id_loaicv" },
        ]
      },
    ]
  });
};
