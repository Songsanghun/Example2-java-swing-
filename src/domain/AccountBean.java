package domain;

public class AccountBean {
	
	protected String uid , accountType, createDate ,money , accountNo;
	
	public void setMoney(String money){
		this.money = money;
	}
	public String getMoney(){
		return money;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setuid(String uid){
		this.uid = uid;
	}
	public String getUid(){
		return uid;
	}
	public void setAccountType(String accountType){
		this.accountType = accountType;
	}
	public String getAccountType(){
		return accountType;
	}
	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}
	public String getAccountNo(){
		return accountNo;
	}
	@Override
	public String toString() {
		return String.format("%d [%s] %s %s ￦%d", 
				accountNo,
				accountType,
				uid,
				createDate,
				money
				);
	}
	
}	
