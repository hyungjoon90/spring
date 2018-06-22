package com.bit.myapp02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.myapp02.model.entity.GuestVo;

public class GuestDao02Impl implements GuestDao<GuestVo>{
	@Autowired
	DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestDao02Impl() {
//		BasicDataSource bds=new BasicDataSource();
//		bds.setDriverClassName("oracle.jdbc.OracleDriver");
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setUsername("scott");
//		bds.setPassword("tiger");
//		ds=bds;
	}
	
	private List<GuestVo> selectAll(String sql,Object[] objs) throws SQLException {
		List<GuestVo> list =new ArrayList<GuestVo>();
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++){
				pstmt.setObject(i+1, objs[i]);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		}finally {
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	private int update(String sql, Object[] objs) throws SQLException{
		try {
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		} finally {
			if(conn!=null)conn.close();
		}
		
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="select * from Guest order by sabun";
		return selectAll(sql, new Object[]{});
	}

	@Override
	public GuestVo selectOne(int pk) throws SQLException {
		String sql="select * from Guest where sabun=?";
		return selectAll(sql,new Object[]{pk}).get(0);
	}


	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		String sql="insert into guest values (?,?,sysdate,?)";
		Object[] args= {bean.getSabun(),bean.getName(),bean.getPay()};
		return update(sql,args);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql="update Guest set name=?,pay? where sabun=?";
		Object[] args= {bean.getName(),bean.getPay(),bean.getSabun()};
		return update(sql,args);
	}

	@Override
	public int deleteOne(int pk) throws SQLException {
		String sql="delete from guest where sabun=?";
		Object[] args= {pk};
		return update(sql,args);
	}

}
