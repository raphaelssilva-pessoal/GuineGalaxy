package com.thoughtworks.codingassignment.guinegalaxy.analyse;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoArabica;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoEnum;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoFactory;
import com.thoughtworks.codingassignment.guinegalaxy.algoritmo.AlgoritmoRomano;
import com.thoughtworks.codingassignment.guinegalaxy.input.Knowledge;

public class AssignmentAnalyzerTest {

	@Test
	public void isAnalyzerComParametroNull(){
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer(); 
		Assert.assertFalse(assignmentAnalyzer.isAnalyzer(null));		
	}
	
	@Test
	public void isAnalyzerComInvalido(){
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer(); 
		Assert.assertFalse(assignmentAnalyzer.isAnalyzer("test teste teste"));		
	}
	
	@Test
	public void isAnalyzerComPergunta(){
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer(); 
		Assert.assertFalse(assignmentAnalyzer.isAnalyzer("teste is 12 ?"));		
	}
	
	@Test
	public void isAnalyzerComParametroValido(){
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer(); 
		Assert.assertTrue(assignmentAnalyzer.isAnalyzer("teste is 12"));		
	}
	@Test
	public void processComNumero() throws Exception{
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer();
		Knowledge knowledge = new Knowledge();
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ARABICA, AlgoritmoArabica.class);
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ROMANO, AlgoritmoRomano.class);
		assignmentAnalyzer.process("teste is 12", knowledge);
		Assert.assertEquals(knowledge.getDatas().get(0).getValue().toString(), "XII");	
	}
	
	@Test
	public void processComAlgoritmo() throws Exception{
		AssignmentAnalyzer assignmentAnalyzer = new AssignmentAnalyzer();
		Knowledge knowledge = new Knowledge();
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ARABICA, AlgoritmoArabica.class);
		AlgoritmoFactory.registerAlgoritmoClass(AlgoritmoEnum.ROMANO, AlgoritmoRomano.class);
		assignmentAnalyzer.process("teste is XIII", knowledge);
		Assert.assertEquals(knowledge.getDatas().get(0).getValue().integerValue(), Integer.valueOf(13));	
	}
	
}
