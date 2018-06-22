package com.bit.myapp02.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bit.myapp02.model.entity.GuestVo;

public class GuestDao03Impl implements GuestDao<GuestVo>{
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<GuestVo> rowMapper =new RowMapper<GuestVo>() {
		
		@Override
		public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new GuestVo(
					rs.getInt("sabun"),rs.getString("name")
					,rs.getDate("nalja"),rs.getInt("pay")
					);
		}
	};
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="select * from guest order by sabun desc";
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql="select * from guest where sabun=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {pk},rowMapper);
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		String sql="insert into guest values(?,?,sysdate,?)";
		return jdbcTemplate.update(sql,new Object[] {bean.getSabun(),bean.getName(),bean.getPay()});
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql="update guest set name=?, pay=? where sabun=?";
		return jdbcTemplate.update(sql,new Object[] {bean.getName(),bean.getPay(),bean.getSabun()});
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="delete from guest where sabun=?";
		return jdbcTemplate.update(sql,new Object[] {pk});
	}

}
