package com.bit.myqpp03.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import com.bit.myqpp03.entity.GuestVo;

public class GuestDaoImpl03 extends SimpleJdbcDaoSupport implements GuestDao{
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="select * from guest order by sabun";
		return getSimpleJdbcTemplate().query(sql, new RowMapper<GuestVo>() {

			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean =new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		});
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {

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
