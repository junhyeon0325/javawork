package day3.shape;
// abstract가 추가됬으니까 추상클래스
public abstract class Shape {

	// 필드
	private int sx;
	private int sy;
	private int ex;
	private int ey;
	private int w; // 선 두께

	// 생성자
	public Shape() {}
	public Shape(int sx, int sy, int ex, int ey) {
		super();
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	
	// 추상메서드 abstract
	public abstract void draw() ;
	
	// getter setter
	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getEx() {
		return ex;
	}

	public void setEx(int ex) {
		this.ex = ex;
	}

	public int getEy() {
		return ey;
	}

	public void setEy(int ey) {
		this.ey = ey;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	// 메소드
	@Override
	public String toString() {
		return "Shape [sx=" + sx + ", sy=" + sy + ", ex=" + ex + ", ey=" + ey + "]";
	}

}
