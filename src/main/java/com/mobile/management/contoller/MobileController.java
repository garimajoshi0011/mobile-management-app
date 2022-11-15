package com.mobile.management.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.management.dto.MobileRequestDto;
import com.mobile.management.dto.MobileResponseDto;
import com.mobile.management.entities.User;
import com.mobile.management.services.MobileManagementService;

@RestController
@RequestMapping("/mobilemanagement")
public class MobileController {

	@Autowired
	private MobileManagementService mobileService;
	
	@PostMapping("/add-user-mobile")
	public User placeOrder(@RequestBody MobileRequestDto request) {
		return mobileService.placeUser(request.getUser());
	}
	
	@GetMapping("/find-all-user-mobiles")
	public List<User> findAllUserMobiles(){
		return mobileService.findAllUserMobiles();
	}

	@GetMapping("/get-combine-user-mobiles")
	public List<MobileResponseDto> findCombineUserMobileInfo(){
		return mobileService.getAllMobileWithUser();
		  
	}
	
	@GetMapping("/get-combine-user-mobiles1")
	public List<MobileResponseDto> findCombineUserMobileInfo1(){
		return mobileService.getAllMobileWithUser1();
		  
	}
}
