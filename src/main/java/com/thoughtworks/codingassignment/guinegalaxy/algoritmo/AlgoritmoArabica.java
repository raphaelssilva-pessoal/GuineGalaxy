package com.thoughtworks.codingassignment.guinegalaxy.algoritmo;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;

public class AlgoritmoArabica extends Algoritmo{

	public AlgoritmoArabica(int valorInt) {
		super(valorInt);
	}

	public AlgoritmoArabica(String value) {
		super(value);
	}

	@Override
	protected NumberRomano decode(String algoritmo) {	
		return new NumberRomano(Integer.parseInt(algoritmo));
	}

	@Override
	protected String encode(NumberRomano value) {
		return String.valueOf(value.integerValue());
	}

	@Override
	public AlgoritmoEnum getType() {
		return AlgoritmoEnum.ARABICA;
	}	
}
