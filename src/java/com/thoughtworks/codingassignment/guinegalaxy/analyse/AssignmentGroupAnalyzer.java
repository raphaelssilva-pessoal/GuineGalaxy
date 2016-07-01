package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import java.util.List;

import com.thoughtworks.codingassignment.guinegalaxy.NumberRomano;
import com.thoughtworks.codingassignment.guinegalaxy.input.Data;
import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;

public class AssignmentGroupAnalyzer extends AssignmentAnalyzer implements Analyzer {

	@Override
	public boolean isAnalyzer(String text) {
		List<String> words = convertListWorks(text);
		return isAssignment(words)&&getIndexWordInList("is", words)>1;
	}

	@Override
	public TypeAnalyzer getType() {
		return TypeAnalyzer.ASSIGNMENT_GROUP;
	}

	@Override
	public void process(String text, Knowledge knowledge) throws Exception {
		List<String> words = convertListWorks(text);
		int wordIS = getIndexWordInList("is", words);
		NumberRomano value = new NumberRomano(Integer.parseInt(words.get(wordIS+1)));
		String wordNotFoundData = "";
		String algoritmo = "";
		for(String word:words.subList(0, wordIS)){
			Data data = knowledge.findDataByName(word);
			if(data!=null){
				algoritmo+=data.getValue().toString();
			}else{
				wordNotFoundData = word;
			}
		}
		
		if(!wordNotFoundData.isEmpty()){
			 
			NumberRomano valueWordNotFoundData = new NumberRomano(value.toString().replace(algoritmo, ""));
			String lineNew = wordNotFoundData+" is "+valueWordNotFoundData;
			System.out.println(lineNew);
			super.process(lineNew, knowledge);					
		}
	}


}
