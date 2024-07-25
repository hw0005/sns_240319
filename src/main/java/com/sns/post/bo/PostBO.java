package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sns.comment.mapper.CommentMapper;
import com.sns.common.FileManagerService;
import com.sns.like.mapper.LikeMapper;
import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private LikeMapper likeMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	public List<PostEntity> getPostEntityList() {
		return postRepository.findByOrderByIdDesc();
	}
	
	public PostEntity addPost(int userId, String userLoginId, String content, MultipartFile file) {

		String imagePath = fileManagerService.uploadFile(file, userLoginId);
		
		return postRepository.save(
				PostEntity.builder()
				.userId(userId)
				.content(content)
				.imagePath(imagePath)
				.build());
	}
	
	
	@Transactional 
	public void deletePostByPostId(int postId, int userId) {
		// 기존 글 postId로 가져오기
		PostEntity post = postRepository.findById(postId).orElse(null);
		if (post == null) {
			log.error("[글 삭제]: postId:{}, userId:{}", postId, userId);
		}
		// 글 삭제
		postRepository.delete(post);
		// 이미지 삭제하기
		fileManagerService.deleteFile(post.getImagePath());
		
		// 댓글 Mapper에서 삭제
		commentMapper.deleteCommentByPostIdAndUserId(postId, userId);
		
		// 좋아요 Mapper에서 삭제
		likeMapper.deleteLikeByPostIdUserId(postId, userId);
	}
}

