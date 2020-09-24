package co.kr.Board;

import java.util.List;

public interface BoardDAO {
	//게시판
	public List<BoardDTO> BoardList(Criteria criteria);
	//게시판 게시글 카운팅
	public int BoardTotalCount(String b_code);
	//글 상세
	public BoardDTO BoardDetail(int b_number);
	//조회수 증가
	public void BoardReadCnt(int b_number);
	//글 작성
	public void BoardRegister(BoardDTO boardDTO);
	//글 삭제
	public void BoardDelete(int b_number);
	//글 수정
	public void BoardUpdate(BoardDTO boardDTO);
	
	///////////////////////////////////reply
	//댓글 작성
	public void ReplyInsert(Reply reply);
	//댓글 보기
	public List<Reply> ReplyView(int b_number);
}
