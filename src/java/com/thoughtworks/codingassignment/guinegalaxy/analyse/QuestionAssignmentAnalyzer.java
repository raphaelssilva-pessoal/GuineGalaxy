package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.codingassignment.guinegalaxy.input.Information;
import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;

public class QuestionAssignmentAnalyzer implements Analyzer {

	static final String REGEX_H0W_MANY = "(how many )([A-Za-z0-9]*)( is )([+\\w ]*) \\?";
	static final String REGEX_H0W_MUCH = "(how much is )([+\\w ]*) \\?";

	@Override
	public boolean isAnalyzer(String text) {
		return text.endsWith("?");
	}

	@Override
	public TypeAnalyzer getType() {
		return TypeAnalyzer.QUESTION;
	}

	@Override
	public void process(String text, Knowledge knowledge) throws Exception {
		if (Pattern.matches(REGEX_H0W_MANY, text)) {
			this.processaHowMany(text, knowledge);
		} else if (Pattern.matches(REGEX_H0W_MUCH, text)) {
			this.processaHowMuch(text, knowledge);
		} else {
			Information information = new Information();
			information.setOrder(knowledge.getInformations().size() + 1);
			knowledge.getInformations().add(information);
		}
	}

	private void processaHowMany(String text, Knowledge knowledge) {
		Pattern r = Pattern.compile(REGEX_H0W_MANY);

		Matcher m = r.matcher(text);
		if (m.find()) {
			Information information = new Information();			
			information.setSuffixValue(m.group(2));
			List<String> dadasStr = Arrays.asList(m.group(4).split(" "));
			information.setDatasName(dadasStr);
			knowledge.getInformations().add(information);
		}
	}

	private void processaHowMuch(String text, Knowledge knowledge) {
		Pattern r = Pattern.compile(REGEX_H0W_MUCH);

		Matcher m = r.matcher(text);
		if (m.find()) {
			Information information = new Information();
			List<String> dadasStr = Arrays.asList(m.group(2).split(" "));
			information.setDatasName(dadasStr);
			knowledge.getInformations().add(information);
		}
	}

}
