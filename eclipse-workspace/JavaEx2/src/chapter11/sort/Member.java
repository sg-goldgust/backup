package chapter11.sort;

public class Member  implements Comparable<Member> {
	String name;
	int age;

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return name;
	}
}
