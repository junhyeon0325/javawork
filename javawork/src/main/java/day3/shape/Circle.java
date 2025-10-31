package day3.shape;

public class Circle extends Shape {
	

	// 필드
	private String color; // 면색상

	// getter setter
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// 메소드
	@Override
	public String toString() {
		return "Circle [sx=" + getSx() + ", sy=" + getSy() + ", ex=" + getEx() + ", ey=" + getEy() + "]";
	}

	@Override
	public void draw() {
		System.out.println("원을 그리다");
	}
	
	

}
