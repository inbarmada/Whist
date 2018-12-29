package com.example.s243476.whist;



public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        for(int i = 0; i<52; i++){
            deck.add(new Card(i));
        }
    }



    public void deal(Hand playerOne, Hand playerTwo, Hand playerThree, Hand playerFour){
        while(!deck.isEmpty()){
            //Give playerOne a random card
            int one = (int)(Math.random()*deck.size());
            playerOne.add(deck.remove(one));

            //Give playerTwo a random card
            int two = (int)(Math.random()*deck.size());
            playerTwo.add(deck.remove(two));

            //Give playerThree a random card
            int three = (int)(Math.random()*deck.size());
            playerThree.add(deck.remove(three));

            //Give playerFour a random card
            int four = (int)(Math.random()*deck.size());
            playerFour.add(deck.remove(four));
        }
    }
}
