package com.sns.comment.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
// 댓글 1개
public class Comment {
	private int id;
	private int postId;
	private int userId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
