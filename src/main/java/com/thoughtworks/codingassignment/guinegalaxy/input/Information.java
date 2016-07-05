package com.thoughtworks.codingassignment.guinegalaxy.input;

import java.util.List;

public class Information {
	int order;
	List<String> datasName;
	String suffixValue;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<String> getDatasName() {
		return datasName;
	}

	public void setDatasName(List<String> datasName) {
		this.datasName = datasName;
	}

	public String getSuffixValue() {
		return suffixValue;
	}

	public void setSuffixValue(String suffixValue) {
		this.suffixValue = suffixValue;
	}
	
}
