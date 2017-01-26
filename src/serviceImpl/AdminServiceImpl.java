package serviceImpl;

import domain.MemberBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
	private MemberBean member; // 집합 하나는 하나의 요소를 여러번 넣어서 만들어 진다. 자료구조 컬렉션이다.
	private MemberBean[] arr;
	private int count;
	public AdminServiceImpl() {
		member = new MemberBean();
		arr = new MemberBean[count];
		count = 0;
	}
	@Override
	public void regist(MemberBean member) {
		// 회원정보를 입력한 후 배열에 저장하기
		if(count == arr.length){
			MemberBean[] temp = new MemberBean[count+10];
			System.arraycopy(arr, 0, temp, 0, count);
			arr=temp;
		}
			arr[count++]=member;
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberBean[] list() {
		// 전체목록 출력
		return arr;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public void changeRank(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
