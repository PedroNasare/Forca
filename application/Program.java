package application;

import java.util.Scanner;

import entities.Forca;
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Forca forca = new Forca();
		
		System.out.println(forca.getPalavraOculta());
		
		System.out.println(forca.tela());
		
			String n;
			
		while(!forca.testFim()) {
			Forca.clearScreen();
			forca.tentativas();
			
			System.out.println("Número de tentativas: " + forca.getnTentativas());
			System.out.print("Digite uma letra: ");
			n = sc.next();
			System.out.println(forca.palpite(n));
			System.out.println();
			
			if(forca.testFim()){
				System.out.println("Fim de Jogo!");
				break;
			}
			if(!forca.testFim() && forca.getnTentativas() == 6) {
				System.out.println("O numero de tentativas chegou ao limite");
				break;
			}
			
		}
		sc.close();
	}	
}
