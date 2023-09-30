package application;

import java.util.Scanner;

import entities.Forca;
public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Forca forca = new Forca();

		forca.PrintMatch();
		String output;
		int countHints = 1;

		while(!forca.testFim()) {
			if (forca.getnTentativas() >= 2) {
				System.out.println("Tente novamente!");
			}
			System.out.println("Número de tentativas: " + forca.getnTentativas());
			System.out.println("Dicas disponiveis: " + countHints);
			System.out.print("Digite uma letra: ");
			output = input.next();
			System.out.println(forca.palpite(output.toLowerCase()));
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

			if(output.equals("dica")) {
				System.out.println("Dica: " + String.valueOf(forca.dica()));
				if(countHints != 0) {
					countHints--;
				}
			}
		}
		input.close();
	}
}
