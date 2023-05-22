package com.java4.popcorn.rankMovie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RankMovieController {
	@Autowired
	RankMovieDAO dao;
	
	// ��ȭ ��ü ��ũ ����Ʈ : ������
	@RequestMapping("rankMovie/movieRankAll")
	public void movieRank(PageVO vo, Model model) {
		vo.setStartEnd(vo.getPage());
		System.out.println("movieRank list����");
		List<RankMovieVO> list = dao.all(vo);
		int count = dao.count();
		System.out.println("all count>> " + count);
		int pages = count / 10 + 1; //��ü ������ ���� ���ϱ� 
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
	}
	
	@RequestMapping("rankMovie/movieRankList")
	public void userRankList(PageVO vo, Model model) {
		vo.setStartEnd(vo.getPage());
		List<RankMovieVO> list = dao.list(vo);
		model.addAttribute("list", list);
	}
	
	
	// ��õ ��ȭ ����Ʈ : ��ü ���
	@RequestMapping("rankMovie/recoMovie")
	public void movieReco(Model model) {
		System.out.println("movieReco list����");
		List<RankMovieVO> list = dao.recoList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("rankMovie/movieTop3")
	public void actorSelectOne(Model model) {
		RankMovieVO top1 = dao.selectTop(1);
		RankMovieVO top2 = dao.selectTop(2);
		RankMovieVO top3 = dao.selectTop(3);
		model.addAttribute("top1", top1);
		model.addAttribute("top2", top2);
		model.addAttribute("top3", top3);
	}
}