package com.sns.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sns.comment.domain.Comment;

@Mapper
public interface CommentMapper {
	
	public void insertComment(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("content") String content);
	
	public List<Comment> selectCommentList();
	
	public List<Comment> selectCommentListByPostId(int postId);
	
	public void deleteCommentById(int id);
	
	public void deleteCommentByPostIdAndUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	
}
