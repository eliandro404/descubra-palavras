package cacapalavras;

import java.util.Random;
import java.util.Scanner;
import util.Palavras;

public class Tabuleiro {
    Integer tamanho;
    String[] palavrasEscolhidas;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);


    public void definirDificuldade() {
        System.out.println("Escolha a dificuldade do jogo");
        System.out.printf("[Qualquer valor diferente resultará em um tabuleiro FÁCIL]\n" +
                "[1] Fácil (15x15) \n[2] Médio (20x20) \n[3] Difícil (25x25)\n" +
                "////////// ");
        int valor = scan.nextInt();
        if (valor == 2) tamanho = 20;
        else if (valor == 3) tamanho = 25;
        else tamanho = 15;
    }

    public char[][] criarTabuleiro() {
        char[][] tabuleiro = new char[tamanho][tamanho];
        for (int x = 0; x < tamanho; x++){
            for (int y = 0; y < tamanho; y++){
                tabuleiro[x][y] = (char) ('a' + rand.nextInt(25));
            }
        }
        palavrasEscolhidas = new Palavras().retornarPalavras();
        inserirPalavras(tabuleiro, palavrasEscolhidas);
        return tabuleiro;
    }

    private void inserirPalavras(char[][] tabuleiro, String[] palavrasEscolhidas) {

        int linha = rand.nextInt(tamanho);
        int coluna = rand.nextInt(tamanho - palavrasEscolhidas[0].length());

        for (int x = 0; x < palavrasEscolhidas[0].length(); x++) {
            tabuleiro   [linha][coluna+x] = palavrasEscolhidas[0].charAt(x);
        }

        linha = rand.nextInt(tamanho - palavrasEscolhidas[1].length());
        coluna = rand.nextInt(tamanho);
        for (int x = 0; x < palavrasEscolhidas[1].length(); x++) {
            tabuleiro[linha+x][coluna] = palavrasEscolhidas[1].charAt(x);
        }

        linha = rand.nextInt(tamanho - palavrasEscolhidas[2].length());
        coluna = rand.nextInt(tamanho - palavrasEscolhidas[2].length());
        for (int x = 0; x < palavrasEscolhidas[2].length(); x++) {
            tabuleiro[linha+x][coluna+x] = palavrasEscolhidas[2].charAt(x);
        }
    }

    public void imprimirTabuleiro(char[][] tabuleiro) {
        for (int x = 0; x < tamanho; x++){
            for (int y = 0; y < tamanho; y++){
                System.out.printf("%c ", tabuleiro[x][y]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }
}
