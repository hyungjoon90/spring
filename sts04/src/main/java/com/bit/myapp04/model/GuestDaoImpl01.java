package com.bit.myapp04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.bit.myapp04.model.entity.GuestVo;

public class GuestDaoImpl01 implements GuestDao {
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<GuestVo> rowMapper = new RowMapper<GuestVo>() {
		
		@Override
		public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new GuestVo(
					rs.getInt("sabun")
					,rs.getString("name")
					,rs.getDate("nalja")
					,rs.getInt("pay")
					);
		}
	};
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="select * from guest order by sabun";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		return null;
	}

	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql="insert into guest values(?,?,sysdate,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getSabun());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPay());
				return pstmt;
			}
		});
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql="update guest set name=?,pay=? where sabun=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getSabun());
				return pstmt;
			}
		});
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		String sql="delete from guest where sabun=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				return pstmt;
			}
		});
	}

}
