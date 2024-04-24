package src.entities;

public class Card {
    private int up, down, left, right;
    private String color;

    public Card(int up, int down, int left, int right, String color) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.color = color;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showCard(int i) {
        String up = this.up != -1 ? String.valueOf(this.up).replace("10", "A") : " ";
        String down = this.down != -1 ? String.valueOf(this.down).replace("10", "A") : " ";
        String left = this.left != -1 ? String.valueOf(this.left).replace("10", "A") : " ";
        String right = this.right != -1 ? String.valueOf(this.right).replace("10", "A") : " ";

        if (i == 0) {
            System.out.print(this.color + "------- ");
        } else if (i == 1) {
            System.out.print(this.color + "|  " + up + "  | ");
        } else if (i == 2) {
            System.out.print(this.color +"|" + left + "   " + right + "| ");
        } else if (i == 3) {
            System.out.print(this.color + "|  " + down + "  | ");
        } else if (i == 4) {
            System.out.print(this.color + "------- ");
        }

    }
}
