package com.bit.myapp06.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.myapp06.model.entity.GuestVo;

public interface GuestDao {

	List<GuestVo> selectAll() throws SQLException;
	GuestVo selectOne(int sabun) throws SQLException;
	int updateOne(GuestVo bean) throws SQLException;
	int deleteOne(int sabun) throws SQLException;
}
