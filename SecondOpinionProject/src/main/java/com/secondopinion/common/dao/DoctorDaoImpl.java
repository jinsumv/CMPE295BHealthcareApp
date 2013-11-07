package com.secondopinion.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.User;

@Component
public class DoctorDaoImpl implements DoctorDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void insert(User user, Doctor doctor) {
		String sql = "INSERT INTO doctor " +
				"(USER_ID, DOCTOR_NAME, DATE_OF_BIRTH, GENDER, QUALIFYING_DEGREE, AREA_OF_PRACTICE, LICENSE_NUMBER, ACHIEVEMENTS) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, doctor.getName());
			ps.setDate(3, new java.sql.Date(doctor.getDateOfBirth().getTime()));
			ps.setString(4, doctor.getGender());
			ps.setString(5, doctor.getQualifyingDegree());
			ps.setString(6, doctor.getAreaOfPractice());
			ps.setString(7, doctor.getLicenseNumber());
			ps.setString(8, doctor.getAchievements());
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
	public Doctor findByDoctorId(int doctorId) {
		String sql = "SELECT * FROM doctor WHERE DOCTOR_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);
			Doctor doctor = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				doctor = new Doctor(
					rs.getInt("DOCTOR_ID"),
					rs.getInt("USER_ID"),
					rs.getString("DOCTOR_NAME"),
					rs.getTimestamp("DATE_OF_BIRTH"),
					rs.getString("GENDER"),
					rs.getString("QUALIFYING_DEGREE"),
					rs.getString("AREA_OF_PRACTICE"),
					rs.getString("LICENSE_NUMBER"),
					rs.getString("ACHIEVEMENTS")
				);
			}
			rs.close();
			ps.close();
			return doctor;
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
	public Doctor findByUserId(int userId) {
		String sql = "SELECT * FROM doctor WHERE USER_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			Doctor doctor = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				doctor = new Doctor(
					rs.getInt("DOCTOR_ID"),
					rs.getInt("USER_ID"),
					rs.getString("DOCTOR_NAME"),
					rs.getTimestamp("DATE_OF_BIRTH"),
					rs.getString("GENDER"),
					rs.getString("QUALIFYING_DEGREE"),
					rs.getString("AREA_OF_PRACTICE"),
					rs.getString("LICENSE_NUMBER"),
					rs.getString("ACHIEVEMENTS")
				);
			}
			rs.close();
			ps.close();
			return doctor;
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
