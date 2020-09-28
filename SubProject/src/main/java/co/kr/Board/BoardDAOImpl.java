package co.kr.Board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlsession;
	
	//게시판 
	@Override
	public List<BoardDTO> BoardList(Criteria criteria) {
		return sqlsession.selectList("BoardList",criteria);
	}

	//글 상세
	@Override
	public BoardDTO BoardDetail(int b_number) {
		
		return sqlsession.selectOne("BoardDetail", b_number);
	}

	//글 작성
	@Override
	public void BoardRegister(BoardDTO boardDTO) {
		sqlsession.insert("BoardRegister",boardDTO);
	}

	//글 삭제
	@Override
	public void BoardDelete(int b_number) {
		sqlsession.update("BoardDelete", b_number);
	}

	//글 수정
	@Override
	public void BoardUpdate(BoardDTO boardDTO) {
		sqlsession.update("BoardUpdate", boardDTO);
	}
	//조회수 증가
	@Override
	public void BoardReadCnt(int b_number) {
		sqlsession.update("BoardReadCnt",b_number);
	}

	//게시판 토탈 카운팅
	@Override
	public int BoardTotalCount(Criteria criteria) {
		return sqlsession.selectOne("BoardTotalCount", criteria);
	}

	@Override
	public void ReplyInsert(Reply reply) {
		sqlsession.insert("ReplyInsert",reply);
	}

	@Override
	public List<Reply> ReplyView(int b_number) {
		return sqlsession.selectList("ReplyView", b_number);
	}

}
