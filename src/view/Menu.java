package view;

import java.util.Scanner;

import entity.User;
import handle.DangNhapSai;
import handle.DangNhapThanhCong;
import handle.Handle;
import main.MainRun;


public class Menu {
	 private static void showMenu(User user) {
	    	System.out.println("Chào mừng " + user.getUserName() + ". Mời bạn chọn chức năng :");
	        System.out.println("1.Thay đổi username ");
	        System.out.println("2. Thay đổi email");
	        System.out.println("3. Thay đổi mật khẩu");
	        System.out.println("4. Đăng xuất");
	        int choose = 0;   
	    }
	 public static void MenuSauKhiDangNhap(User user) {
		 DangNhapThanhCong dangNhapThanhCong = new DangNhapThanhCong();
		 Handle inPutHandle = new Handle();
	        while (true) {
	            showMenu(user);
	            int functionChoice = chooseFunction();
	            switch (functionChoice) {
	            case 1:
	             dangNhapThanhCong .changeUser(user);
	             inPutHandle.display(user);
	                break;
	            case 2:
	            	dangNhapThanhCong.changeEmail(user);	            	
	            	inPutHandle.display(user);
	                break;
	            case 3:
	            	dangNhapThanhCong.changPassword(user); 	            
	            	inPutHandle.display(user);
	            	break;
	            case 4:
	            	inPutHandle.display(user);	 
	            	user = null;
	            	MainRun.showSortMenu();            			              
	                break;	                
	            case 5:
	                return;
	            }
	        }
	    }
	    private static int chooseFunction() {
	        System.out.print("Xin mời chọn chức năng: ");
	        int choice = 0;
	        do {
	            choice = new Scanner(System.in).nextInt();
	            if (choice >= 1 && choice <= 4) {
	                break;
	            }
	            System.out.print("Chức năng vừa chọn không hợp lệ, vui lòng chọn lại: ");
	        } while (true);
	        return choice;
	    }

		public static void menuDangNhapSai(User user) {
			DangNhapSai dangNhapSai = new DangNhapSai();
	        System.out.println("Xin mời chọn : ");
	        System.out.println("1.Đăng nhập lại ");
	        System.out.println("2. Quên mật khẩu");
	        System.out.println("3. Thoát ra ngoài menu chính");
	        int choose = 0;
	        do {
	            choose = new Scanner(System.in).nextInt();
	            if (choose >= 1 && choose <= 3) {
	                break;
	            }
	            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
	        } while (true);
	        switch (choose) {
	            case 1:
	            	MainRun.showSortMenu();  
	                break;
	            case 2:
	            	 dangNhapSai.quenMatKhau(user);
	            	 MainRun.showSortMenu();
	                break;
	            case 3:
	                return;
	        }
	    }
	}


