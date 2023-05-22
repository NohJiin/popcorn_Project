package com.java4.popcron.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

	@Autowired
	MypageDAO dao;
	
	//회원이 작성한 게시글
	@RequestMapping("mypage/mybbsAll")
	public void bbsList2(PageVO vo,Model model, HttpSession session) { 
		String member_id = (String)session.getAttribute("member_id"); //member_id 세션 값 잡아두기 - String으로 id 잡기!
		vo.setStartEnd(vo.getPage());
		vo.setMember_id(member_id);
		
		List<MypageVO> bbsAllList = dao.bbsAllList(vo);//member_id로 해당 list들 들고오기
		System.out.println("bbsList: "+bbsAllList);
		model.addAttribute("bbsAllList",bbsAllList);
	}
	
	//회원이 작성한 게시글(첫 페이지) + 리뷰(첫 페이지)
	//mypage 버튼 클릭시 바로 출력되는 controller
	@RequestMapping("mypage/mypage")
	public void bbsListFirst(PageVO vo,Model model, HttpSession session) {  
		String member_id = (String)session.getAttribute("member_id"); //member_id 세션 값 잡아두기 - String으로 id 잡기!
		vo.setStartEnd(vo.getPage()); 
		vo.setMember_id(member_id);
		System.out.println(vo);
		
		//bbs
		int bbsCount = dao.bbsCount(vo);//작성한 bbs 몇개인지 알기
		System.out.println("bbs all count: " + bbsCount);
		
		int bbsPages = bbsCount / 10 + 1; // bbs 10개씩 넣은 페이지 갯수
		System.out.println("bbs all pages: " + bbsPages);
		
		List<MypageVO> bbsAllList = dao.bbsAllList(vo);//member_id로 해당 list들 들고오기
		System.out.println("bbsList: "+bbsAllList);
		
		//review
		int reviewCount = dao.reviewCount(vo);//작성한 review 몇개인지 알기
		System.out.println("review all count: " + reviewCount);
		
		int reviewPages = reviewCount / 10 + 1; // bbs 10개씩 넣은 페이지 갯수
		System.out.println("review all pages: " + reviewPages);
		
		List<MypageVO> reviewAllList = dao.reviewAllList(vo);//member_id로 해당 list들 들고오기
		System.out.println("reviewList: "+ reviewAllList);
		
		//model에 넣어주자
		model.addAttribute("bbsAllList",bbsAllList);
		model.addAttribute("bbsCount",bbsCount);
		model.addAttribute("bbsPages",bbsPages);
		
		model.addAttribute("reviewAllList",reviewAllList);
		model.addAttribute("reviewCount",reviewCount);
		model.addAttribute("reviewPages",reviewPages);
	}
	
	
	//회원이 작성한 게시글(나머지 페이지를 처리)
	@RequestMapping("mypage/mybbs2")
	public void bbsListOther(PageVO vo,Model model, HttpSession session) {  
		String member_id = (String)session.getAttribute("member_id"); //member_id 세션 값 잡아두기 - String으로 id 잡기!
		vo.setStartEnd(vo.getPage()); 
		vo.setMember_id(member_id);
		System.out.println(vo);
		
		List<MypageVO> bbsAllList = dao.bbsAllList(vo);//member_id로 해당 list들 들고오기
		System.out.println("bbsList: "+bbsAllList);
		
		model.addAttribute("bbsAllList",bbsAllList);//model에 넣어주자
	}
	
	
	//회원이 작성한 리뷰(나머지 페이지를 처리)
	@RequestMapping("mypage/myreview2")
	public void reviewListOther(PageVO vo,Model model, HttpSession session) {  
		String member_id = (String)session.getAttribute("member_id"); //member_id 세션 값 잡아두기 - String으로 id 잡기!
		vo.setStartEnd(vo.getPage()); 
		vo.setMember_id(member_id);
		System.out.println(vo);
		
		List<MypageVO> reviewAllList = dao.reviewAllList(vo);//member_id로 해당 list들 들고오기
		System.out.println("reviewList: "+reviewAllList);
		
		model.addAttribute("reviewAllList",reviewAllList);//model에 넣어주자
	}
	
	//회원의 영화 찜목록
	public void movieJjim() {
		
	}
	
//	//마이페이지로 이동하기
//	@RequestMapping("mypage/mypageGO")
//	public String mypage() {
//		return "mypage/mypage";
//	}
	
}
