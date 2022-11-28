package handle;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import entity.User;
import main.MainRun;
import view.Menu;

public class InPutHandle {
	//	hàm nhập
	public static User inputUser(Scanner sc) {
		System.out.println("Mời bạn nhập Username");
		String name = sc.nextLine();
		System.out.println("Mời bạn nhập Password");
		String password = sc.nextLine();
		User user = new User(name, password, null);
		return user;
	}
	// hàm sử lý khi đăng kí
	public static User inputUserForRegister(Scanner sc) {
		User user = new User();
		while (true) {
			if (user.getUserName() == null) {
				System.out.println("Mời bạn nhập Username");
				String name = sc.nextLine();
				if (InPutHandle.checkUserName(name)) {
					user.setUserName(name);
				} else {
					break;
				}
			}
			if (user.getPassWord() == null) {
				System.out.println("Mời bạn nhập Password");
				String password = sc.nextLine();
				if (InPutHandle.checkPassWord(password)) {
					user.setPassWord(password);
				} else {
					break;
				}
			}
			if (user.getEmail() == null) {
				System.out.println("Mời bạn nhập Email");
				String email = sc.nextLine();
				if (InPutHandle.checkEmail(email)) {
					user.setEmail(email);
					break;
				} else {
					break;
				}
			}
		}	
		
		return user;
	}
	// hàm check ten khi dang ki
		public static boolean checkUserName(String userName) {
			for (int i = 0; i < MainRun.userArrayList.size(); i++) {
				if (MainRun.userArrayList.get(i).getUserName().equals(userName)) {
					System.out.println("Ten da ton tai, vui long chon ten khac");
					return false;
				}
			}
			return true;
		}
// hàm check email khi đăng kí
	public static boolean checkEmail(String email) {
		Pattern checkMail = Pattern.compile("^[a-zA-z][a-zA-z)-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
		if (!checkMail.matcher(email).find()) {
			System.out.println("Email không đúng định dạng, vui lòng nhập lại ");
			return false;
		}
		for (User user : MainRun.userArrayList) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				System.out.println("Email da ton tai ");
				return false;				
			}
		}
		return true;
	}
	// hàm xử lý khi đăng kí passWord

	public static boolean checkPassWord(String passWord) {

			Pattern p = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
			
			if (!p.matcher(passWord).find() ) {		
			System.out.println("Password phải bao gồm ký tự viết hoa, ký tự đặc biệt và có độ dài từ 7 - 14 ký tự.");
				return false;
		}		
		return true;
	}

	
	
	public static void xuLySauKhiThayDoiThongTin(User user) {
		for (int i = 0; i < MainRun.userArrayList.size(); i++) {
			if(MainRun.userArrayList.get(i).getUserName().equalsIgnoreCase(user.getUserName())|| MainRun.userArrayList.get(i).getEmail().equalsIgnoreCase(user.getEmail())) {
				MainRun.userArrayList.get(i).setEmail(user.getEmail());
				MainRun.userArrayList.get(i).setPassWord(user.getPassWord());
				MainRun.userArrayList.get(i).setUserName(user.getUserName());
				
			}	
	}
	}
	public static void display(User user) {
		System.out.println(user.toString());
		
	}
	
}