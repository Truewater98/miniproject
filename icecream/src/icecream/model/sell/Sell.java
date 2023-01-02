package icecream.model.sell;

import icecream.model.preproduct.Preproduct;

public class Sell {
	private int productCode;
	private String productName;
	private int productPrice;
	private int customerCode;
	private String customerName;
	private int bonus;
	private int preKinds;
	private Preproduct[] prepros;
	private int index;
	private boolean SucAmountNPoint;
	
	
	
	public Sell() {
		index = 0;
	}


	public boolean isSucAmount() {
		return SucAmountNPoint;
	}

	public void setSucAmount(boolean SucAmountNPoint) {
		this.SucAmountNPoint = SucAmountNPoint;
	}

	public int getPreKinds() {
		return preKinds;
	}

	public void setPreKinds(int preKinds) {
		this.preKinds = preKinds;
		prepros = new Preproduct[preKinds];
	}
	
	public Preproduct getPrepro(int index) {
		return prepros[index];
	}
	
	public void setPrepros(int code, int amount) {
		if(index >= preKinds) {
			System.out.println("더 이상 추가할 수 없습니다. 초기화 후 사용해주세요.");
		}else {
			Preproduct prepro = new Preproduct();
			prepro.setProuductCode(code);
			prepro.setAmount(amount);
			prepros[index] = prepro;
			index++;
		}
	}
	
	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Preproduct[] getPrepros() {
		return prepros;
	}
		
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void initprepros() {
		index = 0;
		prepros = null;
	}
}
