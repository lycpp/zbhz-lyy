package com.zuobiao.map.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zuobiao.map.utils.JdbcUtils;
import com.zuobiao.map.vo.GeometryVo;

public class GeometryDao {

	public void updateVo(GeometryVo gv, String table) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// runner.update(JdbcUtils.getConnection(), "update account set balance=? where
		// id=?", balance, id);
		String sql = "update " + table
				+ " set formatted_address=? ,businessAreas=? ,streetNumber=?,adcode=? ,area=?,township=?,areaname=?,street=? where address=?";

		runner.update(JdbcUtils.getConnection(), sql, gv.getFormatted_address(), gv.getBusinessAreas(),
				gv.getStreetNumber(), gv.getAdcode(), gv.getArea(), gv.getTownship(), gv.getAreaName(), gv.getStreet(),
				gv.getAddress());

	}

	public void addGeometryVo(GeometryVo gv, int i) throws Exception {
		/*
		 * vo.setFormatted_address(formatted_address);1
		 * vo.setStreet(streetMap.get("street").toString());
		 * vo.setStreetNumber(streetMap.get("number").toString());1
		 * vo.setBusinessAreas(map.get("businessAreas").toString());
		 * vo.setAdcode(map.get("adcode").toString());
		 * vo.setTownship(map.get("township").toString());1
		 */
		QueryRunner runner = new QueryRunner();
		// runner.update(JdbcUtils.getConnection(), "update account set balance=? where
		// id=?", balance, id);
		String sql = "update areadata" + i
				+ " set adcode=?,street=?,township=?,formatted_address=?,streetnumber=?,areaname=?, location=? ,areaname=? where address=?";

		System.out.println(gv.getArea());

		runner.update(JdbcUtils.getConnection(), sql, gv.getAdcode(), gv.getStreet(), gv.getTownship(),
				gv.getFormatted_address(), gv.getStreetNumber(), gv.getAreaName(), gv.getLocation(), gv.getAreaName(),
				gv.getAddress());

	}

	/*
	 * //获得所有的数据
	 * 
	 * @SuppressWarnings("unchecked") public List<GeometryVo> findByName(String
	 * c_name) throws Exception { QueryRunner runner = new QueryRunner(); return
	 * (List<GeometryVo>) runner.query(JdbcUtils.getConnection(),
	 * "select * from customer ", new BeanHandler<GeometryVo>(GeometryVo.class)); }
	 */
	public List<GeometryVo> getAll(String table) throws SQLException {
		// 该数组中每个元素就是记录的每列的值
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String str = "select * from " + table;
		List<GeometryVo> list = runner.query(str, new BeanListHandler<GeometryVo>(GeometryVo.class));
		return list;

	}

	public void updateVo2(GeometryVo gv, String table) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// runner.update(JdbcUtils.getConnection(), "update account set balance=? where
		// id=?", balance, id);
		String sql = "update " + table + " set formatted_address=?  ,location=? where address=?";

		runner.update(JdbcUtils.getConnection(), sql, gv.getFormatted_address(), gv.getLocation(),

				gv.getAddress());

	}

}
