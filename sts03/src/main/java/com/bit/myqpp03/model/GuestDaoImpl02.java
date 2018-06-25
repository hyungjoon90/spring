package com.bit.myqpp03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.bit.myqpp03.entity.GuestVo;

public class GuestDaoImpl02 implements GuestDao {
	Logger log = Logger.getLogger(getClass());
	
	JdbcTemplate JdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return JdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="select * from guest order by sabun desc";
		return JdbcTemplate.query(sql, new RowMapper<GuestVo>() {
			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean =new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				log.debug(rowNum + "¹øÂ°" + bean);
				return bean;
			}
		});
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		String sql="select * from guest where sabun=?";
		return JdbcTemplate.queryForObject(sql
				, new Object[] {sabun}, new RowMapper<GuestVo>() {

					@Override
					public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestVo bean = new GuestVo();
						bean.setSabun(rs.getInt("sabun"));
						bean.setName(rs.getString("name"));
						bean.setNalja(rs.getDate("nalja"));
						bean.setPay(rs.getInt("pay"));
						log.debug(rowNum==1);
						log.debug(bean);
						return bean;
					}});
	}

	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql="insert into guest values(?,?,sysdate,?)";
		return JdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getSabun());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPay());
				return pstmt;
			}
		});
	}

	@Override
	public int updateOne(final GuestVo bean) throws SQLException {
		final String sql="update guest set name=?, pay=? where sabun=?";
		return JdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getSabun());
				return pstmt;
			}
		});
	}

	@Override
	public int deleteOne(final int sabun) throws SQLException {
		final String sql= "delete from guest where sabun=?";
		return JdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				return pstmt;
			}
		});
	}

}
