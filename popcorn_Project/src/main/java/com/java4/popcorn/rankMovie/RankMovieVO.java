package com.java4.popcorn.rankMovie;

import lombok.Data;

@Data
public class RankMovieVO {
	private int rank_no;	// ��ȭ ����
	private double moviePopularity;	// ��ȭ �α⵵
	private int movieId;	// ��ȭ ���̵�
	private String movieTitle;	// ��ȭ ����
	private String movieGenre;	// ��ȭ �帣
	private String movieGrade;	// ��ȭ ����
	private String movieOpen;	// ��ȭ ������
	private String movieLast;	// ��ȭ ������ ����
	private String movieStory;	// ��ȭ �ٰŸ�
	private int movieTime;	// ��ȭ �� �ð�
	private String movieImg;	// ��ȭ �̹���
	private String movieActor;	// ��ȭ �⿬ ���
	private String movieDirector;	// ��ȭ ����
	private int movieLike;	// ��ȭ ���ƿ� ��
	private int movieHits;	// ��ȭ ��ȸ��
	private int movieReviews;	// ��ȭ ���� ��
}