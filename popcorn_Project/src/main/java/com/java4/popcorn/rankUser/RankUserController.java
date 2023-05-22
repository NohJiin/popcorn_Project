package com.java4.popcorn.rankUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RankUserController {
	@Autowired
	RankUserDAO dao;
	
//	@RequestMapping("rankUser/userInsert")
//	public void userInsert() {
//		System.out.println("userInsert ����");
//		int result = dao.userInsert();
//		System.out.println(result + "�� �߰���");
//	}
	
	// ��ü��� : ������
	@RequestMapping("rankUser/userRankAll")
	public void userRankAll(PageVO vo, Model model) {
		// member�� ȸ���� �߰��Ǹ� rankuser ���̺��� �߰��ǵ��� ��
		int result = dao.userInsert();
		System.out.println(result + "�� �߰���");
		
		vo.setStartEnd(vo.getPage());
		System.out.println("userRank list����");
		List<RankUserVO> list = dao.all(vo);
		int count = dao.count();
		System.out.println("all count>> " + count);
		int pages = count / 10 + 1; //��ü ������ ���� ���ϱ� 
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
	}
	
	@RequestMapping("rankUser/userRankList")
	public void userRankList(PageVO vo, Model model) {
		vo.setStartEnd(vo.getPage());
		List<RankUserVO> list = dao.list(vo);
		model.addAttribute("list", list);
	}
	
	
	// ��õ ����� ����Ʈ : ��ü ���
	@RequestMapping("rankUser/recoUser")
	public void userReco(Model model) {
		System.out.println("userReco list����");
		List<RankUserVO> list = dao.recoList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("rankUser/userTop3")
	public void selectTop(Model model) {
		RankUserVO top1 = dao.selectTop(1);	// 1��
		RankUserVO top2= dao.selectTop(2);	// 2��
		RankUserVO top3 = dao.selectTop(3);	// 3��
		model.addAttribute("top1", top1);
		model.addAttribute("top2", top2);
		model.addAttribute("top3", top3);
	}
}