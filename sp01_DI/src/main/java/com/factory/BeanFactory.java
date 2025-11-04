package com.factory;
/*
 * 디자인 패턴 - 펙토리
 * 디자인패턴중에서 펙토리를 사용하고 있음
 */
public class BeanFactory { // 필요한 객체를 가져와서 써볼거다

	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}

}
