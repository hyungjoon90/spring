package com.bit.myapp05.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bit.myapp05.model.entity.GuestVo;

@Component
public class GuestDaoImpl01 implements GuestDao {

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
