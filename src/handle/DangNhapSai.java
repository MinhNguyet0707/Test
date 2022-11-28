package handle;

import java.util.Scanner;

import entity.User;
import main.MainRun;
import view.Menu;

public class DangNhapSai {
	public static void quenMatKhau(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap Email cua ban");
		String email = sc.nextLine();
		if(checkEmaiQuenMatKhau(email, user)) {
			for (User user3 : MainRun.userArrayList) {
				if(user3.getUserName().equalsIgnoreCase(user.getUserName()) ) {
					user.setEmail(email);
					MainRun.userArrayList.remove(user3);
					MainRun.userArrayList.add(user);
				}
			}
		}
		
	}	
public static boolean checkEmaiQuenMatKhau(String email, User user) {
	for (User user2 : MainRun.userArrayList) {
		if (user2.getUserName().equalsIgnoreCase(user.getUserName())) {
			if(user2.getEmail().equalsIgnoreCase(email)) {
				DangNhapThanhCong.changPassword(user);						
				return true;
			}					
		}
	}
	System.out.println("Email cua ban khong trung khop");
	return false;
}

public static void xuLyDangNhap() {
	Scanner sc = new Scanner(System.in);
	User user = InPutHandle.inputUser(sc);
	if (CheckDangNhap.checkLogin(user) == 3) {
		Menu.MenuSauKhiDangNhap(user);
	} else if (CheckDangNhap.checkLogin(user) == 1) {
		System.out.println("Vui long kiem tra lai user va dang nhap lai");
		MainRun.showSortMenu();
	} else if (CheckDangNhap.checkLogin(user) == 2) {
		System.out.println("Password khong dung");
		Menu.menuDangNhapSai(user);
	}
}

}
