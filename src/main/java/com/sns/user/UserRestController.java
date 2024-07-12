package com.sns.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	// 중복확인 API, AJXA, JSON => Map
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId() {
		
		// db 조회
		UserEntity user = 
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		
		
		return result;
	}
	
	
}
