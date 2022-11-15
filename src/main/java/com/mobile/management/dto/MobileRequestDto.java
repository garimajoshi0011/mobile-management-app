package com.mobile.management.dto;

import com.mobile.management.entities.User;

public class MobileRequestDto {
	private User user;
	
	public MobileRequestDto() {
	}

	MobileRequestDto(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MobileRequestDto [user=" + user + "]";
	}

}
