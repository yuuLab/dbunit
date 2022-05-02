package com.yuuLab.springLab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuuLab.springLab.controller.request.AppUserSaveRequest;
import com.yuuLab.springLab.controller.response.AppUserSaveResponse;
import com.yuuLab.springLab.logic.AppUserSaveLogic;
import com.yuuLab.springLab.logic.dto.input.AppUserSaveInput;

@RestController
public class AppUserSaveController {
	
	protected final AppUserSaveLogic appUserSaveLogic;
	
	@Autowired
	public AppUserSaveController(AppUserSaveLogic appUserSaveLogic) {
		this.appUserSaveLogic = appUserSaveLogic;
	}
	
	
	
	@PostMapping(value="/user")
	public AppUserSaveResponse saveAppUser(@RequestBody AppUserSaveRequest request ) {
		
		AppUserSaveInput input = AppUserSaveInput.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.telNumber(request.getTelNumber())
				.build();
		
		String userId = this.appUserSaveLogic.saveAppUser(input);
		
		return AppUserSaveResponse.builder().userId(userId).build();
	}
}
