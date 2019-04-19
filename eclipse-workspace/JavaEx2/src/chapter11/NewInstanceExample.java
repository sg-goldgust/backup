package chapter11;

public class NewInstanceExample {
	public static void main(String[] args) {

		try {
			Class clazz = Class.forName("chapter11.SendAction");
			// Class clazz = Class.forName("chapter11.ReceiveAction");

			Action action = (Action) clazz.newInstance();
			action.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
