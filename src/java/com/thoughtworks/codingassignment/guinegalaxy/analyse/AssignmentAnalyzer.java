package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.Algoritmo;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoEnum;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoFactory;
import com.thoughtworks.codingassignment.guinegalaxy.input.Data;
import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;

public class AssignmentAnalyzer implements Analyzer {

	@Override
	public boolean isAnalyzer(String text) {
		List<String> words = convertListWorks(text);
		return isAssignment(words)&&getIndexWordInList("is", words)==1;
	}

	protected List<String> convertListWorks(String text) {
		List<String> words = Arrays.asList(text.split(" "));
		return words;
	}
	
	protected boolean isAssignment(List<String> words){
		return words.contains("is")&&getIndexWordInList("is", words)>0
				&&getIndexWordInList("is", words)<(words.size()-1)
				&&!words.contains("?");
	}
	
	protected int getIndexWordInList(String word, List<String> words){
		int index = -1;
		for(int i = 0; i<words.size();i++){
			if(words.get(i).equals(word)){
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void process(String text, Knowledge knowledge) throws Exception{
		List<String> words = convertListWorks(text);
		AlgoritmoEnum algoritmoEnum = this.discoverAlgoritmo(words.get(2));
		Algoritmo algoritmo = AlgoritmoFactory.factory(words.get(2), algoritmoEnum);
		
		if(algoritmo==null){
			throw new Exception("Erro ao processar o algoritmo:"+words.get(2));
		}
		
		Data data = new Data();
		data.setName(words.get(0));
		data.setValue(algoritmo.getValor());
		knowledge.getDatas().add(data);
	}
	
	public AlgoritmoEnum discoverAlgoritmo(String algoritmoWork){
		AlgoritmoEnum algoritmoEnum = null;
		for(AlgoritmoEnum enume:AlgoritmoEnum.values()){
			Algoritmo algoritmo = AlgoritmoFactory.factory(algoritmoWork, enume);
			if(algoritmo!=null&&algoritmo.getValor()!=null&&algoritmo.getValor().integerValue()!=0){
				System.out.println(algoritmo.getValor());
				algoritmoEnum = enume;
				break;
			}			
		}
		System.out.println(algoritmoEnum);
		return algoritmoEnum;
	}
	
	@Override
	public TypeAnalyzer getType() {
		return TypeAnalyzer.ASSIGNMENT;
	}
}
