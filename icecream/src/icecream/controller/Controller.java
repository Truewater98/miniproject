package icecream.controller;

import java.util.ArrayList;
import java.util.List;

import icecream.model.admin.Admin;
import icecream.model.admin.dao.AdminDAO;
import icecream.model.costomer.Customer;
import icecream.model.costomer.dao.CustomerDAO;
import icecream.model.event.Event;
import icecream.model.event.dao.EventDAO;
import icecream.model.preproduct.Preproduct;
import icecream.model.preproduct.dao.PreproductDAO;
import icecream.model.product.dao.ProductDAO;
import icecream.model.product.icecake.Icecake;
import icecream.model.product.icecake.dao.IcecakeDAO;
import icecream.model.product.icecream.Icecream;
import icecream.model.product.icecream.dao.IcecreamDAO;
import icecream.model.sell.Sell;

public class Controller {
	
	/**
	 * 전 고객 출력한 정보를 List에 담은걸 리턴
	 * @return List<Customer>
	 */
	public List<Customer> SelectAll(){
		CustomerDAO cDao = new CustomerDAO();
		List<Customer> cList =cDao.selectAll();
		return cList;
	}
	
	/**
	 * 입력받은 값을 코드와 이름으로 나눠 데이터베이스에서 꺼내 해당하는 고객들 정보 반환
	 * @param info
	 * @return List<customer>
	 */
	public List<Customer> selectCustomer(String info) {
		CustomerDAO cDao = new CustomerDAO();
		List<Customer> cList = null;
		if('0' <= info.charAt(0) && info.charAt(0) <= '9') {
			int num = Integer.parseInt(info);
			cList = new ArrayList<Customer>();
			 cList.add(cDao.selectOne(num));
		}else {
			 cList = cDao.selectSearch(info);
		}
		return cList;
	}
	
	/**
	 * 입력받은 customer DB에 입력하고 성공시 0이 아닌값 리턴
	 * @param customer
	 * @return int result
	 */
	public int register(Customer customer) {
		CustomerDAO cDao = new CustomerDAO();
		int result = cDao.register(customer);
		return result;
	}
	
	/**
	 * DAO를 호출해 admin 로그인 맞으면 0이 아닌 값 리턴
	 * @param admin
	 * @return int result
	 */
	public int login(Admin admin) {
		AdminDAO aDao = new AdminDAO();
		int result = aDao.login(admin);
		return result;
	}

	/**
	 * 입력받은 아이스크림 맛 DAO로 호출해 DB에 넣어줌 성공시 0제외 리턴
	 * @param flavor
	 * @return int result
	 */
	public int registIce(String flavor) {
		IcecreamDAO iDao = new IcecreamDAO();
		int result = iDao.regist(flavor);
		return result;
	}
	
	/**
	 * 입력받은 flavor DAO로 호출 DB에 접근 삭제함 성공시 0제외 리턴
	 * @param falvor
	 * @return int result
	 */
	public int deleteIce(String falvor) {
		IcecreamDAO iDao = new IcecreamDAO();
		int result = iDao.delete(falvor);
		return result;
	}
	/**
	 * 아이스 크림 전부 리스트에 담아서 리턴
	 * @return List<Icecream> iList
	 */
	public List<Icecream> allIcecream(){
		IcecreamDAO iDao = new IcecreamDAO();
		List<Icecream> iList = iDao.showAll();
		return iList;
	}

	/**
	 * Icecake에 들은 정보 DAO 호출해 DB에 저장 성공시 0이외 반환
	 * @param icecake
	 * @return int result
	 */
	public int registCake(Icecake icecake) {
		IcecakeDAO iDao = new IcecakeDAO();
		int result = iDao.registCake(icecake);
		return result;
	}
	/**
	 * 이름과 같은 아이스케이크 삭제 성공시 0이외 반환
	 * @param name
	 * @return int result
	 */
	public int deleteCake(String name) {
		IcecakeDAO iDao = new IcecakeDAO();
		int result = iDao.deleteCake(name);
		return result;
	}
	/**
	 * 모든 아이스케이크 List<icecake>에 담아 반환
	 * @return List<icecake> iList
	 */
	public List<Icecake> allShowcake() {
		IcecakeDAO iDao = new IcecakeDAO();
		List<Icecake> iList = iDao.allSelect();
		return iList;
	}

	/**
	 * 상품 db에 넣음 성공시 0이외
	 * @param preproduct
	 * @return int result
	 */
	public int registPre(Preproduct preproduct) {
		PreproductDAO pDao = new PreproductDAO();
		int result = pDao.registPre(preproduct);
		return result;
	}
	
	/**
	 * 상품 db에서 삭제 성공시 0이외
	 * @param name
	 * @return int 
	 */
	public int deletePre(String name) {
		PreproductDAO pDao = new PreproductDAO();
		int result = pDao.deletePre(name);
		return result;
	}
	
	/**
	 * 상품 전부 리스트에 담아 반환
	 * @return List<Preproduct>
	 */
	public List<Preproduct> showAllPre(){
		PreproductDAO pDao = new PreproductDAO();
		List<Preproduct> pList = pDao.showAllPre();
		return pList;
	}
	/**
	 * 배열에 받은 정보 dao호출해 db에 반영 해당멤버 등급 수정 성공시0이외 반환
	 * @param array
	 * @return int result
	 */
	public int updateMemberLevel(int[] array) {
		CustomerDAO cDao = new CustomerDAO();
		int result = cDao.updateMember(array);
		return result;
	}
	
	/**
	 * 입력받은 멤버 코드 멤버 삭제 성공시 0이외 반환
	 * @param code
	 * @return int result
	 */
	public int deleteMember(int code) {
		CustomerDAO cDao = new CustomerDAO();
		int result = cDao.delete(code);
		return result;
	}

	/**
	 * 입력받은 이벤트 정보 db에 등록 성공시 0이외의 값
	 * @param event
	 * @return int result
	 */
	public int registEvent(Event event) {
		EventDAO eDao = new EventDAO();
		int result = eDao.registEvent(event);
		return result;
	}
	/**
	 * 입력받은 코드 db에서 지움 성공시 0이외의 값
	 * @param code
	 * @return int result
	 */
	public int deleteEvent(int code) {
		EventDAO eDao = new EventDAO();
		int result = eDao.deleteEvent(code);
		return result;
	}
	
	/**
	 * DB에서 모든이벤트 꺼내옴
	 * @return List<event>
	 */
	public List<Event> showAllEvent(){
		EventDAO eDao = new EventDAO();
		List<Event> eList = eDao.showAllEvent();
		return eList;		
	}

	public int updatePreAmount(Preproduct preproduct) {
		PreproductDAO pDao = new PreproductDAO();
		int result = pDao.updateAmount(preproduct);
		return result;
	}
	
	public Sell sellProduct(Sell sell) {
		CustomerDAO cDao = new CustomerDAO();
		IcecakeDAO iDao = new IcecakeDAO();
		PreproductDAO prDao = new PreproductDAO();
		int procode = sell.getProductCode();
		Icecake icecake = iDao.oneSelect(procode);
		sell.setProductName(icecake.getProductName());
		sell.setProductPrice(icecake.getProductPrice());
		int cuscode = sell.getCustomerCode();
		Customer customer = cDao.selectOne(cuscode);
		sell.setCustomerName(customer.getMemberName());
		sell.setBonus(customer.getBonus());
		int bonus = customer.getBonus();
		int price = icecake.getProductPrice();
		int point = (int)((price * (bonus / 100f)));
		int result = cDao.plusPoint(sell.getCustomerCode(), point);
		int index = sell.getPreKinds();
		Preproduct[] prepros = sell.getPrepros();
		int result2 = prDao.minusAmount(index, prepros);
		sell.setSucAmount(result != 0 && result2 != 0);
		sell.setBonus((int)(price * (bonus / 100f)));
		return sell;
	}
}
