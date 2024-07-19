package com.sns.comment.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
	
	public void insertComment(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("content") String content);
	
	
}
