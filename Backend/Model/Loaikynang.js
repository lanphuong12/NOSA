const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Loaikynang', {
    id_loaikynang: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
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
    tableName: 'Loaikynang',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Loaikynang_1",
        unique: true,
        fields: [
          { name: "id_loaikynang" },
        ]
      },
    ]
  });
};
