package co.kr.Board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO; 
	
	//게시판
	@Override
	public List<BoardDTO> BoardList(Criteria criteria) {
		return boardDAO.BoardList(criteria);
	}

	//글 상세
	@Override
	public BoardDTO BoardDetail(int b_number) {
		
		return boardDAO.BoardDetail(b_number);
	}

	//글 작성
	@Override
	public void BoardRegister(BoardDTO boardDTO) {
		boardDAO.BoardRegister(boardDTO);
	}

	//글 삭제
	@Override
	public void BoardDelete(int b_number) {
		boardDAO.BoardDelete(b_number);
	}

	//글 수정
	@Override
	public void BoardUpdate(BoardDTO boardDTO) {
		boardDAO.BoardUpdate(boardDTO);
	}

	//조회수 증가
	@Override
	public void BoardReadCnt(int b_number) {
		boardDAO.BoardReadCnt(b_number);
	}

	@Override
	public int BoardTotalCount(Criteria criteria) {
		return boardDAO.BoardTotalCount(criteria);
	}

	@Override
	public void ReplyInsert(Reply reply) {
		boardDAO.ReplyInsert(reply);
	}

	@Override
	public List<Reply> ReplyView(int b_number) {
		return boardDAO.ReplyView(b_number);
	}
	
}
