package chapter15;

public class LoginFailException extends Exception {
	public LoginFailException() {}
	
	public LoginFailException(String message) {
		super(message);
	}
}
