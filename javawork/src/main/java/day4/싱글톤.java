package day4;

public class 싱글톤 {
	public static void main(String[] args) {
		Dept dept1 = Dept.getInstance();
		Dept dept2 = Dept.getInstance();
		System.out.println(dept1 == dept2);
	}
}

class Dept {
	private static Dept instance = new Dept();

	private Dept() {
	}

	public static Dept getInstance() {
		return instance;
	}

}
