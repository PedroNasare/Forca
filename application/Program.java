package application;

import java.util.Scanner;

import entities.Forca;
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Forca forca = new Forca();
		
		System.out.println("Bem-Vindo ao jogo da Forca!");
		System.out.println("A palavra tem " + forca.tela() + " letras.");
		System.out.println();
		
			String n;
			
		while(!forca.testFim()) {
			System.out.println("Número de tentativas: " + forca.getnTentativas());
			System.out.print("Digite uma letra: ");
			n = sc.next();
			System.out.println(forca.palpite(n));
			System.out.println();
			
			if(forca.testFim()){
				System.out.println("Parabéns! Você acertou a palavra.");
				break;
			}
			if(forca.tentativas()) {
				forca.setTestFim();
				System.out.println("Você Perdeu! O numero de tentativas chegou ao limite");
				System.out.println("A palavra era: " + forca.getPalavraOculta());
				break;
			}
			
		}
		sc.close();
	}	
}
