package co.kr.Member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void SignUp(MemberDTO memberDTO) {
		memberDAO.SignUp(memberDTO);
	}
	
}
