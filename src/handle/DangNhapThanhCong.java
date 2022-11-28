package handle;

import java.util.Scanner;

import entity.User;
import main.MainRun;

public class DangNhapThanhCong {
	public static void changeUser(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap Username moi");
			String ten = sc.nextLine();
			if (CheckDangNhap.checkUserName(user)) {
				user.setUserName(ten);
			InPutHandle.xuLySauKhiThayDoiThongTin(user);
				break;
			}
		}
		System.out.println("Thay doi UserName thanh cong");	
		
	}

	public static void changeEmail(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap email moi");
			String email = sc.nextLine();

			if (InPutHandle.checkEmail(email)) {
				user.setEmail(email);
				break;
			}
		}
		InPutHandle.xuLySauKhiThayDoiThongTin(user);
		System.out.println("Thay doi email thanh cong");
	}
	
	public static void changPassword(User user) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap password moi");
			String passWord = sc.nextLine();

			if (InPutHandle.checkPassWord(passWord)) {
				user.setPassWord(passWord);
				break;
			} else if(user.getPassWord()==passWord) {
				System.out.println("Password moi khong duoc trung password cu");
			}			
		}
		InPutHandle.xuLySauKhiThayDoiThongTin(user);
		System.out.println("Thay doi Password thanh cong");
		
		
	}
	

}
