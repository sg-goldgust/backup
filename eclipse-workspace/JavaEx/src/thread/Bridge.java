package thread;

public class Bridge {
	
	private int counter = 0;
	private String name ;
	private String address;
	
	public synchronized void across(String name,String address) {
		this.counter ++;
		this.name = name;
		this.address = address;
		check();
	}

	@Override
	public synchronized String  toString() {
		return "Bridge [counter=" + counter + ", name=" + name + ", address=" + address + "]";
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("문제발생" + toString());
		}
	}
}
