package com.java4.popcorn.rankActor;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankActorDAO {
    
    @Autowired
    SqlSessionTemplate my;

    /* ����¡ */
	// ��ü ��� : ������
    public List<RankActorVO> all(PageVO vo) {
    	List<RankActorVO> list = my.selectList("RankActorDAO.all", vo);
		return list;
	}
    
    public List<RankActorVO> list(PageVO vo) {
    	List<RankActorVO> list = my.selectList("RankActorDAO.list", vo);
    	return list;
    }
    
    // actor ��ü ��
    public int count() {
		return my.selectOne("RankActorDAO.count");
	}
    
    /* ����¡ �� */
    
    
    // �ϳ��� �˻� : rank_no = #{rank_no} �� �׸� ã�� ������
    public RankActorVO selectTop(int rank_no) {
    	RankActorVO bag = my.selectOne("RankActorDAO.selectTop", rank_no);
    	return bag;
    }
}