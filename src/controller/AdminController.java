package controller;

import domain.MemberBean;
import enums.Butt; //여러개 만들어도 된다.
import service.AdminService;
import serviceImpl.AdminServiceImpl;

import javax.swing.*;

public class AdminController {
	public void start() {
		MemberBean member= null;
		AdminService service = new AdminServiceImpl();  //다형성  타입이 다르면 다형성이라고 한다. : 부모꺼를 칭하고 불러오는건 자식.
		int i = 0;
		Butt[] buttens={Butt.CLOSE,Butt.MEM_ADD,Butt.FIND_BY_ID,Butt.FIND_BY_NAME,Butt.LIST,Butt.RANK,Butt.DELETE};
		Butt select = (Butt)JOptionPane.showInputDialog(
				null, //frame
				"PATTENT PAGE", // frame title
				"SELECT PATIENT MENU", //order
				JOptionPane.QUESTION_MESSAGE, //type
				null, // icon
				buttens, // Array of choices
				buttens[1] //default
				);
			switch (select) {
			case CLOSE:
				return;
			case MEM_ADD: 
				member = new MemberBean();
				String[] strArr = JOptionPane.showInputDialog("id,이름").split(",");
				member.setUid(strArr[0]);
				member.setName(strArr[1]);
				service.regist(member);
				JOptionPane.showMessageDialog(null, service.count()+"명 등록됨");
				//현재 회원수는 3명입니다.
				break;
			case FIND_BY_ID:
				String keyword = JOptionPane.showInputDialog("아이디를 입력하세요.");
				if(service.exist(keyword)){
					JOptionPane.showMessageDialog(null, service.findById(keyword).toString());
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않음.");
				}
				break;
			case FIND_BY_NAME:
				String temp = JOptionPane.showInputDialog("이름을 입력해주세요.");
				String name = "";
				if(service.countByName(temp)!=0){
					MemberBean[] temparr = service.findByName(temp);
					for(i=0;i<temparr.length;i++){
						name+=temparr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, name);
				}else{
					JOptionPane.showMessageDialog(null, "이름이 존재하지 않음.");
				}
				break;
			case LIST:
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
			case RANK:
				String temp2 = JOptionPane.showInputDialog("ID, RANK");
				String[] tempArr = temp2.split(",");
				member.setUid(tempArr[0]);
				member.setRank(tempArr[1]);
				service.changeRank(member);
				break;
			case DELETE:
				String delete = JOptionPane.showInputDialog("삭제할 아이디를 입력하세요.");
				if(service.exist(delete)){
					service.remove(delete);
					JOptionPane.showMessageDialog(null, "아이디가 삭제되었습니다.");
				}else{
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않음.");
				}
				break;
		}
	}

}
