const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Skills_of_User', {
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
    id_skill: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    mota: {
      type: DataTypes.TEXT,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Skills_of_User',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Skills_of_User",
        unique: true,
        fields: [
          { name: "id" },
        ]
      },
    ]
  });
};
