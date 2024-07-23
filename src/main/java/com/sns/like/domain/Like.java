package com.sns.like.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Like {
	private int postId;
	private int userId;
	private LocalDateTime createdAt;
}
