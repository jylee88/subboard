package co.kr.Controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.Member.MemberDTO;
import co.kr.Member.MemberService;

@Controller
public class MemberController {
	@Inject
	private MemberService memberservice;
	
	@RequestMapping(value = "Member/SignUp", method = RequestMethod.GET)
	public String SignUp() {
		
		return "Member/SignUp";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void SignUp(MemberDTO memberDTO) {
		memberservice.SignUp(memberDTO);
	}
}
