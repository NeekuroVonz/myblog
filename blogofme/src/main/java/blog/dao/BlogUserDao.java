package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import blog.entity.BlogUser;

public class BlogUserDao implements BlogDao<BlogUser> {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connect() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/mysql");
			conn = ds.getConnection();
			System.out.println("connect: " + conn);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public BlogUser insert(BlogUser arg) {
		connect();	
		try {
			pstmt = conn.prepareStatement("insert into blog_user (name, email) values (?, ?)");
			pstmt.setString(1, arg.getName());
			pstmt.setString(2, arg.getEmail());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return arg;
	}
	
	@Override
	public void update(BlogUser arg) {
		connect();	
		try {
			pstmt = conn.prepareStatement("insert into blog_user (name, email) values (?, ?)");
			pstmt.setString(1, arg.getName());
			pstmt.setString(2, arg.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	@Override
	public BlogUser select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<BlogUser> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
	
}
