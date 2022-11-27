package handle;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import entyti.User;
import main.MainRun;
import view.Menu;

public class InPutHandle {
	public static User inputUser(Scanner sc) {
		System.out.println("Mời bạn nhập Username");
		String name = sc.nextLine();
		System.out.println("Mời bạn nhập Password");
		String password = sc.nextLine();
		User user = new User(name, password, null);
		return user;
	}

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

	public static boolean checkPassWord(String passWord) {

			Pattern p = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
			
			if (!p.matcher(passWord).find() ) {		
			System.out.println("Password phải bao gồm ký tự viết hoa, ký tự đặc biệt và có độ dài từ 7 - 14 ký tự.");
				return false;
		}		
		return true;
	}

	public static int checkLogin(User user) {
		if(!checkUserName(user)) {
			return 1;
		} else if(!checkPassWord(user)) {
			return 2;
		} else if(checkUserName(user) && checkPassWord(user) ) {
			return 3;
		}
		return 0;
	}
	public static boolean checkUserName(String userName) {
		for (int i = 0; i < MainRun.userArrayList.size(); i++) {
			if (MainRun.userArrayList.get(i).getUserName().equals(userName)) {
				System.out.println("Ten da ton tai, vui long chon ten khac");
				return false;
			}
		}
		return true;
	}

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

	
	
	public static void display(User user) {
		System.out.println(user.toString());
		
	}
	
	public static boolean checkUserName(User user) {
		for (User user2 : MainRun.userArrayList) {
			if(user2.getUserName().equals(user.getUserName())) {
				user.setEmail(user2.getEmail());
				return true;
			}
	}
		return false;
}
	
	public static boolean checkPassWord(User user) {
		for (User user2 : MainRun.userArrayList) {
			if(user2.getPassWord().equals(user.getPassWord())) {
				return true;
			}
	}
		return false;
}
	public static void xuLyDangNhap(User user) {
		if(InPutHandle.checkLogin(user) == 3) {
        	Menu.MenuSauKhiDangNhap(user);
        }else if(InPutHandle.checkLogin(user) == 1) {
        	System.out.println("Vui long kiem tra lai user va dang nhap lai");
        	MainRun.showSortMenu();
        }else if(InPutHandle.checkLogin(user) == 2) {
        	System.out.println("Password khong dung");
        	Menu.MenuDangNhapSai(user);
        }     
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
}