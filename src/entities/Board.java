package src.entities;

public class Board {
    private Card[][] board;

    public Board() {
        board = new Card[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Card(-1,-1,-1,-1,"\u001B[37m");
            }
        }
    }

    public boolean addCardOnBoard(Card card, int x, int y) {
        if (this.board[x][y].getColor() != "\u001B[37m") return false;
        this.board[x][y] = card;
        check(x, y);
        return true;
    }

    public void check(int x, int y) {
        Card c = this.board[x][y];
        if (c.getColor() == "\u001B[37m") return;
        if (x-1 >= 0 && this.board[x-1][y].getColor() != "\u001B[37m") {
            if (c.getUp() > this.board[x-1][y].getDown()) {
                this.board[x-1][y].setColor(c.getColor());
            } else if (c.getUp() < this.board[x-1][y].getDown()){
                c.setColor(this.board[x-1][y].getColor());
            }
        }
        if (y-1 >= 0 && this.board[x][y-1].getColor() != "\u001B[37m") {
            if (c.getLeft() > this.board[x][y-1].getRight()) {
                this.board[x][y-1].setColor(c.getColor());
            } else if (c.getLeft() < this.board[x][y-1].getRight()){
                c.setColor(this.board[x][y-1].getColor());
            }

        }
        if (x+1 <= 2 && this.board[x+1][y].getColor() != "\u001B[37m"){
            if (c.getDown() > this.board[x+1][y].getUp()) {
                this.board[x+1][y].setColor(c.getColor());
            } else if (c.getDown() < this.board[x+1][y].getUp()){
                c.setColor(this.board[x+1][y].getColor());
            }
        }
        if (y+1 <= 2 && this.board[x][y+1].getColor() != "\u001B[37m") {
            if (c.getRight() > this.board[x][y+1].getLeft()) {
                this.board[x][y+1].setColor(c.getColor());
            } else if (c.getRight() < this.board[x][y+1].getLeft()){
                c.setColor(this.board[x][y+1].getColor());
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                this.board[i][0].showCard(j);
                this.board[i][1].showCard(j);
                this.board[i][2].showCard(j);
                System.out.println();
            }
        }
    }

    public boolean checkWinner(Player p) {
        int x = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j].getColor() == p.getColor()) x++;
            }
        }
        return x >= 5;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j].getColor() == "\u001B[37m") return false;
            }
        }
        return true;
    }
}
