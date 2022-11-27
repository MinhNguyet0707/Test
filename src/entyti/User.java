package entyti;

import java.util.Scanner;

import main.MainRun;

public class User {
private String userName;
private String passWord;
private String email;
public User(String userName, String passWord, String email) {
	super();
	this.userName = userName;
	this.passWord = passWord;
	this.email = email;
}
public User() {
	super();
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "User [userName=" + userName + ", passWord=" + passWord + ", email=" + email + "]";
}



}
