package com.thoughtworks.codingassignment.guinegalaxy;

import java.util.List;

import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoArabica;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoEnum;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoFactory;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoRomano;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.AnalyserFactory;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.Analyzer;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.AssignmentAnalyzer;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.AssignmentGroupAnalyzer;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.QuestionAssignmentAnalyzer;
import com.thoughtworks.codingassignment.guinegalaxy.analyse.TypeAnalyzer;
import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;
import com.thoughtworks.codingassignment.guinegalaxy.util.FileUtil;

public class Start {

	public static void main(String[] args) {
		init();
		try {
			Knowledge knowledge = new Knowledge();
			String path = getPath(args);
			List<String> lines = FileUtil.getTextFile(path);
			processKnowledge(lines, knowledge);
			processInformations(knowledge);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return;
		}
	}

	protected static void processInformations(Knowledge knowledge) {
		List<String> informations = knowledge.processInformations();
		for (String information : informations) {
			System.out.println(information);
		}
	}

	protected static void processKnowledge(List<String> lines, Knowledge knowledge) throws Exception {

		for (String line : lines) {
			for (TypeAnalyzer typeAnalyzer : TypeAnalyzer.values()) {
				Analyzer analyzer = AnalyserFactory.factory(typeAnalyzer);
				if (analyzer != null && analyzer.isAnalyzer(line)) {
					analyzer.process(line, knowledge);
				}
			}
		}
	}

	private static void init() {
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ROMANO, AlgoritmoRomano.class);
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ARABICA, AlgoritmoArabica.class);
		AnalyserFactory.registerAlgoritmoClass(TypeAnalyzer.ASSIGNMENT, AssignmentAnalyzer.class);
		AnalyserFactory.registerAlgoritmoClass(TypeAnalyzer.ASSIGNMENT_GROUP, AssignmentGroupAnalyzer.class);
		AnalyserFactory.registerAlgoritmoClass(TypeAnalyzer.QUESTION, QuestionAssignmentAnalyzer.class);
	}

	private static String getPath(String[] args) {
		String path = null;
		if (args.length > 0 && args[0] != null) {
			path = args[0];
		}
		return path;
	}
}
