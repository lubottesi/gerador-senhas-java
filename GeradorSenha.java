package GeradorSenhasFortes;
import java.util.Random;

public class GeradorSenha implements Runnable {
    private int quantidade;
    private int tamanho;

    public GeradorSenha(int quantidade, int tamanho) {
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantidade; i++) {
            System.out.println(gerarSenha(tamanho));
        }
    }

    private String gerarSenha(int tamanho) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        Random rand = new Random();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            senha.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }

        return senha.toString();
    }
}



