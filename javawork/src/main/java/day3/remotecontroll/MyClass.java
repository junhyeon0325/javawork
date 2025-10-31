package day3.remotecontroll;

public class MyClass {
	// 필드
	RemoteControl rc;

	public MyClass(RemoteControl rc) {
		this.rc = rc;
	}

	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}

	void methodB() {
		rc.turnOn();
		rc.setVolume(5);
	}
}
