package co.kr.Member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

public interface MemberService {
	
	public void SignUp(MemberDTO memberDTO);
	
}
