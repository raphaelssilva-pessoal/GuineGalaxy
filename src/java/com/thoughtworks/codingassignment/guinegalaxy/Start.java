package com.thoughtworks.codingassignment.guinegalaxy;

import java.util.List;

import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoEnum;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoFactory;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoRomano;
import com.thoughtworks.codingassignment.guinegalaxy.util.FileUtil;

public class Start {

	public static void main(String[] args) {
		init();
		try{
			String path = getPath(args);
			List<String> lines = FileUtil.getTextFile(path);			
		}catch(Exception e){
			System.err.println(e.getMessage());
			return;
		}
	}
	
	private static void init(){
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ROMANO, AlgoritmoRomano.class);
	}
	
	private static String getPath(String[] args) {
		String path = null;
		if (args.length > 0 && args[0] != null) {
			path = args[0];
		}
		return path;
	}
}
