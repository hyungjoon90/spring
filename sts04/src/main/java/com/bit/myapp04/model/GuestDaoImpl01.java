package com.bit.myapp04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.bit.myapp04.model.entity.GuestVo;

public class GuestDaoImpl01 extends JdbcDaoSupport implements GuestDao {

	
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	private RowMapper<GuestVo> rowMapper = new RowMapper<GuestVo>() {
		@Override
		public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new GuestVo(
						rs.getInt("sabun")	,rs.getString("name")	,rs.getDate("nalja")
						,rs.getInt("pay")
					);
		}// mapRow() end
	};// rowMapper end
	
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM GUEST ORDER BY SABUN";
		return getJdbcTemplate().query(sql, rowMapper );
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		String sql = "SELECT * FROM GUEST where sabun = ?";
		return getJdbcTemplate().query(sql, new Object[] {sabun},rowMapper ).get(0);
	}

	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql ="insert into guest values (?,?,sysdate,?)";
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				getJdbcTemplate().update( new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, bean.getSabun());
						pstmt.setString(2, bean.getName());
						pstmt.setInt(3, bean.getPay());
						return pstmt;
					}});
				bean.setSabun(bean.getSabun()+333);
				getJdbcTemplate().update( new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, bean.getSabun());
						pstmt.setString(2, bean.getName());
						pstmt.setInt(3, bean.getPay());
						return pstmt;
					}});				
			
			}});

		
		
		
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(definition );
//		
//		try {
//		jdbcTemplate.update( new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, bean.getSabun());
//				pstmt.setString(2, bean.getName());
//				pstmt.setInt(3, bean.getPay());
//				return pstmt;
//			}});
//		bean.setSabun(bean.getSabun()+333);
//		jdbcTemplate.update( new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, bean.getSabun());
//				pstmt.setString(2, bean.getName());
//				pstmt.setInt(3, bean.getPay());
//				return pstmt;
//			}});
//		transactionManager.commit(status);
//		
//		}catch (Exception e) {
//			transactionManager.rollback(status);
//		}
		return 0;
	}

	@Override
	public int updateOne(final GuestVo bean) throws SQLException {
		final String sql = "UPDATE GUEST SET NAME=?, PAY=? WHERE SABUN=?";
		return getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getSabun());
				return pstmt;
			}});
	}

	@Override
	public int deleteOne(final int sabun) throws SQLException {
		final String sql ="DELETE FROM GUEST WHERE SABUN = ?";

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				getJdbcTemplate().update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, sabun);
						return pstmt;
					}});
				
			}});

		return 0;
	}

}