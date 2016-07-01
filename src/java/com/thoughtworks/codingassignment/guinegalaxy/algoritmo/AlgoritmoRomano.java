package com.thoughtworks.codingassignment.guinegalaxy.algoritmo;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;

public class AlgoritmoRomano extends Algoritmo{

	public AlgoritmoRomano(int valor) {
		super(valor);
	}

	public AlgoritmoRomano(String algoritmo) {
		super(algoritmo);
	}

	@Override
	protected NumberRomano decode(String algoritmo) {
		return new NumberRomano(algoritmo);
	}
	
	@Override
	protected String encode(NumberRomano value) {
		return value.toString();
	}

	@Override
	public AlgoritmoEnum getType() {
		return AlgoritmoEnum.ROMANO;
	}	
}
