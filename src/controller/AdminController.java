package controller;

import domain.MemberBean;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

import javax.swing.*;

public class AdminController {
	public void start() {
		MemberBean member= null;
		AdminService service = new AdminServiceImpl();  //다형성  타입이 다르면 다형성이라고 한다. : 부모꺼를 칭하고 불러오는건 자식.
		String ssn = "";
		int i = 0;
		while (true) { 
			switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.ID검색 3.이름검색 4.목록조회 5.등급조정 6.삭제")) {
			case "0":
				return;
			case "1": 
				member = new MemberBean();
				String[] strArr = JOptionPane.showInputDialog("id,이름").split(",");
				member.setUid(strArr[0]);
				member.setName(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, service.count()+"명 등록됨");
				//현재 회원수는 3명입니다.
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				if(service.count()==0){
					JOptionPane.showMessageDialog(null,"회원이 존재하지 않습니다.");
				}else{
					MemberBean[] arr = service.list();
					String result = "";
					for(;i<service.count();i++){
						result += arr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, result);
				}
				break;
			case "5":
				break;
			case "6":
				break;
			}
		}
	}

}
