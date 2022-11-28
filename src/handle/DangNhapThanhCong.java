package handle;

import java.util.Scanner;

import entity.User;
import main.MainRun;

public class DangNhapThanhCong {
	Handle inPutHandle = new Handle();

	public void changeUser(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap Username moi");
			String ten = sc.nextLine();
			if (inPutHandle.checkUserName(user)) {
				user.setUserName(ten);
				inPutHandle.xuLySauKhiThayDoiThongTin(user);
				break;
			}
		}
		System.out.println("Thay doi UserName thanh cong");
	}

	public void changeEmail(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap email moi");
			String email = sc.nextLine();

			if (inPutHandle.checkEmail(email)) {
				user.setEmail(email);
				break;
			}
		}
		inPutHandle.xuLySauKhiThayDoiThongTin(user);
		System.out.println("Thay doi email thanh cong");
	}

	public void changPassword(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap password moi");
			String passWord = sc.nextLine();

			if (inPutHandle.checkPassWord(passWord)) {
				user.setPassWord(passWord);
				break;
			} else if (user.getPassWord() == passWord) {
				System.out.println("Password moi khong duoc trung password cu");
			}
		}
		inPutHandle.xuLySauKhiThayDoiThongTin(user);
		System.out.println("Thay doi Password thanh cong");

	}

}
