package com.green.car.wash.company.washer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.car.wash.company.washer.model.WasherProfile;

@Service
public interface WasherProfileService {

	public void updateDetails(WasherProfile details);
	public List<WasherProfile> getAllWashers();
	public void deleteById(String email);
	public List<WasherProfile> getWasher(String fullName);
}
