const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('NopCV', {
    id_nopcv: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_user: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    id_congviec: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    CV: {
      type: DataTypes.STRING(150),
      allowNull: true
    },
    ngaynop: {
      type: DataTypes.DATEONLY,
      allowNull: true
    },
    trangthai: {
      type: DataTypes.INTEGER,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'NopCV',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_NopCV_1",
        unique: true,
        fields: [
          { name: "id_nopcv" },
        ]
      },
    ]
  });
};
