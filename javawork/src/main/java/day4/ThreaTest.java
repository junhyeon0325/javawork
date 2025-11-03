package day4;

public class ThreaTest {
	/*
	 * 처음에는 for문이 하나하나씩 실행되는데 두개를 동시에 돌려볼꺼다
	 */
	public static void main(String[] args) throws InterruptedException {

		Job1 job1 = new Job1();
		job1.start();

		Thread thread = new Thread(new Job2());
		thread.start();

		// 익명클래스로 만든거다. -> 람다식
		Runnable run = () -> {
//		Thread thread2 = new Thread(() -> {
			for (int i = 200; i < 210; i++) {
				System.out.println(i);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(run);
		thread2.start();
	} // end main
} // end class
