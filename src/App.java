package src;

import src.entities.Board;
import src.entities.Player;

import java.util.Scanner;

public class App {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite o nome do jogador 1: ");
        String n1 = scan.nextLine();
        System.out.println("Digite o nome do jogador 2: ");
        String n2 = scan.nextLine();

        System.out.println();

        Player p1 = new Player(n1, "\u001B[33m");
        Player p2 = new Player(n2, "\u001B[34m");
        int turn = 0;
        Board board = new Board();

        while (!board.isFull()) {
            board.printBoard();
            if (turn == 0) {
                p1.showCards();
                System.out.println("\u001B[37mEscolha uma carta: ");
                int card = scan.nextInt()-1;
                
                while (card <= -1 || card >= 5 || p1.getCards()[card] == null) {
                    p1.showCards();
                    System.out.println("\u001B[37mCarta inválida, seleciona outra vez: ");
                    card = scan.nextInt()-1;
                }
                board.printBoard();
                System.out.println("\u001B[37mDigite a linha que deseja: ");
                int x = scan.nextInt() -1;
                System.out.println("\u001B[37mDigite a coluna que deseja: ");
                int y = scan.nextInt() -1;
                while (!board.addCardOnBoard(p1.getCards()[card], x, y)) {
                    board.printBoard();
                    System.out.println("\u001B[37mEsta posição já tem uma carta... ");
                    System.out.println("\u001B[37mDigite a linha que deseja: ");
                    x = scan.nextInt() -1;
                    System.out.println("\u001B[37mDigite a coluna que deseja: ");
                    y = scan.nextInt() - 1;
                }
                p1.removeCard(card);
                turn++;
            } else {
                p2.showCards();
                System.out.println("\u001B[37mEscolha uma carta: ");
                int carta = scan.nextInt()-1;
                while (carta <= -1 || carta >= 5 || p2.getCards()[carta] == null) {
                    p2.showCards();
                    System.out.println("\u001B[37mCarta inválida, seleciona outra vez: ");
                    carta = scan.nextInt()-1;
                }
                board.printBoard();
                System.out.println("\u001B[37mDigite a linha que deseja: ");
                int x = scan.nextInt() - 1;
                System.out.println("\u001B[37mDigite a coluna que deseja: ");
                int y = scan.nextInt() - 1;
                while (!board.addCardOnBoard(p2.getCards()[carta], x, y)) {
                    board.printBoard();
                    System.out.println("\u001B[37mEsta posição já tem uma carta... ");
                    System.out.println("\u001B[37mDigite a linha que deseja: ");
                    x = scan.nextInt() - 1;
                    System.out.println("\u001B[37mDigite a coluna que deseja: ");
                    y = scan.nextInt() - 1;
                }
                p2.removeCard(carta);
                turn--;
            }
        }
        board.printBoard();
        if (board.checkWinner(p1)) System.out.println(p1.getColor() + "\nGANHADOR: " + p1.getName() + "\n");
        else System.out.println(p2.getColor() + "\nGANHADOR: " + p2.getName() + "\n");
    }
}
