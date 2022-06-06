const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Luucongviec', {
    id_luucongviec: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_user: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    id_congviec: {
      type: DataTypes.INTEGER,
      allowNull: false
    }
  }, {
    sequelize,
    tableName: 'Luucongviec',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Luucongviec_1",
        unique: true,
        fields: [
          { name: "id_luucongviec" },
        ]
      },
    ]
  });
};
