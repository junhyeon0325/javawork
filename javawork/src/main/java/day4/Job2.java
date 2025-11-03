package day4;
// Runnable을 상속받는다.
public class Job2 implements Runnable {

	@Override
	public void run() {
		for(int i = 101; i <= 110; i++) {
			System.out.println(i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
