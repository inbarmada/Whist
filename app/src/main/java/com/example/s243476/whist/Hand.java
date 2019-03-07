package com.example.s243476.whist;

import java.util.ArrayList;
import java.util.Collections;

class Hand {
	ArrayList<Card>[]  mCardsBySuit;

  public Hand(){
		int i;
		mCardsBySuit = new ArrayList[4];
		for(i=0; i<4; i++)
		{
			mCardsBySuit[i] = new ArrayList<Card>();
		}
  }

  //Add a card to mCards (for use when dealt a card)
  public void Add(Card c){
		//UI.Log(Severity.DEBUG, "Hand::Add", "CARD="+card);
    mCardsBySuit[c.Suit().ordinal()].add(c);
  }


  //Choose a card, if not automatic
  public Card Remove(Card c){
		//UI.Log(Severity.DEBUG, "Hand::Remove", "CARD="+card);
    mCardsBySuit[c.Suit().ordinal()].remove(c);
		return c;
  }

	public void Sort(){
		int i;
		for(i=0; i<4; i++)
		{
			Collections.sort(mCardsBySuit[i]);
		}
	}

	public Card Choose(/*CardSuit trump*/){
		int index = 0;
		int max = 0;
		for(int i = 0; i < 4; i++){
			if(max < mCardsBySuit[i].size()){
				max = mCardsBySuit[i].size();
				index = i;
			}
		}
		return Remove(mCardsBySuit[index].get(max - 1));
	}

	//Choose a card if automatic
	public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){

		if(suit.ordinal() == 5){

		}else{
			ArrayList<Card>  cards = mCardsBySuit[suit.ordinal()];
			UI.Log(Severity.INFO, "Hand::Choose", "1");

			//Check if have the suit in use
			Card c = null;
			if(!cards.isEmpty()){
				c = cards.get(cards.size() - 1);
				UI.Log(Severity.INFO, "Hand::Choose", "2");

				//if(c.Rank() > Card.Compare(roundCards[0], roundCards[1], roundCards[2], roundCards[3]))
			}else{
				//Check if you have trumps
				if(!mCardsBySuit[trump.ordinal()].isEmpty()){
					UI.Log(Severity.INFO, "Hand::Choose", "3");

					//Check if a trump has been placed, and if so check what the max is
					int maxTrump = 0;
					for(Card i : roundCards){
						if(i.Suit().ordinal() == trump.ordinal())
						System.out.println(i);
							if(i.Rank() > maxTrump)
								maxTrump = i.Rank();
								UI.Log(Severity.INFO, "Hand::Choose", "4");

					}
					for(Card i : mCardsBySuit[trump.ordinal()]){
						if(i.Rank() > maxTrump){
							c = i;
							break;
						}
						UI.Log(Severity.INFO, "Hand::Choose", "5");

					}
				}else{
					UI.Log(Severity.INFO, "Hand::Choose", "6");

					int min = 13;
					for(ArrayList<Card> i : mCardsBySuit){
						if(i.isEmpty())
							break;
						if(i.get(0).Suit().ordinal() == trump.ordinal())
							break;
						if(i.get(0).Rank() < min)
							c = i.get(0);
						UI.Log(Severity.INFO, "Hand::Choose", "7");

					}
				}


			}
		UI.Log(Severity.INFO, "Hand::Choose", "8");
		}
		Remove(c);
    return c;
  }

	public int EvaluteSuit(ArrayList<Card> cards, CardSuit trump){
		int size = cards.size();
		if (size == 0)
			return 0;
		boolean isTrump = (trump == cards.get(0).Suit());
		boolean isNoTrump = (trump == CardSuit.NT);

		int eval = 0;
		for(int i=0; i<size; i++)
		{
			Card c = cards.get(i);
			int rank = c.Rank();
			if((rank + size) >= 13)
			{
				if(isTrump || isNoTrump || (rank > 9))
				{
					eval++;
				}
			}
			else
			{
				if (isTrump && i > 3)
				{
					eval ++;
				}
			}
		}
		com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "Hand::EvaluteSuit", cards.toString() + " -> " +  eval);
		return eval;
	}

	public Contract Evaluate(Contract curContract){
		CardSuit curTrump = curContract.Trump();
		int curEvaluation = curContract.Level();

		int update = 0;


		for(int trumpId =0; trumpId <5; trumpId ++)
		{
			CardSuit trump = CardSuit.values()[trumpId];
			com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "Hand::Evalute", "Trump: "+ trump);
			int eval = 0;
			for(int suit=0; suit<4; suit++)
			{
				eval += EvaluteSuit(mCardsBySuit[suit], trump);
			}
			com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "Hand::Evalute", trump.toString() + " -> " +  eval);

			if((eval > curEvaluation) || ((eval == curEvaluation) && (trump.compareTo(curTrump) > 0)))
			{
				curEvaluation = eval;
				curTrump = trump;
				update = 1;
			}
		}
		if (update > 0)
		{
			Contract newContract = new Contract(curTrump, curEvaluation);
			//UI.Log(Severity.DEBUG, "Hand::Evalute", newContract.toString());
			return newContract;
		}
		else
		{
			return curContract;
		}
	}

	public int SetContract(CardSuit trump, int count){
		int eval = 0;
		com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "Hand::SetContract", "start...");

		for(int suit=0; suit<4; suit++)
		{
			eval += EvaluteSuit(mCardsBySuit[suit], trump);
		}
		return eval;
	}


  //Choose a card if automatic
	/*
  public Card Choose(CardSuit suit){
		ArrayList<Card>  cards = mCardsBySuit[suit.ordinal()];
    com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "choose(suit)", "Heyo I'm in choose(suit)");

    for(int i = cards.size() - 1; i >= 0; i--){
        com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "choose(suit)", "Heyo I'm still there in choose(suit)" + i + cards.get(i));

        if(cards.get(i).Suit() == suit){
            return cards.remove(i);
        }
        com.example.s243476.whist.UI.Log(com.example.s243476.whist.Severity.DEBUG, "choose(suit)", "Heyo I'm still in choose(suit)");

    }
    return cards.remove(0);
	}*/

  //return a list of all cards to show the (non-automatic) player
  public ArrayList<Card> showCards(){
    UI.Log(com.example.s243476.whist.Severity.DEBUG, "Hand::showCards", "return cards");
    return mCardsBySuit[0];
  }

  public String toString(){
		String str = "";
		int cntr = 1;
        for(int suit = 0; suit < 4; suit++)
		{
			for(int i = 0; i < mCardsBySuit[suit].size(); i++)
			{
				str += "[" + cntr + "]" + mCardsBySuit[suit].get(i) + ", ";
				cntr ++;
			}
		}
		return str;
	}
}
