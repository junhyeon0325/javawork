package day3.remotecontroll;

public class Main {
	public static void main(String[] args) {
		MyClass myClass = new MyClass(new Audio());
		myClass.methodB();
		
		myClass = new MyClass(new Television());
		myClass.methodB();
	}
}
