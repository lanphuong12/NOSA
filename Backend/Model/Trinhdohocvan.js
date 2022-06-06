const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Trinhdohocvan', {
    id_trinhdo: {
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    ten: {
      type: DataTypes.STRING(150),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Trinhdohocvan',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Trinhdohocvan_1",
        unique: true,
        fields: [
          { name: "id_trinhdo" },
        ]
      },
    ]
  });
};
