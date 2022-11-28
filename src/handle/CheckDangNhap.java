package handle;

import entity.User;
import main.MainRun;
import view.Menu;

public class CheckDangNhap {
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
		if(checkLogin(user) == 3) {
        	Menu.MenuSauKhiDangNhap(user);
        }else if(checkLogin(user) == 1) {
        	System.out.println("Vui long kiem tra lai user va dang nhap lai");
        	MainRun.showSortMenu();
        }else if(checkLogin(user) == 2) {
        	System.out.println("Password khong dung");
        	Menu.menuDangNhapSai(user);
        }     
	}
}
