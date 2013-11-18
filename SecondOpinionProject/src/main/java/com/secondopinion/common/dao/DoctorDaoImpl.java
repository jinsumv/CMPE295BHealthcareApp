package com.secondopinion.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.Review;
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
	
	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		String sql = "SELECT * FROM doctor WHERE AREA_OF_PRACTICE = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, speciality);
			List<Doctor> doctorList = new ArrayList<Doctor>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doctor = new Doctor(
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
				doctorList.add(doctor);
			}
			rs.close();
			ps.close();
			return doctorList;
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
	public void followDoctor(Patient patient, Doctor doctor) {
		String sql = "INSERT INTO follow_doctor (PATIENT_ID, DOCTOR_ID) VALUES (?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patient.getPatientId());
			ps.setInt(2, doctor.getDoctorId());
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
	public List<Doctor> getFollowedDoctors(int patientId) {
		String sql = "SELECT * FROM doctor WHERE DOCTOR_ID IN (SELECT DOCTOR_ID FROM follow_doctor WHERE PATIENT_ID=?)";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			List<Doctor> doctorList = new ArrayList<Doctor>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doctor = new Doctor(
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
				doctorList.add(doctor);
			}
			rs.close();
			ps.close();
			return doctorList;
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
	public int getFollowersCount(int doctorId) {
		String sql = "SELECT * FROM follow_doctor WHERE DOCTOR_ID=?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count ++;
			}
			rs.close();
			ps.close();
			return count;
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
	public void addReview(Review review) {
		String sql = "INSERT INTO review (PATIENT_ID, DOCTOR_ID, TEXT, REVIEW_DATE) VALUES (?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getPatientId());
			ps.setInt(2, review.getDoctorId());
			ps.setString(3, review.getText());
			ps.setTimestamp(4, new java.sql.Timestamp(review.getReviewDate().getTime()));
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
	public List<Review> getReviewsForDoctor(int doctorId) {
		String sql = "SELECT * FROM review WHERE DOCTOR_ID=? ORDER BY REVIEW_DATE ASC";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);
			List<Review> reviewList = new ArrayList<Review>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review(
					rs.getInt("REVIEW_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getInt("DOCTOR_ID"),
					rs.getString("TEXT"),
					rs.getTimestamp("REVIEW_DATE")
				);
				reviewList.add(review);
			}
			rs.close();
			ps.close();
			return reviewList;
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
