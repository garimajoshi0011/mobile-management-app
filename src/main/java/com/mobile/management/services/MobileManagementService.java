package com.mobile.management.services;


import java.util.List;

import com.mobile.management.dto.MobileResponseDto;
import com.mobile.management.entities.User;

public interface MobileManagementService {

    public User placeUser(User user);
    
    public List<User> findAllUserMobiles();
    
    public List<MobileResponseDto> getAllMobileWithUser();
    
    public List<MobileResponseDto> getAllMobileWithUser1();
}

