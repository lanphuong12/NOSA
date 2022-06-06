const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Experiences_of_User', {
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
    name_experience: {
      type: DataTypes.STRING(50),
      allowNull: false
    },
    amount_years: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    mota: {
      type: DataTypes.TEXT,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Experiences_of_User',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Experiences_of_User",
        unique: true,
        fields: [
          { name: "id" },
        ]
      },
    ]
  });
};
