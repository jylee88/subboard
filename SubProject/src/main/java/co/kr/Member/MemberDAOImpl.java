package co.kr.Member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlsession;

	@Override
	public void SignUp(MemberDTO memberDTO) {
		sqlsession.insert("SignUp",memberDTO);
	}
}
