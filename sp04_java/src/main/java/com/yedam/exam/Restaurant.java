package com.yedam.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Restaurant {
	Chef chef;

	public Restaurant(Chef chef) {
		this.chef = chef;
	}

	public void order() {
		chef.cook();
	}
}
