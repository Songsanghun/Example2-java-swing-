package service;

import domain.MemberBean;

public interface MemberService {
	public void join(MemberBean member);  //regist해라 MemberBean 을
	public MemberBean findById(String id); // MemberBean 에서 find 해라 String id를 
	public boolean login(MemberBean member); // login해라 Member member을 참 거짓 구별.
	public void change(MemberBean member); //change해라 MemberBean을
	public void remove(MemberBean member); //remove해라 MemberBean을
	
	
}
