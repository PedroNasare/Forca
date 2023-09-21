package application;

import java.util.Scanner;

import entities.Forca;
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Forca forca = new Forca();
			
			forca.PrintMatch();
			String n;
			int nDica = 1;
			
		while(!forca.testFim()) {
			System.out.println("Número de tentativas: " + forca.getnTentativas());
			System.out.println("Dicas disponiveis: " + nDica);
			System.out.print("Digite uma letra: ");
			n = sc.next();
			System.out.println(forca.palpite(n.toLowerCase()));
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
			
			if(n.equals("dica")) {
				System.out.println("Dica: " + String.valueOf(forca.dica()));
				if(nDica != 0) {
					nDica--;
				}
			}
			
		}
		sc.close();
	}	
}
