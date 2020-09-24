package co.kr.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.Board.BoardDAO;
import co.kr.Board.BoardDTO;
import co.kr.Board.BoardService;
import co.kr.Board.Criteria;
import co.kr.Board.PageMaker;
import co.kr.Board.Reply;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardservice;
	
	//자유게시판
	@RequestMapping(value = "Board/BoardList" , method = RequestMethod.GET)
	public String BoardList(Model model, String b_code, Criteria criteria){
		
		PageMaker pagemaker = new PageMaker();
		int boardTotalCnt = boardservice.BoardTotalCount(b_code);

		criteria.setB_code(b_code);
		criteria.setStart(criteria.getPage());
		
		List<BoardDTO> board = boardservice.BoardList(criteria);
		
		
		pagemaker.setCriteria(criteria);
		pagemaker.makePageNum(boardTotalCnt);
		
		
		model.addAttribute("BoardList", board);
		model.addAttribute("b_code", b_code);
		model.addAttribute("pagemaker", pagemaker);
		
		return "Board/"+ b_code +"Board";
	}
	
	//글 상세보기
	@RequestMapping(value = "Board/boardDetail", method = RequestMethod.GET)
	public String BoardDetail(int b_number, Model model) {
		BoardDTO boardDTO = boardservice.BoardDetail(b_number);
		boardservice.BoardReadCnt(b_number);
		
		model.addAttribute("BoardDetail", boardDTO);
		return "Board/BoardDetail";
	}
	
	//글작성 GET
	@RequestMapping(value = "Board/boardRegister", method = RequestMethod.GET)
	public String BoardRegister(Model model,String b_code) {
		model.addAttribute("b_code", b_code);
		return "Board/BoardRegister";
	}
	
	//글작성 POST
	@RequestMapping(value = "Board/boardRegister", method = RequestMethod.POST)
	public String BoardRegister(BoardDTO boardDTO) {
		boardservice.BoardRegister(boardDTO);
		
		return "redirect:BoardList?b_code="+boardDTO.getB_code();
	}
	
	//글 삭제
	@RequestMapping(value = "Board/boardDelete", method = RequestMethod.GET)
	public String BoardDelete(int b_number, String b_code) {
		
		boardservice.BoardDelete(b_number);
		
		return "redirect:BoardList?b_code="+b_code;
	}
	
	//글 수정
	@RequestMapping(value = "Board/boardUpdate", method = RequestMethod.GET)
	public String BoardUpdate(int b_number,Model model) {
		BoardDTO boardDTO = boardservice.BoardDetail(b_number);
		model.addAttribute("BoardUpdate", boardDTO);
		return "Board/BoardUpdate";
	}
	
	//글 수정
	@RequestMapping(value = "Board/boardUpdate", method = RequestMethod.POST)
	public String BoardUpdate(BoardDTO boardDTO) {
		boardservice.BoardUpdate(boardDTO);
		
		return "redirect:boardDetail?b_number="+boardDTO.getB_number();
	}
	
	////////////////////////////////////////reply
	//댓글 보기
	@ResponseBody
	@RequestMapping(value = "Board/replyView", method = RequestMethod.POST)
	public List<Reply> replyView(int b_number) {

		return boardservice.ReplyView(b_number);
	}
	
	//댓글 작성
	@ResponseBody
	@RequestMapping(value = "Board/replyInsert", method = RequestMethod.POST)
	public void replyInsert(Reply reply) {
		boardservice.ReplyInsert(reply);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
