package GeradorSenhasFortes;

import java.util.Scanner;

public class GeradorSenhaMain {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o total de senhas a gerar: ");
        int totalSenhas = scanner.nextInt();

        System.out.print("Digite o tamanho de cada senha: ");
        int tamanhoSenha = scanner.nextInt();

         // Define o número de threads baseado nos núcleos da CPU
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Utilizando " + numThreads + " threads com base nos nucleos disponiveis.");

        int senhasPorThread = totalSenhas / numThreads;
        int senhasRestantes = totalSenhas % numThreads;

        for (int i = 0; i < numThreads; i++) {
            int quantidade = senhasPorThread + (i < senhasRestantes ? 1 : 0); // distribui as senhas igualmente
            Thread t = new Thread(new GeradorSenha(quantidade, tamanhoSenha));
            t.start();
        }

        scanner.close();
    }   
}



