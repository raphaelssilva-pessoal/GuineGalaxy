package com.thoughtworks.codingassignment.guinegalaxy;

public class NumberRomano  {
	public NumberRomano(String value){
		this.value = value;
	}
	
	public NumberRomano(Integer valueInt){
		this.value = this.decode(valueInt);
	}
	
	String value;
	
	private static String laterSymbol(String romano, int cursor) {
		if ((romano.length() - cursor + 2) < romano.length()) {
			return romano.substring(romano.length() - cursor + 1, romano.length() - cursor + 2);
		} else {
			return romano.substring(romano.length() - cursor + 1);
		}
	}
	public static NumberRomano parseInt(Integer value) {
		return new NumberRomano(value);
	}
	private String decode(Integer value) {
		int[] arabicos = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		String[] romanos = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

		String romano = "";
		for (int i = 12; i >= 0; i--) {
			while (value >= arabicos[i]) {
				value -= arabicos[i];
				romano += romanos[i];
			}
		}
		return romano;
	}

	public Integer integerValue(){
		return integerValue(value);
	}
	
	@Override
	public String toString() {
		return value;
	}

	public static int integerValue(String value) {
		int cursor = 1;
		Integer arabico = 0;
		while (cursor <= value.length()) {
			String symbol = value.substring(value.length() - cursor, value.length() - cursor
					+ 1);
			if (symbol.equalsIgnoreCase("I")) {// 4 ou 9
				if (laterSymbol(value, cursor).equalsIgnoreCase("X")
						|| laterSymbol(value, cursor).equalsIgnoreCase("V")) {
					arabico -= 1;
				} else {
					arabico += 1;
				}
			} else if (symbol.equalsIgnoreCase("X")) {
				if (laterSymbol(value, cursor).equalsIgnoreCase("L")) {// 40
					arabico -= 10;
				} else if (laterSymbol(value, cursor).equalsIgnoreCase("C")) {// 90
					arabico -= 10;
				} else {
					arabico += 10;
				}
			} else if (symbol.equalsIgnoreCase("M")) {
				arabico += 1000;
			} else if (symbol.equalsIgnoreCase("D")) {
				arabico += 500;
			} else if (symbol.equalsIgnoreCase("C")) {
				if (laterSymbol(value, cursor).equalsIgnoreCase("D")) {// 400
					arabico -= 100;
				} else if (laterSymbol(value, cursor).equalsIgnoreCase("M")) {// 900
					arabico -= 100;
				} else {
					arabico += 100;
				}
			} else if (symbol.equalsIgnoreCase("L")) {
				arabico += 50;
			} else if (symbol.equalsIgnoreCase("V")) {
				arabico += 5;
			}
			cursor++;
		}
		return arabico;
	}
	
}