package com.bit.myqpp03.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.bit.myqpp03.entity.GuestVo;

public interface GuestDao {
	
	List<GuestVo> selectAll() throws SQLException;
	
	GuestVo selectOne(int sabun) throws SQLException;
	
	int insertOne(GuestVo bean) throws SQLException;
	
	int updateOne(GuestVo bean) throws SQLException;
	
	int deleteOne(int sabun) throws SQLException;
}
