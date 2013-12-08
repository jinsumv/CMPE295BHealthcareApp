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
import com.secondopinion.common.model.Conversation;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.DoctorDetails;
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
	public Doctor getNewDoctor() {
		String sql = "SELECT * FROM doctor ORDER BY DOCTOR_ID DESC LIMIT 1";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public void insertDoctorDetails(Doctor doctor) {
		String sql = "INSERT INTO doctor_detail (DOCTOR_ID, AREA_OF_PRACTICE_NAME, AREA_OF_PRACTICE_DETAILS, SPECIAL_HONORS_1, SPECIAL_HONORS_2, SPECIAL_HONORS_3, PRACTICE_NAME, PRACTICE_ADDRESS, PRACTICE_CITY, "+ 
				"PRACTICE_STATE, PRACTICE_ZIP, PRACTICE_HOURS1, PRACTICE_HOURS2, WEBSITE, RESIDENCIES1, RESIDENCIES2, RESIDENCIES3, MEDICAL_SCHOOL1, MEDICAL_SCHOOL2, MEDICAL_SCHOOL3, AFFILIATIONS1, AFFILIATIONS2, AFFILIATIONS3) "+ 
				"VALUES (?, '','','','','','','','','','','','','','','','','','','','','','')";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctor.getDoctorId());
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
	public List<Doctor> findByName(String doctorname) {
		String sql = "SELECT * FROM doctor WHERE DOCTOR_NAME COLLATE UTF8_GENERAL_CI LIKE ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + doctorname + "%");
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
		String sql = "INSERT INTO review (PATIENT_ID, DOCTOR_ID, TEXT, REVIEW_DATE, RATING) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getPatientId());
			ps.setInt(2, review.getDoctorId());
			ps.setString(3, review.getText());
			ps.setTimestamp(4, new java.sql.Timestamp(review.getReviewDate().getTime()));
			ps.setInt(5, review.getRate());
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
					rs.getTimestamp("REVIEW_DATE"),
					rs.getInt("RATING")
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

	@Override
	public void updateDoctorBiography(DoctorDetails doctorDetails) {
		String sql = "UPDATE doctor_detail SET AREA_OF_PRACTICE_NAME=?, AREA_OF_PRACTICE_DETAILS=?, SPECIAL_HONORS_1=?, SPECIAL_HONORS_2=?, SPECIAL_HONORS_3=? "+ 
				"WHERE DOCTOR_ID=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctorDetails.getAreaOfPracticeName());
			ps.setString(2, doctorDetails.getAreaOfPracticeDetails());
			ps.setString(3, doctorDetails.getSpecialHonors1());
			ps.setString(4, doctorDetails.getSpecialHonors2());
			ps.setString(5, doctorDetails.getSpecialHonors3());
			ps.setInt(6, doctorDetails.getDoctorId());
			System.out.println(ps);
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
	public void updateDoctorPracticeInformation(DoctorDetails doctorDetails) {
		String sql = "UPDATE doctor_detail SET PRACTICE_NAME=?, PRACTICE_ADDRESS=?, PRACTICE_CITY=?, "+ 
				"PRACTICE_STATE=?, PRACTICE_ZIP=?, PRACTICE_HOURS1=?, PRACTICE_HOURS2=?, WEBSITE=? "+ 
				"WHERE DOCTOR_ID=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctorDetails.getPracticeName());
			ps.setString(2, doctorDetails.getPracticeAddress());
			ps.setString(3, doctorDetails.getPracticeCity());
			ps.setString(4, doctorDetails.getPracticeState());
			ps.setString(5, doctorDetails.getPracticeZip());
			ps.setString(6, doctorDetails.getPracticeHours1());
			ps.setString(7, doctorDetails.getPracticeHours2());
			ps.setString(8, doctorDetails.getWebsite());
			ps.setInt(9, doctorDetails.getDoctorId());
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
	public void updateDoctorEducation(DoctorDetails doctorDetails) {
		String sql = "UPDATE doctor_detail SET RESIDENCIES1=?, RESIDENCIES2=?, RESIDENCIES3=?, MEDICAL_SCHOOL1=?, "
				+ "MEDICAL_SCHOOL2=?, MEDICAL_SCHOOL3=?, AFFILIATIONS1=?, AFFILIATIONS2=?, AFFILIATIONS3=? "+ 
				"WHERE DOCTOR_ID=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctorDetails.getResidencies1());
			ps.setString(2, doctorDetails.getResidencies2());
			ps.setString(3, doctorDetails.getResidencies3());
			ps.setString(4, doctorDetails.getMedicalSchool1());
			ps.setString(5, doctorDetails.getMedicalSchool2());
			ps.setString(6, doctorDetails.getMedicalSchool3());
			ps.setString(7, doctorDetails.getAffiliations1());
			ps.setString(8, doctorDetails.getAffiliations2());
			ps.setString(9, doctorDetails.getAffiliations3());
			ps.setInt(10, doctorDetails.getDoctorId());
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
	public DoctorDetails getDoctorDetails(int doctorId) {
		String sql = "SELECT * FROM doctor_detail WHERE DOCTOR_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);
			DoctorDetails doctorDetails = new DoctorDetails();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				doctorDetails.setDoctorId(rs.getInt("DOCTOR_ID"));
				doctorDetails.setAreaOfPracticeName(rs.getString("AREA_OF_PRACTICE_NAME"));
				doctorDetails.setAreaOfPracticeDetails(rs.getString("AREA_OF_PRACTICE_DETAILS")); 
				doctorDetails.setSpecialHonors1(rs.getString("SPECIAL_HONORS_1")); 
				doctorDetails.setSpecialHonors2(rs.getString("SPECIAL_HONORS_2")); 
				doctorDetails.setSpecialHonors3(rs.getString("SPECIAL_HONORS_3")); 
				doctorDetails.setPracticeName(rs.getString("PRACTICE_NAME")); 
				doctorDetails.setPracticeAddress(rs.getString("PRACTICE_ADDRESS")); 
				doctorDetails.setPracticeCity(rs.getString("PRACTICE_CITY")); 
				doctorDetails.setPracticeState(rs.getString("PRACTICE_STATE")); 
				doctorDetails.setPracticeZip(rs.getString("PRACTICE_ZIP")); 
				doctorDetails.setPracticeHours1(rs.getString("PRACTICE_HOURS1")); 
				doctorDetails.setPracticeHours2(rs.getString("PRACTICE_HOURS2")); 
				doctorDetails.setWebsite(rs.getString("WEBSITE")); 
				doctorDetails.setResidencies1(rs.getString("RESIDENCIES1")); 
				doctorDetails.setResidencies2(rs.getString("RESIDENCIES2")); 
				doctorDetails.setResidencies3(rs.getString("RESIDENCIES3")); 
				doctorDetails.setMedicalSchool1(rs.getString("MEDICAL_SCHOOL1")); 
				doctorDetails.setMedicalSchool2(rs.getString("MEDICAL_SCHOOL2")); 
				doctorDetails.setMedicalSchool3(rs.getString("MEDICAL_SCHOOL3")); 
				doctorDetails.setAffiliations1(rs.getString("AFFILIATIONS1")); 
				doctorDetails.setAffiliations2(rs.getString("AFFILIATIONS2")); 
				doctorDetails.setAffiliations3(rs.getString("AFFILIATIONS3"));
			}
			rs.close();
			ps.close();
			return doctorDetails;
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
