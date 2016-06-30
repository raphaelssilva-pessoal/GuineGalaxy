package com.thoughtworks.codingassignment.guinegalaxy.algoritmo;

public abstract class Algoritmo {
	int valor;

	public Algoritmo(String algoritmo) {
		this.decode(algoritmo);
	}

	public Algoritmo(int valor) {
		this.valor = valor;
	}

	public static Algoritmo parse(String algoritmo, Class<Algoritmo> clazz) {
		try {
			return clazz.getConstructor(String.class).newInstance(algoritmo);
		} catch (Exception e) {
			return null;
		}
	}

	public String getAlgoritmo() {
		return this.encode(valor);
	}

	public int getValor() {
		return valor;
	}

	protected abstract int decode(String algoritmo);

	protected abstract String encode(int valor);
}
