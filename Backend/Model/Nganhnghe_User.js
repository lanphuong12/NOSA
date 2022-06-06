const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Nganhnghe_User', {
    id: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_user: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    id_nganhnghe: {
      type: DataTypes.INTEGER,
      allowNull: false
    }
  }, {
    sequelize,
    tableName: 'Nganhnghe_User',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Nganhnghe_User",
        unique: true,
        fields: [
          { name: "id" },
        ]
      },
    ]
  });
};
