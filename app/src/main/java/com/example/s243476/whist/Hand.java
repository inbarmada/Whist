package com.example.s243476.whist;

import java.util.ArrayList;
import java.util.Collections;

class Hand {
    ArrayList<Card>  mCards;

    public Hand(){
        mCards = new ArrayList<Card>();
    }

    //Add a card to mCards (for use when dealt a card)
    public void Add(Card card){
		//UI.log("Hand::Add", "CARD="+card);
        mCards.add(card);
    }

    //Choose a card, if not automatic
    public Card choose(Card card){
        UI.log("choose(card)", "Heyo I'm in choose(card)");
        mCards.remove(card);
        return card;
    }

	public Bet Evaluate(Bet curBet)
	{
		int i;
		int[] typeCtr  = {0, 0, 0, 0};
		int[] typeHighs  = {0, 0, 0, 0};
		int highs  = 0;
		int maxCntr  = 0;
		int preferredRuler = -1;
		Bet newBet;
		
		for (i = 0; i < mCards.size(); i++)
		{
			Card card = mCards.get(i);
			int type = card.Type();
			int val = card.Value();
			typeCtr[type] ++;
			if(val >= 11) // "ACES" + "KINGS"
			{
				typeHighs[type] ++;
				highs ++;
			}
		}
		for(i = 0; i < 4; i++)
		{
			if(typeCtr[i] > maxCntr)
			{
				maxCntr = typeCtr[i];
				preferredRuler = i;
			}
		}
		// don't count the same cards twice
		highs -= typeHighs[preferredRuler];
		
		UI.log("Hand::Evaluate", "" + highs + "+" + maxCntr + "=" + (highs + maxCntr));
		UI.log("Hand::Evaluate", "preferred ruler = " + preferredRuler);
		
		if((highs + maxCntr > curBet.Value()) || 
			((curBet.Value() == highs + maxCntr) && (preferredRuler > curBet.Ruler())))
		{
			newBet = new Bet(preferredRuler, highs + maxCntr);
		}
		else
		{
			newBet = curBet;
		}
		return newBet;
	}
	
    //Choose a card if automatic
    public Card Choose(int type){
        UI.log("choose(type)", "Heyo I'm in choose(type)");

        for(int i = mCards.size() - 1; i >= 0; i--){
            UI.log("choose(type)", "Heyo I'm still there in choose(type)" + i + mCards.get(i));

            if(mCards.get(i).mType == type){
                return mCards.remove(i);
            }
            UI.log("choose(type)", "Heyo I'm still in choose(type)");

        }
        return mCards.remove(0);
    }
	public void Sort()
	{
		Collections.sort(mCards);
	}

    //return a list of all cards to show the (non-automatic) player
    public ArrayList<Card> showCards(){
        UI.log("showCards", "Heyo I'm in showCards");

        return mCards;
    }
	
    public String toString()
	{
		String str = "";
        for(int i = 0; i < mCards.size(); i++)
		{
			str += "[" + i + "]" + mCards.get(i) + ", ";
		}
		return str;
	}
}
