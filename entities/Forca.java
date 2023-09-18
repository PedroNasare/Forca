package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forca{
	
	StringBuilder sb = new StringBuilder();
	
	List<String> palavras= new ArrayList<>(List.of("java", "computador", "boca", "berço", "naruto", "onepiece", "luffy", "nami","zoro", "sanji", "chopper", "brook", "franky"));
	
	Random random = new Random();
	
	int palavra = random.nextInt(palavras.size());
	String palavraOculta = palavras.get(palavra);
	char [] palavraAdivinhada = new char[palavraOculta.length()];
	int nTentativas = 0;
	
	public Forca() {
	}
	
	public int getnTentativas() {
		return nTentativas;
	}

	public void setnTentativas(int nTentativas) {
		this.nTentativas = nTentativas;
	}

	public String getPalavraOculta() {
		return palavraOculta;
	}

	public void setPalavraOculta(String palavraOculta) {
		this.palavraOculta = palavraOculta;
	}

	public String tela() {
		for(int i =0; i < palavraOculta.length();i++) {
			char n = palavraAdivinhada[i] = '-';
			sb.append(n);
		}
		return sb.toString();
	}
	
	public char[] palpite(String letra) {
		for(int i=0; i < palavraOculta.length();i++) {
			char letras = palavraOculta.charAt(i);
			char letraAdivinhada = palavraOculta.charAt(0);
			
			if(letra.equals(new String(palavraAdivinhada))) {
				palavraAdivinhada[i] = letraAdivinhada;
				return palavraAdivinhada;
			}
			
			if(letra.charAt(0) == palavraOculta.charAt(i)) {
				palavraAdivinhada[i] = letras;
			}
		}
		return palavraAdivinhada;
	}
	
	public boolean testFim() {
		return palavraOculta.equals(new String(palavraAdivinhada));
	}
	
	public boolean setTestFim() {
		return testFim() == true;
	}
	
	public void tentativas() {
		if(nTentativas > 6) {
			setTestFim();
		}else {
			nTentativas++;
		}
		
	}
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
}
