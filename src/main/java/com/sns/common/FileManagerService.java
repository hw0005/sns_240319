package com.sns.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	
	public static final String FILE_UPLOAD_PATH = "D:\\윤현우\\6_SPRING_PROJECT\\sns\\sns_workspace\\images/";
	
	// input: file, userLoginId
	// output: String(이미지 경로)
	
	public String uploadFile(MultipartFile file, String userLoginId) {
		// 폴더 생성(directory)
		// 예: aaaa_241235123/XXX.jpg
		String directoryName = userLoginId + "_" + System.currentTimeMillis();
		
		// D:\\윤현우\\6_SPRING_PROJECT\\sns\\sns_workspace\\images/aaaa_241235123/
		String filePath = FILE_UPLOAD_PATH + directoryName + "/";
		
		// 폴더 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성시 실패하면 경로를 null로 리턴
			return null;
		}
		
		// 파일 업로드
		try {
			byte[] bytes = file.getBytes();
			// ★★★★★★★ 한글명으로 된 이미지는 업로드 불가하므로 나중에 영문자로 바꾸기
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 이미지 업로드 실패시 경로 null
		}
		
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
	}
}
