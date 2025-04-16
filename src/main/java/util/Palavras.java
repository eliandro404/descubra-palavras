package util;

import java.util.Random;

public class Palavras {
    String[] palavras = {"Cachorro", "Amigo", "Rápido", "Escola", "Mundo",
            "Futuro", "Lágrima", "Verão", "Coração", "Árvore",
            "Livro", "Janela", "Mesa", "Estrada", "Sol",
            "Mar", "Cidade", "Sorriso", "Feliz", "Amor",
            "Paz", "Luz", "Sombra", "Caminho", "Estrela",
            "Vento", "Gato", "Lutar", "Reino", "Céu", "Fruta"};

    Random rand = new Random();

    public String retornarPalavra() {
        return palavras[rand.nextInt(palavras.length)];
    }

    public String[] retornarPalavras(int quantidade) {
        String[] palavrasEscolhidas = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            palavrasEscolhidas[i] = palavras[rand.nextInt(palavras.length)];
        }

        return palavrasEscolhidas;
    }

    public String embaralharPalavra(String palavra) {
        char[] palavraArray = palavra.toCharArray();
        for (int i = 0; i < palavraArray.length; i++) {
            int indexAleatorio = rand.nextInt(palavraArray.length);
            char temp = palavraArray[i];
            palavraArray[i] = palavraArray[indexAleatorio];
            palavraArray[indexAleatorio] = temp;
        }
        return new String(palavraArray);
    }

    public static void printPadronizado(String palavra) {
        int totalDashes = 42 - palavra.length() - 2;
        int tracosAtras = totalDashes / 2;
        int tracosFrente = totalDashes - tracosAtras;
        System.out.println("-".repeat(tracosAtras) + " [" + palavra + "] " + "-".repeat(tracosFrente));
    }
}