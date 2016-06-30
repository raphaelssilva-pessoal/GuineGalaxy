package com.thoughtworks.codingassignment.guinegalaxy.algoritmo;

import java.util.HashMap;
import java.util.Map;

public class AlgoritmoFactory {

	private static Map<AlgoritmoEnum, Class<? extends Algoritmo>> algoritmoClassStore = new HashMap<AlgoritmoEnum, Class<? extends Algoritmo>>();

	public static void registerAlgoritmoClass(AlgoritmoEnum algoritmoEnum, Class<? extends Algoritmo> clazz) {
		algoritmoClassStore.put(algoritmoEnum, clazz);
	}

	public static Algoritmo factory(String algoritmoStr, AlgoritmoEnum algoritmoEnum) {
		Algoritmo algoritmo = null;
		Class<? extends Algoritmo> clazz = algoritmoClassStore.get(algoritmoEnum);
		if (clazz != null) {
			try {
				algoritmo = clazz.getConstructor(String.class).newInstance(algoritmo);
			} catch (Exception e) {
				algoritmo = null;
			}
		}
		return algoritmo;
	}
}
