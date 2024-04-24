import classes.Board;
import classes.Player;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player p = new Player("Vermelho", "\u001B[31m");
        Player p2 = new Player("Azul", "\u001B[34m");
        Board tabuleiro = new Board();

        int jogada = 0;
        Scanner sc = new Scanner(System.in);
        while (!tabuleiro.isFull()) {
            System.out.print("\033[H\033[2J");
            tabuleiro.printBoard();
            if (jogada == 0) {
                p.showCards();
                System.out.println("\u001B[37mEscolha uma carta: ");
                int carta = sc.nextInt()-1;
                while (carta <= -1 || carta >= 5 || p.getCards()[carta] == null) {
                    System.out.print("\033[H\033[2J");
                    p.showCards();
                    System.out.println("\u001B[37mCarta inválida, seleciona outra vez: ");
                    carta = sc.nextInt()-1;
                }
                System.out.print("\033[H\033[2J");
                tabuleiro.printBoard();
                System.out.println("\u001B[37mEscolha uma posição: ");
                int pos = sc.nextInt();
                int x = (pos - 1) / 3;
                int y = (pos - 1) % 3;
                while (!tabuleiro.addCardOnBoard(p.getCards()[carta], x, y)) {
                    tabuleiro.printBoard();
                    System.out.println("\u001B[37mEsta posição já tem uma carta. escolha outra: ");
                    pos = sc.nextInt();
                    x = (pos - 1) / 3;
                    y = (pos - 1) % 3;
                }
                p.removeCard(carta);
                jogada++;
            } else {
                p2.showCards();
                System.out.println("\u001B[37mEscolha uma carta: ");
                int carta = sc.nextInt()-1;
                while (carta <= -1 || carta >= 5 || p2.getCards()[carta] == null) {
                    System.out.print("\033[H\033[2J");
                    p2.showCards();
                    System.out.println("\u001B[37mCarta inválida, seleciona outra vez: ");
                    carta = sc.nextInt()-1;
                }
                System.out.print("\033[H\033[2J");
                tabuleiro.printBoard();
                System.out.println("\u001B[37mEscolha uma posição: ");
                int pos = sc.nextInt();
                int x = (pos - 1) / 3;
                int y = (pos - 1) % 3;
                while (!tabuleiro.addCardOnBoard(p2.getCards()[carta], x, y)) {
                    tabuleiro.printBoard();
                    System.out.println("\u001B[37mEsta posição já tem uma carta. escolha outra: ");
                    pos = sc.nextInt();
                    x = (pos - 1) / 3;
                    y = (pos - 1) % 3;
                }
                p2.removeCard(carta);
                jogada--;
            }
        }
        System.out.print("\033[H\033[2J");
        tabuleiro.printBoard();
        if (tabuleiro.checkWinner(p)) System.out.println(p.getColor() + "\nParabéns " + p.getName() + "\n");
        else System.out.println(p2.getColor() + "\nParabéns " + p2.getName() + "\n");
    }
}
