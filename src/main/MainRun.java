package main;

import java.util.ArrayList;
import java.util.Scanner;

import entity.User;
import handle.DangNhapSai;
import handle.DangNhapThanhCong;
import handle.Handle;
import view.Menu;

public class MainRun {
	public static ArrayList<User> userArrayList = new ArrayList<>();
    
		public static void main(String[] args) {
		showSortMenu();
	}

	public static void showSortMenu() {
		Handle inPutHandle = new Handle();
		  DangNhapSai dangNhapSai = new DangNhapSai();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Vui lòng lựa chọn : ");
		System.out.println("1. Đăng nhập");
		System.out.println("2. Đăng kí");
		int choose = 0;
		do {
			choose = new Scanner(System.in).nextInt();
			if (choose >= 1 && choose <=2) {
				break;
			}
			System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
		} while (true);
		switch (choose) {
		case 1:
			dangNhapSai.xuLyDangNhap(sc);
			break;
		case 2:
			inPutHandle.dangKy();
			showSortMenu();
			break;
		case 3:
			return;
		}
	}

}
