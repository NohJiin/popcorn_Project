package com.java4.popcorn.rankMovie;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	// �̱��� ����
public class RankMovieDAO {
	@Autowired
	SqlSessionTemplate my;
	
	/* ����¡ */
	// ��ü ��� : ������
	public List<RankMovieVO> all(PageVO vo) {
		List<RankMovieVO> list = my.selectList("RankMovieDAO.all", vo);
		return list;
	}
	
	public List<RankMovieVO> list(PageVO vo) {
		List<RankMovieVO> list = my.selectList("RankMovieDAO.list", vo);
		return list;
	}
	
	// movie ��ü ��
    public int count() {
		return my.selectOne("RankMovieDAO.count");
	}
    
	/* ����¡ �� */
	
	// ��ü ��� ��������
	public List<RankMovieVO> recoList() {
		System.out.println("list DAO����");
		List<RankMovieVO> list = my.selectList("RankMovieDAO.recoAll");
		
		return list;
	}
	
	// �ϳ��� �˻� : rank_no = #{rank_no} �� �׸� ã�� ������
	public RankMovieVO selectTop(int rank_no) {
		RankMovieVO bag = my.selectOne("RankMovieDAO.selectTop", rank_no);
		return bag;
	}
	
}