package com.mobile.management.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.management.dto.MobileResponseDto;
import com.mobile.management.entities.Mobile;
import com.mobile.management.entities.User;
import com.mobile.management.repositories.MobileRepository;
import com.mobile.management.repositories.UserMobileRepository;
import com.mobile.management.services.MobileManagementService;

@Service
public class MobileManagementServiceimpl implements MobileManagementService {

	@Autowired
	private UserMobileRepository userMobileRepository;

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public User placeUser(User user) {
		return userMobileRepository.save(user);
	}

	@Override
	public List<User> findAllUserMobiles() {
		return userMobileRepository.findAll();
	}

	@Override
	public List<MobileResponseDto> getAllMobileWithUser() {
		return userMobileRepository.getAllMobileWithUser();
	}
	
	@Override
	public List<MobileResponseDto> getAllMobileWithUser1(){
		List<User> users = userMobileRepository.findAll();
		List<MobileResponseDto> dto = new ArrayList<>();
		MobileResponseDto mobileDto;
		for(User user : users) {
			mobileDto = new MobileResponseDto();
			mobileDto.setName(user.getName());
			dto.add(mobileDto);
		}
		return dto;
	}

}
