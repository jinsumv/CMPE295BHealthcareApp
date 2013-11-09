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

import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.PatientFile;
import com.secondopinion.common.model.PatientMedication;
import com.secondopinion.common.model.User;

@Component
public class PatientDaoImpl implements PatientDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void insert(User user, Patient patient) {
		String sql = "INSERT INTO patient " +
				"(USER_ID, PATIENT_NAME, DATE_OF_BIRTH, GENDER, LOCATION) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, patient.getName());
			ps.setDate(3, new java.sql.Date(patient.getDateOfBirth().getTime()));
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getLocation());
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
	public Patient findByPatientId(int patientId) {
		String sql = "SELECT * FROM patient WHERE PATIENT_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			Patient patient = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				patient = new Patient(
					rs.getInt("PATIENT_ID"),
					rs.getInt("USER_ID"),
					rs.getString("PATIENT_NAME"),
					rs.getTimestamp("DATE_OF_BIRTH"),
					rs.getString("GENDER"),
					rs.getString("LOCATION")
				);
			}
			rs.close();
			ps.close();
			return patient;
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
	public Patient findByUserId(int userId) {
		String sql = "SELECT * FROM patient WHERE USER_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			Patient patient = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				patient = new Patient(
					rs.getInt("PATIENT_ID"),
					rs.getInt("USER_ID"),
					rs.getString("PATIENT_NAME"),
					rs.getTimestamp("DATE_OF_BIRTH"),
					rs.getString("GENDER"),
					rs.getString("LOCATION")
				);
			}
			rs.close();
			ps.close();
			return patient;
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
	public void updatePatient(Patient patient) {
		String sql = "UPDATE patient " +
				"SET PATIENT_NAME=?, DATE_OF_BIRTH=?, GENDER=?, LOCATION=? " +
				"WHERE PATIENT_ID=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, patient.getName());
			ps.setDate(2, new java.sql.Date(patient.getDateOfBirth().getTime()));
			ps.setString(3, patient.getGender());
			ps.setString(4, patient.getLocation());
			ps.setInt(5, patient.getPatientId());
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
	public List<PatientMedication> fetchPatientMedications(int patientId) {
		String sql = "SELECT * FROM patient_medication WHERE PATIENT_ID = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			List<PatientMedication> medicationList = new ArrayList<PatientMedication>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PatientMedication medication = new PatientMedication(
					rs.getInt("MEDICATION_ID"),
					rs.getInt("PATIENT_ID"),
					rs.getString("MEDICATION_NAME"),
					rs.getString("NOTES")
				);
				medicationList.add(medication);
			}
			rs.close();
			ps.close();
			return medicationList;
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
	public void insertPatientMedication(Patient patient, PatientMedication patientMedication) {
		String sql = "INSERT INTO patient_medication " +
				"(PATIENT_ID, MEDICATION_NAME, NOTES) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patient.getPatientId());
			ps.setString(2, patientMedication.getMedicationName());
			ps.setString(3, patientMedication.getNotes());
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
	public void deletePatientMedication(int medicationId) {
		String sql = "DELETE FROM patient_medication " +
				"WHERE MEDICATION_ID=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, medicationId);
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
	public void insertPatientFile(Patient patient, PatientFile patientFile) {
		String sql = "INSERT INTO patient_file " +
				"(PATIENT_ID, FILE_NAME, DESCRIPTION, FILE_URL) VALUES (?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patient.getPatientId());
			ps.setString(2, patientFile.fileName);
			ps.setString(3, patientFile.description);
			ps.setString(4, patientFile.fileUrl);
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

}
