package com.example.s243476.whist;

import java.util.ArrayList;
import java.util.Collections;

class Hand {
	ArrayList<Card>[]  mCardsBySuit;

    public Hand()
	{
		int i;
		mCardsBySuit = new ArrayList[4];
		for(i=0; i<4; i++)
		{
			mCardsBySuit[i] = new ArrayList<Card>();
		}
    }

    //Add a card to mCards (for use when dealt a card)
    public void Add(Card c)
	{
		//UI.log("Hand::Add", "CARD="+card);
        mCardsBySuit[c.Suit()].add(c);
    }


    //Choose a card, if not automatic
    public void Remove(Card c)
	{
		//UI.log("Hand::Remove", "CARD="+card);
        mCardsBySuit[c.Suit()].remove(c);
    }

	public void Sort()
	{
		int i;
		for(i=0; i<4; i++)
		{
			Collections.sort(mCardsBySuit[i]);
		}
	}

	public Card Choose()
	{
		Card c = mCardsBySuit[0].get(0);
        UI.log("choose(c)", c.toString());
        Remove(c);
        return c;
    }


/*
	public Contract Evaluate(Contract curContract)
	{
		int i;
		int[] valuePerRank = {
			0, //2 
			0, //3
			0, //4 
			0, //5
			0, //6
			0, //7
			0, //8
			0, //9
			0, //10
			1, //J
			4, //Q
			8, //K
			10,//A };
		int[] suitCtr  = {0, 0, 0, 0, 0};
		int[] suitHighs  = {0, 0, 0, 0, 0};
		int highs  = 0;
		int maxSuitCntr  = 0;
		int preferredRuler = -1;
		int maxEvaluation;
		Contract newContract;
			
		for (i = 0; i < mCards.size(); i++)
		{
			Card card = mCards.get(i);
			int suit = card.Suit();
			int rank = card.Rank();
			suitCtr[suit] ++;
			suitHighs[suit] += valuePerRank[rank];
			highs += valuePerRank[rank];
		}
		for(i = 0; i < 4; i++)
		{
			if(suitCtr[i] > maxSuitCntr)
			{
				maxSuitCntr = suitCtr[i];
				preferredRuler = i;
			}
		}
		if(highs > (maxSuitCntr*10) + highs - suitHighs[preferredRuler]) 
		{
			maxEvaluation = highs;
			preferredRuler = 4; // No Trump
		}
		else
		{
			highs -= suitHighs[preferredRuler];
			maxEvaluation = (maxSuitCntr*10) + highs;
		}
		
		// don't count the same cards twice
		
		UI.log("Hand::Evaluate", "" + highs + "+" + maxSuitCntr + "=" + maxEvaluation);
		UI.log("Hand::Evaluate", "preferred ruler = " + preferredRuler);
		
		if((maxEvaluation > curContract.Value()) || 
			((curContract.Value() == maxEvaluation) && (preferredRuler > curContract.Ruler())))
		{
			newContract = new Contract(preferredRuler, maxEvaluation);
		}
		else
		{
			newContract = curContract;
		}
		return newContract;

	}
*/
	public int EvaluteSuit(ArrayList<Card> cards, int trump)
	{
		int size = cards.size();
		if (size == 0)
			return 0;
		boolean isTrump = (trump == cards.get(0).Suit());
		boolean isNoTrump = (trump == 4);
		
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
		UI.log("Hand::EvaluteSuit", cards.toString() + " - " + trump + " -> " +  eval);
		return eval;
	}
	
	public Contract Evaluate(Contract curContract)
	{
		int curTrump = curContract.Trump();
		int curEvaluation = curContract.Level();
		
		int update = 0;
		UI.log("Hand::Evalute", "start...");
		
		
		for(int trump=0; trump<5; trump ++)
		{
			int eval = 0;
			for(int suit=0; suit<4; suit++)
			{
				eval += EvaluteSuit(mCardsBySuit[suit], trump);
			}
			if((eval > curEvaluation) || ((eval == curEvaluation) && (trump > curTrump)))
			{
				curEvaluation = eval;
				curTrump = trump;
				update = 1;
			}
		}
		if (update > 0)
		{
			Contract newContract = new Contract(curTrump, curEvaluation);
			UI.log("Hand::Evalute", newContract.toString());
			return newContract;
		}
		else
		{
			return curContract;
		}	
	}
	
    //Choose a card if automatic
    public Card Choose(int suit){
        UI.log("choose(suit)", "Heyo I'm in choose(suit)");

        for(int i = mCardsBySuit[suit].size() - 1; i >= 0; i--){
            UI.log("choose(suit)", "Heyo I'm still there in choose(suit)" + i + mCardsBySuit[suit].get(i));

            if(mCardsBySuit[suit].get(i).Suit() == suit){
                return mCardsBySuit[suit].remove(i);
            }
            UI.log("choose(suit)", "Heyo I'm still in choose(suit)");

        }
        return mCardsBySuit[suit].remove(0);
    }

    //return a list of all cards to show the (non-automatic) player
    public ArrayList<Card> showCards(){
        UI.log("showCards", "Heyo I'm in showCards");

        return mCardsBySuit[0];
    }
	
    public String toString()
	{
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
