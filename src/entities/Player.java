package src.entities;

import java.util.Random;

public class Player {
    private String name;
    private int score;
    private Card[] cards;
    private String color;

    public Player(String name, String color) {
        this.name = name;
        this.score = 0;
        this.color = color;
        this.cards = new Card[5];
        randomCards();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getColor() {
        return color;
    }

    public Card[] getCards() {
        return cards;
    }

    private void randomCards() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int r1 = r.nextInt(10)+1;
            int r2 = r.nextInt(10)+1;
            int r3 = r.nextInt(10)+1;
            int r4 = r.nextInt(10)+1;
            Card c = new Card(r1,r2,r3,r4,this.color);
            cards[i] = c;
        }
    }

    public void removeCard(int pos) {
        this.cards[pos] = null;
        for (int i = pos; i < this.cards.length; i++) {
            if (i+1 >= this.cards.length) return;
            Card aux = this.cards[i+1];
            this.cards[i+1] = this.cards[i];
            this.cards[i] = aux;
        }
    }

    public void showCards() {
        for (int i = 0; i < 5; i++) {
            if (this.cards[0] != null) this.cards[0].showCard(i);
            if (this.cards[1] != null) this.cards[1].showCard(i);
            if (this.cards[2] != null) this.cards[2].showCard(i);
            if (this.cards[3] != null) this.cards[3].showCard(i);
            if (this.cards[4] != null) this.cards[4].showCard(i);
            System.out.println();
        }
    }
}