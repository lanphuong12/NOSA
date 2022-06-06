const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Congty', {
    id_congty: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_user: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    ten: {
      type: DataTypes.STRING(250),
      allowNull: true
    },
    email: {
      type: DataTypes.STRING(50),
      allowNull: true
    },
    diachi: {
      type: DataTypes.STRING(250),
      allowNull: true
    },
    dienthoai: {
      type: DataTypes.STRING(20),
      allowNull: true
    },
    logo: {
      type: DataTypes.STRING(150),
      allowNull: true
    },
    gioithieu: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    url_website: {
      type: DataTypes.STRING(200),
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Congty',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Congty",
        unique: true,
        fields: [
          { name: "id_congty" },
        ]
      },
    ]
  });
};
