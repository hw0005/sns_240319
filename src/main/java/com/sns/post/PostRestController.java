package com.sns.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sns.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostBO postBO;

	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam(value ="content", required = false) String content,
			@RequestParam("file") MultipartFile file,
			HttpSession session) {
		// 글쓴이 번호를 session에서 꺼낸다 => 비로그인 시 에러
		Integer userId = (Integer)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		if (userId != null) {
			result.put("code", 403);
			result.put("result", "로그인 되지 않았습니다.");
		}
		// DB insert
		postBO.addPost(userId, userLoginId, content, file);
		
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
		
	}
}
