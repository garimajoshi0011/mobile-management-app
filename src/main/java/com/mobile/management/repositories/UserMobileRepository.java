package com.mobile.management.repositories;
import com.mobile.management.dto.MobileResponseDto;
import com.mobile.management.entities.User;
import com.mobile.management.entities.UserProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserMobileRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT new com.mobile.management.dto.MobileResponseDto(u.name, m.productName) FROM User u JOIN u.mobiles m")
	public List<MobileResponseDto> getAllMobileWithUser(); 
}