package whist;

import java.util.*;
import java.util.Collections;
import java.util.Scanner;

class Hand {
	ArrayList<Card>[]  mCardsBySuit;

  public Hand(){
		int i;
		mCardsBySuit = new ArrayList[4];
		for(i=0; i<4; i++){
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

	public Card CardsPrint(Card[] roundCards)
	{
		return roundCards;
	}

	public Card realChoose(Card[] roundCards, CardSuit suit){
		System.out.println("PlayedCards " + Arrays.toString(roundCards));
		Card c = null;

		//System.out.println("Your hand " + toString());
		int tries = 0;
		do{
			if(tries >= 1)
				UI.Log(Severity.INFO, "Hand::realChoose", "You have the starting suit so you must use it!! Pick again");

			int cardNum = UI.readInt();


			int cntr = 1;
	    for(int curSuit = 0; curSuit < 4; curSuit++){
				for(int i = 0; i < mCardsBySuit[curSuit].size(); i++){
					if(cntr == cardNum){
						cntr ++;

						c = mCardsBySuit[curSuit].get(i);
						break;
					}
					cntr ++;

				}
			}
			tries++;

		}while(suit != null && c.Suit() != suit && !mCardsBySuit[suit.ordinal()].isEmpty());

		Remove(c);
		return c;
	}

	public Card Choose(){
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
	public Card winChoose(Card[] roundCards, CardSuit suit, CardSuit trump){
		ArrayList<Card>  cards = mCardsBySuit[suit.ordinal()];
		Card c = null;

		Card highest = c.Compare(roundCards[0], roundCards[1], roundCards[2], roundCards[3], trump, suit);
		//Check if you have the leading suit
		if(!cards.isEmpty()){
			/*System.out.println("hello");
			System.out.println(highest + " : " + highest.Rank() + " .. " + cards.get(0).Rank() + "first - " + (highest.Suit() != trump) + " sec - " + (highest.Rank() > cards.get(0).Rank()));*/
			if(highest.Suit() != trump && highest.Rank() < cards.get(0).Rank()){
				c = cards.get(0);
			}else{
				c = cards.get(cards.size() - 1);
			}
		}
		else if(trump.ordinal() != 4){
				//Check if you have trumps
				if(!mCardsBySuit[trump.ordinal()].isEmpty()){

					//Check if a trump has been placed, and if so check what the max is
					int maxTrump = 0;
					if(highest.Suit() == trump){
						for(Card i : mCardsBySuit[trump.ordinal()]){
							if(i.Rank() > highest.Rank()){
								c = i;
								break;
							}
						}

					}else{
						c = mCardsBySuit[trump.ordinal()].get(mCardsBySuit[trump.ordinal()].size() - 1);
					}
				}else{
					int min = 13;
					for(ArrayList<Card> i : mCardsBySuit){
						if(i.isEmpty())
							break;
						if(i.get(0).Suit().ordinal() == trump.ordinal())
							break;
						if(i.get(i.size() - 1).Rank() < min)
							c = i.get(i.size() - 1);
					}
				}


			}if(c == null){
				for(int i = 0; i < 4; i++){
					if(mCardsBySuit[i].size() != 0){
						c = mCardsBySuit[i].get(mCardsBySuit[i].size() - 1);
					}
				}
			}

		Remove(c);
    return c;
  }

	public Card loseChoose(Card[] roundCards, CardSuit suit, CardSuit trump){
		ArrayList<Card>  cards = mCardsBySuit[suit.ordinal()];
		Card c = null;

		Card highest = c.Compare(roundCards[0], roundCards[1], roundCards[2], roundCards[3], trump, suit);
		//Check if you have the leading suit
		if(!cards.isEmpty()){
			for(Card i : cards)
				if(i.Rank() < highest.Rank()){
					c = i;
					break;
				}
		}
		else{
			int highestRank = 0;
			for(int i = 0; i < 4; i++){
				if(mCardsBySuit[i].size() != 0 && i != trump.ordinal() && mCardsBySuit[i].get(0).Rank() > highestRank){
					c = mCardsBySuit[i].get(0);
					highestRank = c.Rank();
				}
			}
		}if(c == null){
				for(int i = 0; i < 4; i++){
					if(mCardsBySuit[i].size() != 0){
						c = mCardsBySuit[i].get(0);
					}
				}
			}

		Remove(c);
    return c;
	}

	public int EvaluteSuit(ArrayList<Card> cards, CardSuit trump){
		int size = cards.size();
		if (size == 0)
			return 0;
		//trump == current Suit
		boolean isTrump = (trump == cards.get(0).Suit());
		//trump = noTrump (no leading suit)
		boolean isNoTrump = (trump == CardSuit.NT);

		int eval = 0;
		for(int i=0; i<size; i++)
		{
			Card c = cards.get(i);
			int rank = c.Rank();
			if((rank + size) >= 13)
			{
				if(isTrump || isNoTrump)
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
		UI.Log(Severity.DEBUG,"Hand::EvaluteSuit", cards.toString() + " -> " +  eval);
		return eval;
	}

	//for bid
	public Contract Evaluate(Contract curContract){
		CardSuit curTrump = curContract.Trump();
		int curEvaluation = curContract.Level();

		int update = 0;


		for(int trumpId =0; trumpId < 5; trumpId ++)
		{
			CardSuit trump = CardSuit.values()[trumpId];
			UI.Log(Severity.DEBUG,
				"Hand::Evalute", "Trump: "+ trump);
			int eval = 0;
			for(int suit=0; suit<4; suit++)
			{
				eval += EvaluteSuit(mCardsBySuit[suit], trump);
			}
			UI.Log(Severity.DEBUG,
				"Hand::Evalute", trump.toString() + " -> " +  eval);

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
		UI.Log(Severity.DEBUG, "Hand::SetContract", "start...");

		for(int suit=0; suit<4; suit++)
		{
			eval += EvaluteSuit(mCardsBySuit[suit], trump);
		}
		return eval;
	}

  //return a list of all cards to show the (non-automatic) player
  public ArrayList<Card> showCards(){
    UI.Log(Severity.DEBUG, "Hand::showCards", "return cards");
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
