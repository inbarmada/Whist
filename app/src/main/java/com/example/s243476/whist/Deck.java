package com.example.s243476.whist;



public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        for(int i = 0; i<52; i++){
            deck.add(new Card(i));
        }
    }



    public void deal(Hand[] hands){
		int i = 0;
        while(!deck.isEmpty()){
            //Give playerOne a random card
            int rnd = (int)(Math.random()*deck.size());
            hands[i].add(deck.remove(rnd));
			
			if(i == 3)
				i = 0;
			else
				i++;
        }
		// simple verification
		for(i=0; i<4; i++)
		{
			assert(hands[i].size == 13);
		}
    }
}
