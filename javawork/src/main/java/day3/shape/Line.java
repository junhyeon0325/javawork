package day3.shape;

public class Line extends Shape {

	private int style;

	// 생성자
	public Line() {
	}

	public Line(int sx, int sy, int ex, int ey, int style) {
		super(sx, sy, ex, ey); // 부모 생성자를 부를때는 super
		// 무조건 부모 생성자 호출이 먼저 이루어져야함
		// 만약에 this가 super위에 있으면 오류가 생김
		this.style = style;
	}

	// 생성자는 상속 X
	// 부모의 필드 초기화 부모 생성자 호출
	public Line(int sx, int sy, int ex, int ey) {
		super(sx, sy, ex, ey); // 부모 생성자를 부를때는 super
	}

	// getter setter
	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	@Override
	public void draw() {
		System.out.println("선을 그리다");
	}

}
