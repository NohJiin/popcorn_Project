package com.java4.popcorn.rankUser;


import com.java4.popcorn.rankActor.RankActorVO;
import com.java4.popcorn.rankMovie.RankMovieVO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankUserDAO {
//    @Autowired
//    GeneralDAO<RankUserVO> dao;
    
    @Autowired
    SqlSessionTemplate my;

    // rankUser ���̺� ���� �� member ���̺��� ������ insert
    public int userInsert() {
		int result = my.insert("RankUserDAO.userInsert");
		return result;
	}
    
    // ���ϴ� ������ ���� �������� (top 1, 2, 3)
    public RankUserVO selectTop(int rank_no) {
		RankUserVO bag = my.selectOne("RankUserDAO.selectTop", rank_no);
		return bag;
	}
    
    /* ����¡ */
    // ��ü ��� : ������
    public List<RankUserVO> all(PageVO vo) {
		List<RankUserVO> list = my.selectList("RankUserDAO.all", vo);
		return list;
	}
    
    public List<RankUserVO> list(PageVO vo) {
    	List<RankUserVO> list = my.selectList("RankUserDAO.list", vo);
    	return list;
    }
    
    // member ��ü ��
    public int count() {
		return my.selectOne("RankUserDAO.count");
	}
    
    /* ����¡ �� */
    
    // ���� ��� ���� ��õ �׸� �� �� 
    public List<RankUserVO> recoList() {
    	List<RankUserVO> list = my.selectList("RankUserDAO.recoAll");
    	return list;
    }

}