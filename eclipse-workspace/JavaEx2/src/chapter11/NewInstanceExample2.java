package chapter11;

public class NewInstanceExample2 {
	public static void main(String[] args) {
		Class[] clazz = {
				chapter11.SendAction.class,
				chapter11.ReceiveAction.class,
		};
		try {
	
			Action action = (Action) clazz[0].newInstance();
			action.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
