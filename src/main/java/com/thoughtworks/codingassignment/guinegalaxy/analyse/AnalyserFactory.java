package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import java.util.HashMap;
import java.util.Map;

public class AnalyserFactory {

	private static Map<TypeAnalyzer, Class<? extends Analyzer>> analyserClassStore = new HashMap<TypeAnalyzer, Class<? extends Analyzer>>();

	public static void registerAlgoritmoClass(TypeAnalyzer typeAnalyzer, Class<? extends Analyzer> clazz) {
		analyserClassStore.put(typeAnalyzer, clazz);
	}

	public static Analyzer factory(TypeAnalyzer typeAnalyzer) {
		Analyzer analyzer = null;
		Class<? extends Analyzer> clazz = analyserClassStore.get(typeAnalyzer);
		if (clazz != null) {
			try {
				analyzer = clazz.newInstance();
			} catch (Exception e) {
				analyzer = null;
			}
		}
		return analyzer;
	}
}
