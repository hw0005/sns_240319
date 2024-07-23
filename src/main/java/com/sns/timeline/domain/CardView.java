package com.sns.timeline.domain;

import java.util.List;

import com.sns.comment.domain.CommentView;
import com.sns.like.domain.Like;
import com.sns.post.entity.PostEntity;
import com.sns.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

// view 용 객체
// 글 1개와 매핑됨
@ToString
@Data
public class CardView {
	// 글 1개
	private PostEntity post; // 카드에 글 1개가 들어온 것과 같음.
	
	// 글쓴이 정보
	private UserEntity user; // 카드에 유저가 들어온 것과 같음.
	
	// 댓글 N개
	private List<CommentView> commentList;
	
	// 좋아요 N개
	private int likeCount;
	
	// 좋아요를 누른지 여부
	private boolean filledLike; // 채워졌으면 true 아니라면 false
	
}
