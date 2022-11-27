package handle;

import java.util.Scanner;

import entyti.User;
import main.MainRun;

public class DangKy {
	public static void dangKy() {
		Scanner sc = new Scanner(System.in);		
			User user = InPutHandle.inputUserForRegister(sc);
			if(user.getPassWord() != null && user.getEmail() !=null && user.getPassWord() !=null) {
			MainRun.userArrayList.add(user);
			}
			
	}
}
