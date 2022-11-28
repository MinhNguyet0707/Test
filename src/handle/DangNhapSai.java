package handle;

import java.util.Scanner;

import entity.User;
import main.MainRun;
import view.Menu;

public class DangNhapSai {
	public void quenMatKhau(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap Email cua ban");
		String email = sc.nextLine();
		if (checkEmaiQuenMatKhau(email, user)) {
			for (User user3 : MainRun.userArrayList) {
				if (user3.getUserName().equalsIgnoreCase(user.getUserName())) {
					user.setEmail(email);
					MainRun.userArrayList.remove(user3);
					MainRun.userArrayList.add(user);
				}
			}
		}
	}

	public boolean checkEmaiQuenMatKhau(String email, User user) {
		DangNhapThanhCong dangNhapThanhCong = new DangNhapThanhCong();
		for (User user2 : MainRun.userArrayList) {
			if (user2.getUserName().equalsIgnoreCase(user.getUserName())) {
				if (user2.getEmail().equalsIgnoreCase(email)) {
					dangNhapThanhCong.changPassword(user);
					return true;
				}
			}
		}
		System.out.println("Email cua ban khong trung khop");
		return false;
	}
	
	public void xuLyDangNhap(Scanner sc) {
		Handle inPutHandle = new Handle();
		User user = inPutHandle.inputUser(sc);
		if (inPutHandle.checkLogin(user) == 3) {
			Menu.MenuSauKhiDangNhap(user);
		} else if (inPutHandle.checkLogin(user) == 1) {
			System.out.println("Vui long kiem tra lai user va dang nhap lai");
			MainRun.showSortMenu();
		} else if (inPutHandle.checkLogin(user) == 2) {
			System.out.println("Password khong dung");
			Menu.menuDangNhapSai(user);
		}
	}

}
