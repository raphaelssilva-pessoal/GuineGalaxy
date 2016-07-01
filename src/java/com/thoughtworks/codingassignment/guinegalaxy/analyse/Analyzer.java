package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;

public interface Analyzer {
	public boolean isAnalyzer(String text);
	public TypeAnalyzer getType();
	void process(String text, Knowledge knowledge) throws Exception;
}
