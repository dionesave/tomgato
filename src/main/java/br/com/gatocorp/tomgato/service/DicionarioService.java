package br.com.gatocorp.tomgato.service;

import org.springframework.stereotype.Component;

import br.com.gatocorp.tomgato.http.DicionarioRequestHttp;

@Component
public class DicionarioService {
	
	private DicionarioRequestHttp dicionarioRequestHttp = new DicionarioRequestHttp();
	
	public String findDicionario(String palavra) {
		String word = palavra;
		StringBuilder resultBuilder = new StringBuilder();
		String result = "";
		boolean encontrado = false;
		Long index = 1L;
		
		while(!encontrado) {
			String itemDicionario = dicionarioRequestHttp.acessoGET(index);
			
			 if (itemDicionario.compareToIgnoreCase(word) >= 0) {
				resultBuilder.append("A palavra '").append(word).append("' está na posição: ").append(index);
		 		encontrado = true;
	         } else if(itemDicionario.compareToIgnoreCase(word) >= 1) {
	        	 resultBuilder.append("A palavra '").append(word).append("' estaria na posição: ").append(index);
	             encontrado = true;
		 	 } 
			 
	         index++;
		}
		
		result = resultBuilder.toString();
		
		
		return result;
	}
	
}
