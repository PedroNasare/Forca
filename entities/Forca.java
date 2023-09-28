package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forca{
	
	StringBuilder sb = new StringBuilder();
	
	List<String> palavras= new ArrayList<>(List.of("java", "computador", "boca", "ber�o", "naruto", "onepiece", "luffy", "nami","zoro", "sanji", "chopper", "brook", "franky"));
	
	Random random = new Random();
	
	int palavra = random.nextInt(palavras.size());
	String palavraOculta = palavras.get(palavra);
	char[] palavraAdivinhada = new char[palavraOculta.length()];
	private int nTentativas = 0;
	private int nDica = 0;
	
	public Forca() {
	}
	
	public String getPalavraAdivinhada() {
		return String.valueOf(palavraAdivinhada);
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
		return  sb.toString();
	}
	
	public char[] setPalavraAdivinhada() {
		for(int i=0; i < palavraOculta.length();i++) {
			palavraAdivinhada[i] = palavraOculta.charAt(i);
		}
		return palavraAdivinhada;
	}
	
	public char[] palpite(String letra) {
		boolean letraEncontrada = false;
		
		for(int i=0; i < palavraOculta.length();i++) {
			if(letra.equals(palavraOculta)) {
				letraEncontrada = true;
				return setPalavraAdivinhada();
			}
			if(letra.length() == 1 && letra.charAt(0) == palavraOculta.charAt(i)) {
				palavraAdivinhada[i] = letra.charAt(0);
				letraEncontrada = true;
			}
		}
			if(letraEncontrada && letra.length() > 1) {
				System.out.println("Palavra incorreta! Tente novamente.");
			}
		return palavraAdivinhada;
	}
	
	public boolean testFim() {
		return palavraOculta.equals(new String(palavraAdivinhada));
	}
	
	public boolean setTestFim() {
		return testFim() == true;
	}
	
	public boolean tentativas() {
		if(getnTentativas() >= 10) {
			return true;
		}else {
			 nTentativas++;
		}
		return false;
	}
	
	public void PrintMatch() {
		System.out.println("Bem-Vindo ao jogo da Forca!");
		System.out.println("A palavra tem " + tela() + " letras.");
		System.out.println();
	}
	
	public char[] dica() {
		List<Integer> letrasOcultas = new ArrayList<>();
		
		if(nDica >= 1) {
			System.out.println("Limite de dicas alcan�ado!");
			setnTentativas(getnTentativas() - 1); 
			return palavraAdivinhada;
		}
		for(int i=0;i < palavraOculta.length();i++) {
			if(palavraAdivinhada[i] == '-') {
				letrasOcultas.add(i);
			}
		}
		Integer n = letrasOcultas.get(random.nextInt(letrasOcultas.size()));
		for(int i=0;i < palavraOculta.length();i++) {
			if(palavraOculta.charAt(i) == palavraOculta.charAt(n)) {
				palavraAdivinhada[i] = palavraOculta.charAt(n);
			}
		}
		if(palavraOculta.equals(String.valueOf(palavraAdivinhada))) {
			System.out.println("Parab�ns! Voc� acertou a palavra.");
		}
		nDica++;
		
		return palavraAdivinhada;
	}
	
}
