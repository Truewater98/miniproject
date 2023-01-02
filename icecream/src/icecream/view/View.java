package icecream.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import icecream.model.admin.Admin;
import icecream.model.costomer.Customer;
import icecream.model.event.Event;
import icecream.model.preproduct.Preproduct;
import icecream.model.product.icecake.Icecake;
import icecream.model.product.icecream.Icecream;
import icecream.model.sell.Sell;

public class View {
	
	/**
	 * 메인메뉴 출력후 번호 입력받고 리턴
	 * @return int choice
	 */
	public int Mainmenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 메인 메뉴 ===");
		System.out.println("1. 상품판매");
		System.out.println("2. 재고관리");
		System.out.println("3. 이벤트 확인");
		System.out.println("4. 고객관리");
		System.out.println("5. 관리자 메뉴");
		System.out.println("0. 종료");
		System.out.print(">> ");
		int choice = sc.nextInt();
		return choice;		
	}
	
	/**
	 * 메인메뉴 출력후 번호 입력받고 리턴
	 * @return int choice
	 */
	public int customerMenu() {
		Scanner sc = new Scanner(System.in);{
			System.out.println("=== 고객 관리 메뉴 ===");
			System.out.println("1. 고객 전체출력");
			System.out.println("2. 고객 검색");
			System.out.println("3. 회원가입");
			System.out.print(">>");
			int choice = sc.nextInt();
			return choice;
		}
	}
	
	/**
	 * 어드민 메뉴 출력후 번호 입력받고 리턴
	 * @return int choice
	 */
	public int adminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 상품등록 삭제");
		System.out.println("2. 고객정보 변경, 삭제");
		System.out.println("3. 이벤트 등록, 삭제");
		System.out.print(">>");
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * 고객 관리 메뉴 출력후 번호 입력받고 리턴
	 * @return
	 */
	public int fixCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 고객 등급 변경");
		System.out.println("2. 고객 정보 삭제");
		System.out.print(">>");
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * 상품 추가 제거 메뉴 출력 후 번호 입력받고 리턴
	 * @return int choice
	 */
	public int managingProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 맛 등록");
		System.out.println("2. 맛 삭제");
		System.out.println("3. 맛 전체 출력");
		System.out.println("4. 케이크 등록");
		System.out.println("5. 케이크 삭제");
		System.out.println("6. 케이크 전체 출력");
		System.out.println("7. 이벤트 상품, 증정품 등록");
		System.out.println("8. 이벤트 상품, 증정품 삭제");
		System.out.println("9. 이벤트 상품, 증정품 전체 출력");
		System.out.print(">>"); 
		int choice = sc.nextInt();
		return choice;
	}
	
	/**
	 * 입력받은 리스트에 Customer정보 전체출력
	 * @param cList
	 */
	public void showAll(List<Customer> cList) {
		System.out.println("=== 고객 정보 출력 ===");
		for(Customer cOne : cList) {
			System.out.print("번호 : " + cOne.getMemberCode() + ", ");
			System.out.print("이름 : " + cOne.getMemberName() + ", ");
			System.out.print("멤버쉽 등급 : " + cOne.getMembershipName() + ", ");
			System.out.print("포인트 : " + cOne.getPoint() + ", ");
			System.out.print("가입 일 : " + cOne.getEnter_date() + ", ");
			System.out.println("마지막 방문 일 : " + cOne.getFinal_date());
		}
	}
	
	/**
	 * 고객의 이름이나 고객 번호를 입력받아 리턴
	 * @return String info
	 */
	public String inputCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("고객코드 혹은 이름");
		System.out.print("찾을 고객 정보 입력 : ");
		String info = sc.next();
		return info;
	}
	
	/**
	 * 회원가입 이름이랑 코드입력
	 * @return Customer
	 */
	public Customer registCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 회원 가입 ===");
		System.out.print("멤버쉽 코드 입력(핸드폰번호 추천) : ");
		int code = sc.nextInt();
		System.out.print("고객 이름 입력 : ");
		String name = sc.next();
		Customer customer = new Customer();
		customer.setMemberCode(code);
		customer.setMemberName(name);
		return customer;
	}
		
	/**
	 * 아이디 비밀번호를 입력받고 admin객체 생성후 입력받은 정보 넣고 리턴
	 * @return Admin admin
	 */
	public Admin login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("관리자 아이디 입력 : ");
		String id = sc.next();
		System.out.print("관리자 비밀번호 입력 : ");
		String password = sc.next();
		Admin admin = new Admin();
		admin.setId(id);
		admin.setPassword(password);
		return admin;
	}

	/**
	 * str할 아이스크림 맛 입력 후 리턴
	 * @param str
	 * @return string flavor
	 */
	public String managingIceCream(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + "하실 아이스크림 맛 : ");
		String flavor = sc.next();
		return flavor;
	}

	/**
	 * 0아니면 성공 0이면 실패 str에 성공or실패 하셨습니다 출력
	 * @param result
	 * @param str1
	 */
	public void judge(int result, String str1) {
		if(result !=0) {
			System.out.println(str1 + "에 성공하셨습니다.");
		}else {
			System.out.println(str1 +"에 실패하셨습니다.");
		}
	}
	
	/**
	 * List안에 맛 전체 출력
	 * @param iList
	 */
	public void allIcecream(List<Icecream> iList) {
		System.out.println("=== 전체 맛 출력 ===");
		for(Icecream iOne : iList) {
			System.out.print("아이스크림 코드 : " + iOne.getIcecreamCode()+ ", ");
			System.out.println("아이스크림 맛 : " + iOne.getIcecreamName());
		}
	}

	/**
	 * 신규 케이크 등록 코드,이름,가격 입력받고 Icecake에 담음
	 * @return Icecake icecake
	 */
	public Icecake registCake() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 신규 케이크 등록 ===");
		System.out.print("케이크 코드 입력(자동으로 10 더해짐) : ");
		int code = sc.nextInt();
		System.out.print("케이크 이름 입력 : ");
		String name = sc.next();
		System.out.print("케이크 가격 입력 : ");
		int price = sc.nextInt();
		Icecake icecake = new Icecake();
		icecake.setProductCode(code);
		icecake.setProductName(name);
		icecake.setProductPrice(price);
		return icecake;		
	}
	
	/**
	 * 삭제 할 케이크 이름 입력받고 반환
	 * @return String name
	 */
	public String deleteCake() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 아이스케이크 삭제 ===");
		System.out.println("삭제할 아이스케이크 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	
	/**
	 * 리스트안에 들어있는 케이크 정보 출력
	 * @param iList
	 */
	public void showallcake(List<Icecake> iList) {
		System.out.println("=== 아이스케이크 전체 출력 ===");
		for(Icecake icecake : iList) {
			System.out.print("코드 : " + icecake.getProductCode() +", ");
			System.out.print("이름 : " +icecake.getProductName() + ", ");
			System.out.println("가격 : " + icecake.getProductPrice());
		}
	}

	/**
	 * 이벤트 상품 코드 이름 재고 이벤트상품일시 코드까지 입력받고 Preproduct객체로 반환
	 * @return Preproduct preproduct
	 */
	public Preproduct registPre() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 이벤트 증정품 등록 ===");
		System.out.print("상품 코드 입력 : ");
		int code = sc.nextInt();
		System.out.print("상품 이름 입력 : ");
		String name = sc.next();
		System.out.print("상품 재고 : ");
		int amount = sc.nextInt();
		System.out.print("이벤트 상품 여부(Y,N으로 입력) : ");
		String eventis = sc.next();
		int eventCode = 0;
		if(eventis.equals("Y")) {
			System.out.print("이벤트 코드 : ");
			eventCode = sc.nextInt();
		}
		Preproduct preproduct = new Preproduct();
		preproduct.setProuductCode(code);
		preproduct.setProductName(name);
		preproduct.setAmount(amount);
		preproduct.setEventYn(eventis);
		preproduct.setProuductCode(code);
		return preproduct;
	}
	
	/**
	 * 삭제할 상품 이름 입력받고 리턴
	 * @return String name
	 */
	public String deletePre() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 이벤트 증정품 삭제 ===");
		System.out.print("삭제할 상품 이름 : ");
		String name = sc.next();
		return name;
	}
	
	/**
	 * 입력받은 리스트 전체 출력 이벤트가 아닐시 이벤트상품아님 출력
	 * @param pList
	 */
	public void showallPre(List<Preproduct> pList) {
		for(Preproduct pOne : pList) {
			System.out.print("상품 코드 : " + pOne.getProuductCode() + ", ");
			System.out.print("상품 이름 : " + pOne.getProductName() + ", ");
			System.out.print("남은 재고 : " + pOne.getAmount() + ", ");
			String event = pOne.getEventYn();
			if(event == null){
			System.out.println("이벤트 상품 아님!");
			}else{
				System.out.println("이벤트 : " + event);
			}
			
		}
	}
	
	/**
	 * 고객정보변경삭제 입력받고 반환
	 * @return
	 */
	public int updateCustomerMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 고객 정보 변경 ===");
		System.out.println("1. 고객 등급 변경");
		System.out.println("2. 고객 정보 삭제");
		System.out.print(">>");
		int result = sc.nextInt();
		return result;
	}
	
	/**
	 * 멤버코드와 멤버 등급 변경할 만큼 입력받고 반환
	 * @return int[] array;
	 */
	public int[] updateMemberLevel() {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[2];
		System.out.println("=== 멤버쉽 등급 변경 ===");
		System.out.print("변경할 고객 코드 입력 : ");
		array[1] = sc.nextInt();
		System.out.println("양수 입력시 올라가고 음수 입력시 내려감");
		System.out.print("변경 할 정도 입력 : ");
		array[0] = sc.nextInt();
		return array;
	}
	
	/**
	 * 멤버 삭제 코드 입력받고 반환
	 * @return int result
	 */
	public int deleteMember() {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 멤버 삭제 ===");
		System.out.print("삭제할 멤버 코드 입력 : ");
		result = sc.nextInt();
		return result;
	}

	/**
	 * 이벤트 메뉴 출력 받은 값 리턴 1.등록 2.삭제
	 * @return int result
	 */
	public int eventmenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 이벤트 메뉴 ===");
		System.out.println("1. 이벤트 등록");
		System.out.println("2. 이벤트 삭제");
		System.out.print(">>");
		int result = sc.nextInt();
		return result;
	}
	
	/**
	 * 이벤트 등록 메뉴 출력 코드 이름 시작 끝 입력받고 event에 담아 리턴
	 * @return Event event
	 */
	public Event registEvent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 이벤트 등록 ===");
		System.out.print("이벤트 코드 : ");
		int code = sc.nextInt();
		System.out.print("이벤트 이름 : ");
		String name = sc.next();
		System.out.print("이벤트 시작(yyyy-[m]m-[d]d) : ");
		String startDay = sc.next();
		System.out.print("이벤트 끝(yyyy-[m]m-[d]d) : ");
		String endDay = sc.next();
		Event event = new Event();
		event.setEventCode(code);
		event.setEventName(name);
		event.setEventStartTerm(Date.valueOf(startDay));
		event.setEventEndTerm(Date.valueOf(endDay));
		return event;
	}
	
	/**
	 * 이벤트 삭제 메뉴 삭제할 이벤트 코드 입력받고 리턴
	 * @return int result
	 */
	public int deleteEvent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 이벤트 삭제 ===");
		System.out.print("삭제 할 이벤트 코드 : ");
		int result = sc.nextInt();
		return result;
	}
	
	/**
	 * 모든 이벤트 리스트 오픈해 정보 출력
	 * @param eList
	 */
	public void showAllevent(List<Event> eList) {
		System.out.println("=== 이벤트 전체 출력 ===");
		for(Event eOne : eList) {
			System.out.print("이벤트 코드 : " + eOne.getEventCode() + ", ");
			System.out.print("이벤트 이름 : " + eOne.getEventName() + ", ");
			System.out.print("이벤트 시작 일 : " + eOne.getEventStartTerm() + ", ");
			System.out.println("이벤트 종료 일: " + eOne.getEventEndTerm());
			
		}
	}

	public Preproduct updatePreMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 재고 추가 ===");
		System.out.print("추가 할 상품 코드 입력 : ");
		int code = sc.nextInt();
		System.out.print("추가 할 재고 수 입력 : ");
		int amount = sc.nextInt();
		Preproduct preproduct = new Preproduct();
		preproduct.setProuductCode(code);
		preproduct.setAmount(amount);
		return preproduct;
	}

	public int sellMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 판매 메뉴 ===");
		System.out.println("1. 단품 판매");
		System.out.println("2. 아이스크림 판매");
		System.out.print(">>");
		int result = sc.nextInt();
		return result;
	}
	
	public Sell sellProduct() {
		Scanner sc = new Scanner(System.in);
		Sell sell = new Sell();
		System.out.println("=== 단품판매 ===");
		System.out.print("판매 할 제품 코드 : ");
		int procode = sc.nextInt();
		sell.setProductCode(procode);
		System.out.print("고객 코드 : ");
		int cuscode = sc.nextInt();
		sell.setCustomerCode(cuscode);
		EXIT :
		do {			
			System.out.print("증정품 개수 : ");
			int index = sc.nextInt();
			sell.setPreKinds(index);	
			if(index > 0) {
				for(int i = 0; i < index; i++) {
					System.out.println(i+1 + "번째 증정품");
					System.out.print("증정할 상품 코드 : ");
					int precode = sc.nextInt();
					System.out.print("양 : ");			
					int amount = sc.nextInt();
					sell.setPrepros(precode, amount);
					System.out.println("=== 현재 증정품 ===");
					for(int j = 0; j <= i ; j++) {
						Preproduct prepro = sell.getPrepro(j);
						System.out.print(j+1+"번째 코드 : " + prepro.getProuductCode() + ", ");
						System.out.println("개수 : " + prepro.getAmount());
					}
				}
				System.out.print("입력하신 증정품 정보가 맞습니까?(Y,N) : ");
				String is = sc.next();
				if(is.equals("Y")) {
					break EXIT;
				}
				else sell.initprepros();
			}else if(index == 0) break EXIT;
		}while(true);
		return sell;
	}
	
	public void checkSell(Sell sell) {
		System.out.println("제품명 : " + sell.getProductName());		
		System.out.println("가격 : " + sell.getProductPrice());		
		System.out.println("고객 이름 : " + sell.getCustomerName());		
		System.out.println("고객 코드 : " + sell.getCustomerCode());	
		System.out.println("적립 될 포인트 : " + sell.getBonus());		
	}
}


