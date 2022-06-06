const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Kynang', {
    id_kynang: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_loaikynang: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    ten: {
      type: DataTypes.STRING(150),
      allowNull: true
    },
    mota: {
      type: DataTypes.STRING(500),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Kynang',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Kynang_1",
        unique: true,
        fields: [
          { name: "id_kynang" },
        ]
      },
    ]
  });
};
