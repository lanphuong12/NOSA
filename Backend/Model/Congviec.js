const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('Congviec', {
    id_congviec: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    id_congty: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    id_danhmucnganh: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    id_loaicv: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    id_loaihinhcv: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    id_trinhdo: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    ten: {
      type: DataTypes.STRING(350),
      allowNull: true
    },
    gioitinh: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    soluong: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    luongtoithieu: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    luongtoida: {
      type: DataTypes.INTEGER,
      allowNull: true
    },
    mota: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    kinhnghiemchitiet: {
      type: DataTypes.TEXT,
      allowNull: true
    },
    ngaybatdau: {
      type: DataTypes.DATEONLY,
      allowNull: true
    },
    ngayketthuc: {
      type: DataTypes.DATEONLY,
      allowNull: true
    },
    trangthai: {
      type: DataTypes.INTEGER,
      allowNull: true
    }
  }, {
    sequelize,
    tableName: 'Congviec',
    schema: 'dbo',
    timestamps: false,
    indexes: [
      {
        name: "PK_Congviec",
        unique: true,
        fields: [
          { name: "id_congviec" },
        ]
      },
    ]
  });
};
