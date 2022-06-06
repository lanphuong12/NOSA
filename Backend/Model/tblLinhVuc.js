const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('tblLinhVuc', {
    Id: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    TenLinhVuc: {
      type: DataTypes.STRING(100),
      allowNull: true
    },
    'Tiêu đề': {
      type: DataTypes.STRING(250),
      allowNull: true
    },
    MetaDescription: {
      type: DataTypes.STRING(300),
      allowNull: true
    },
    MetaKeywords: {
      type: DataTypes.STRING(300),
      allowNull: true
    },
    Active: {
      type: DataTypes.INTEGER,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'tblLinhVuc',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK__tblLinhVuc__3214EC07A250F52A",
        unique: true,
        fields: [
          { name: "Id" },
        ]
      },
    ]
  });
};
