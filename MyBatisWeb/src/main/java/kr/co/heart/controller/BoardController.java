package kr.co.heart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.heart.domain.BoardDto;
import kr.co.heart.domain.PageResolver;
import kr.co.heart.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//2022.11.08 삭제추가
	@PostMapping("/remove")
	public String remove(Integer bno, Integer page, Integer pageSize, RedirectAttributes rattr, HttpSession session) {
	      	String writer = (String) session.getAttribute("id");
	        
	      	String msg = "DEL_OK";

	        try {
	            if(boardService.remove(bno, writer) != 1)
	                throw new Exception("Delete failed.");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            msg = "DEL_ERR";
	        }

	        //삭제 후 메시지가 한번만 나와야 한다. Model이 아닌 RedirectAtributes에 저장하면 메시지가 한번만 나온다.
	        //addFlashAttribute() : 한번 저장하고 없어지는 것이다. 세션에 잠깐 저장했다가 한번 쓰고 지워버린다. 세션에도 부담이덜하다.
	        rattr.addAttribute("page", page);
	        rattr.addAttribute("pageSize", pageSize);
	        rattr.addFlashAttribute("msg", msg);

	        return "redirect:/board/list";
	    }
	
	//2022.11.08 읽기추가
	@GetMapping("/read")
	public String read(Integer bno, Integer page, Integer pageSize, Model m) {
		try {
			BoardDto boardDto = boardService.read(bno);
			//m.addAttribute("boardDto", boardDto); //아래에 있는 문장과 동일
			m.addAttribute(boardDto);	// 뷰에서 확인해주려고 모델에 저장 
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/list";
		}
		
		return "board";
	}
	
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page, 
					   @RequestParam(defaultValue = "10") Integer pageSize,
						Model m,
						HttpServletRequest request) {
		
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		try {
			
//			if(page==null) page=1;
//			if(pageSize==null) pageSize=10;
			
			int totalcnt = boardService.getCount();
			m.addAttribute("totalcnt", totalcnt);
			
			PageResolver pageResolver = new PageResolver(totalcnt, page, pageSize);
			if(page < 0 || page > pageResolver.getTotalCnt()) {
				page = 1;
			}
			if (pageSize < 0 || pageSize > 50) {
				pageSize = 10;
			}
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
			
			List<BoardDto> list = boardService.getPage(map);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardList";				// 로그인 한 상태, 게시판 목록 화면으로 이동
		
	}

	private boolean loginCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 1. 세션을 얻어서
		HttpSession session = request.getSession(false);				//false 는 session 이 없어도 새로 생성하지 않음. 반환값 null
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session != null && session.getAttribute("id") != null;
	}
	
	
	

}
