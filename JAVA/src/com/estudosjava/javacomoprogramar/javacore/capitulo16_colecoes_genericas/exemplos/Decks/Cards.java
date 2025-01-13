package com.estudosjava.javacomoprogramar.javacore.capitulo16_colecoes_genericas.exemplos.Decks;

public class Cards {
    public static enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King }
    public static enum Suit {Clubs, Diamonds, Hearts, Spades};

    private final Face face;
    private final Suit suit;

    public Cards(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString(){
        return String.format("%s of %s", face, suit);
    }
}
