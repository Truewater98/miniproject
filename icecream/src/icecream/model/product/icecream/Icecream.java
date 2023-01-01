package icecream.model.product.icecream;

public class Icecream {
	private int icecreamCode;
	private String icecreamName;
	
	public Icecream() {}

	public Icecream(int icecreamCode, String icecreamName) {
		this.icecreamCode = icecreamCode;
		this.icecreamName = icecreamName;
	}
	
	public int getIcecreamCode() {
		return icecreamCode;
	}
	public void setIcecreamCode(int icecreamCode) {
		this.icecreamCode = icecreamCode;
	}
	public String getIcecreamName() {
		return icecreamName;
	}
	public void setIcecreamName(String icecreamName) {
		this.icecreamName = icecreamName;
	}
	
	
}
