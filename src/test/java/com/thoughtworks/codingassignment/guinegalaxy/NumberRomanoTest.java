package com.thoughtworks.codingassignment.guinegalaxy;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class NumberRomanoTest {
	@Test
	public void gerarNumeroPeloAlgoritmo(){
		String algoritmo = "MII";//1002		
		NumberRomano numberRomano = new NumberRomano(algoritmo);		
		assertEquals(numberRomano.toString(), "MII");
	}
	
	@Test
	public void gerarNumeroPeloValorInteiro(){
		int valor = 1002;		
		NumberRomano numberRomano = new NumberRomano(valor);		
		assertEquals(numberRomano.toString(), "MII");	
		
	}
	
	@Test
	public void converterParaInteiro(){
		String algoritmo = "CMIV";//906		
		assertEquals(NumberRomano.integerValue(algoritmo), 904);
		
	}
	
	@Test
	public void retornaVazioAoConverterNumeroNegativa(){
		int valor = -1002;		
		NumberRomano numberRomano = new NumberRomano(valor);		
		assertEquals(numberRomano.toString(), "");	
		
	}
}
