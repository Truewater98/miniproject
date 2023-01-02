package icecream.run;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import icecream.controller.Controller;
import icecream.model.admin.Admin;
import icecream.model.costomer.Customer;
import icecream.model.event.Event;
import icecream.model.preproduct.Preproduct;
import icecream.model.product.icecake.Icecake;
import icecream.model.product.icecream.Icecream;
import icecream.model.sell.Sell;
import icecream.view.View;

public class Run {
	public static void main(String[] args) {
		View iView = new View();
		Controller iCon = new Controller();
		Customer customer = new Customer();
		List<Customer> cList = new ArrayList<Customer>();
		int result;
		String name;
		Preproduct preproduct;
		EXIT :
		while(true) {
			// 메인메뉴 출력후 숫자 입력받음 1. 판매 2. 재고관리 3. 이벤트 확인 4. 고객관리 5.관리자메뉴
			int choice = iView.Mainmenu();
			switch(choice) {
			case 1 :
				choice = iView.sellMenu();
				switch(choice) {
				case 1 : 
					Sell sell = iView.sellProduct();
					sell = iCon.sellProduct(sell);
					iView.checkSell(sell);
					break; 
				case 2 : 
					break;
				default : 
				}
				break;
			case 2 : 
				iView.showallPre(iCon.showAllPre());
				preproduct = iView.updatePreMenu();
				result = iCon.updatePreAmount(preproduct);
				iView.judge(result, "재고추가");
				break;
			case 3 : 
				iView.showAllevent(iCon.showAllEvent());
				break;
			case 4 : 
					// 고객관리 메뉴 후 숫자 입력받음 1. 전체 2. 검색 3. 가입
					 choice = iView.customerMenu();
					 switch(choice) {
					 // 전체 고객 출력
					 case 1 : 
						 cList = iCon.SelectAll();
						 iView.showAll(cList);
						 break;
					 // 입력한 고객 출력
					 case 2 : 
						 String info = iView.inputCustomer();
						 cList = iCon.selectCustomer(info);
						 iView.showAll(cList);
						 break;
					 // 회원가입
					 case 3 : 
						 customer = iView.registCustomer();
						 result = iCon.register(customer);
						 iView.judge(result, "회원가입");
						 break;
					 default : 
					 }
				break;
			case 5 : 
				//관리자 로그인
				Admin admin = iView.login();
				result = iCon.login(admin);
				// 로그인 성공
				if(result != 0) {
					 System.out.println("로그인에 성공했습니다.");
					 //관리자 메뉴 호출 1.상품 등록 2. 고객정보 변경 3. 이벤트 등록
					 choice = iView.adminMenu();
					 switch(choice) {
					 case 1 : 
						 // 상품등록 메뉴 호출 1. 맛 등록 2.맛 삭제 3.맛 전체 보여주기 
						 //4. 케이크 등록 5. 케이크 삭제 6.케이크 전체 보여주기기
						 //7. 이벤트상품 증정품 등록 8. 이벤트상품 증정품 삭제 9. 전체 보여주기
						 choice = iView.managingProduct();
						 switch(choice) {
						 // 맛 이름 등록 코드는 자동으로 마지막 번호
						 case 1 :  
							 String flavor = iView.managingIceCream("등록");
							 result = iCon.registIce(flavor);
							 iView.judge(result, "맛 등록");
							 break;
						// 맛 이름 입력 입력한 맛 삭제 코드 앞으로 밀림
						 case 2 : 
							 flavor = iView.managingIceCream("삭제");
							 iCon.deleteIce(flavor);
							 iView.judge(result, "맛 삭제");
							 break;
						 // 맛 전체 출력
						 case 3 : 
							 iView.allIcecream(iCon.allIcecream());
							 break;
						 // 케이크 등록
						 case 4 : 
							 Icecake icecake = iView.registCake();
							 result = iCon.registCake(icecake);
							 iView.judge(result, "케이크입력");
							 break;
						 // 케이크 삭제
						 case 5 : 
							 name = iView.deleteCake();
							 result = iCon.deleteCake(name);
							 iView.judge(result, "케이크삭제");
							 break;
						 // 케이크 전부 보여주기
						 case 6 :
							 List<Icecake> iList = iCon.allShowcake();
							 iView.showallcake(iList);
							 break;
						 // 상품 등록
						 case 7 : 
							 preproduct = iView.registPre();
							 result = iCon.registPre(preproduct);
							 iView.judge(result, "상품등록");
							 break;
						 // 상품 제거
						 case 8 : 
							 name = iView.deletePre();
							 result = iCon.deletePre(name);
							 iView.judge(result, "상품삭제");
							 break;
						 // 전체 보여주기
						 case 9 : 
							 iView.showallPre(iCon.showAllPre());
							 break;				 
						 default : System.out.println("1~9사이값 입력");
						 }
						 break;
					 //멤버 등급 변경 삭제
					 case 2 : 
						 cList = iCon.SelectAll();
						 iView.showAll(cList);
						 choice = iView.updateCustomerMenu();
						 switch(choice) {
						 // 멤버 등급 변경
						 case 1 :
							 int[] array = iView.updateMemberLevel();
							 result = iCon.updateMemberLevel(array);
							 iView.judge(result, "등급변경");
							 break;		 
						 // 멤버 삭제
						 case 2 :
							 int input = iView.deleteMember();
							 result = iCon.deleteMember(input);
							 iView.judge(result, "고객 삭제");
							 break;
						 }
						 break;
					 case 3 : 
						 // 이벤트 전체 출력후 이벤트 메뉴 보여줌
						 iView.showAllevent(iCon.showAllEvent());
						 choice = iView.eventmenu();
						 switch(choice) {
						 // 이벤트 등록
						 case 1 : 
							 Event event = iView.registEvent();
							 result = iCon.registEvent(event);
							 iView.judge(result, "이벤트 등록");
							 break;
						 // 이벤트 삭제
						 case 2 : 
							 int code = iView.deleteEvent();
							 result = iCon.deleteEvent(code);
							 iView.judge(result, "이벤트 삭제");
							 break;
						 default : System.out.println("1~2사이 값 입력");
						 }
						 break;
					 default : System.out.println("1~3사이 값 입력");
					 }
				//실패
				}
				else {
					 System.out.println("로그인에 실패했습니다.");
				 }
				break;
			case 0 : break EXIT;
			default :
			}			
		}
	}
}
