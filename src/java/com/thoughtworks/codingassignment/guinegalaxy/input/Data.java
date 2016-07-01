package com.thoughtworks.codingassignment.guinegalaxy.input;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;

public class Data {
	String name;
	NumberRomano value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NumberRomano getValue() {
		return value;
	}

	public void setValue(NumberRomano value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
