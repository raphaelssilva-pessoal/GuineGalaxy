package com.thoughtworks.codingassignment.guinegalaxy.algoritmo;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;

public abstract class Algoritmo {
	NumberRomano valor;

	public Algoritmo(String value) {
		this.valor = this.decode(value);
	}

	public Algoritmo(int valueInt) {
		this.valor = NumberRomano.parseInt(valueInt);
	}

	public static Algoritmo parse(String algoritmo, Class<Algoritmo> clazz) {
		try {
			return clazz.getConstructor(String.class).newInstance(algoritmo);
		} catch (Exception e) {
			return null;
		}
	}

	public String getAlgoritmo() {
		return valor.toString();
	}

	public NumberRomano getValor() {
		return valor;
	}

	protected abstract NumberRomano decode(String algoritmo);

	protected abstract String encode(NumberRomano valor);
	
	public boolean isAlgoritmo(String word){
		if(this.decode(word)!=null){
			return true;
		}
		return false;
	}
	
	public abstract AlgoritmoEnum getType();
}
