package com.java4.popcorn.mypage;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MypageDAO {

	@Autowired
	SqlSessionTemplate my;


	
	//회원이 작성한 모든 게시글
	public List<MypageVO> bbsAllList(PageVO vo) { //member_id로 잡아오기
		List<MypageVO> bbsAllList = my.selectList("MypageDAO.myBbsAll", vo); //pageVO에 넣었으니 vo에서 꺼내기
		System.out.println("페이지에 보이는 bbs 갯수 : " + bbsAllList.size()); //bbs 갯수
		return  bbsAllList;
	}

	//회원이 작성한 모든 리뷰
	public List<MypageVO> reviewAllList(PageVO vo) { //member_id로 잡아오기
		List<MypageVO> reviewAllList = my.selectList("MypageDAO.myReviewAll", vo); //pageVO에 넣었으니 vo에서 꺼내기
		System.out.println("페이지에 보이는 review 갯수 : " + reviewAllList.size()); //bbs 갯수
		return  reviewAllList;
	}
	
	//회원이 작성한 게시글 갯수
	public int bbsCount(PageVO vo) {
		return my.selectOne("MypageDAO.myBbsCount",vo);
	}

	//회원이 작성한 리뷰 갯수
	public int reviewCount(PageVO vo) {
		return my.selectOne("MypageDAO.myReviewCount",vo);
	}
	
}
