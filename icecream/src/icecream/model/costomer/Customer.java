package icecream.model.costomer;

import java.sql.Date;

public class Customer {
	private int memberCode;
	private String memberName;
	private String membershipName;
	private int point;
	private Date enterDate;
	private Date finalDate;
	private int bonus;
	
	public Customer() {}
	
	public Customer(int memberCode, String memberName, String membershipName, int point, Date enterDate, Date finalDate) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.membershipName = membershipName;
		this.point = point;
		this.enterDate = enterDate;
		this.finalDate = finalDate;
	}
	
	
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMembershipName() {
		return membershipName;
	}
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public Date getEnter_date() {
		return enterDate;
	}

	public void setEnter_date(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getFinal_date() {
		return finalDate;
	}

	public void setFinal_date(Date finalDate) {
		this.finalDate = finalDate;
	} 
	
	
}
