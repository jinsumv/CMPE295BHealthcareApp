package com.secondopinion.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.secondopinion.common.model.User;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users " +
				"(USERNAME, PASSWORD, ENABLED) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.isEnabled());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	@Override
	public void addRoleForUser(User user) {
		String sql = "INSERT INTO user_roles " +
				"(USER_ID, AUTHORITY) VALUES (?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, "ROLE_USER");
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	

	@Override
	public User findByUserName(String userName) {
		String sql = "SELECT * FROM users WHERE USERNAME = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(
					rs.getInt("USER_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getBoolean("ENABLED")
				);
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
