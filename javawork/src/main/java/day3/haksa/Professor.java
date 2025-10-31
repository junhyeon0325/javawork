package day3.haksa;

public class Professor extends Member {

	int salary;
	
	public Professor() {}
	public Professor(int no, String name, int salary) {
		this.salary = salary;
		this.no = no;
		this.name = name;
	}
}
