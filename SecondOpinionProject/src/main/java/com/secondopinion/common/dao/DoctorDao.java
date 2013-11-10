package com.secondopinion.common.dao;

import java.util.List;

import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.User;

public interface DoctorDao {
	public void insert(User user, Doctor doctor);
	public Doctor findByDoctorId(int doctorId);
	Doctor findByUserId(int userId);
	List<Doctor> findBySpeciality(String speciality);
}
