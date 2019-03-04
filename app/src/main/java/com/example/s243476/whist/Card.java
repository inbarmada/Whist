package com.example.s243476.whist;
import java.util.ArrayList;

public class Card implements Comparable<Card>
{
  CardSuit mSuit;
	CardRank mRank;

	public Card(int number){
		CardSuit arr[] = CardSuit.values();
        mSuit = arr[number / 13];
       mRank = new CardRank (number % 13);
    }


	public CardSuit Suit(){
		return mSuit;
	}

	public int Rank(){
		return mRank.indexOf();
	}


	// The following comarison used for evaluating a Whist Winner
  static Card Compare(Card one, Card two, CardSuit trump){
      Card winner = one;
      if(one.mSuit == two.mSuit){
          if(one.mRank.indexOf() < two.mRank.indexOf())
              winner = two;
      }
      else{
          if(two.mSuit == trump){
              winner = two;
		      }
      }
      UI.Log(Severity.DEBUG, "Card::Compare", "Comparing " + one + " to " + two + ", and the winner is..." + winner);
	    return winner;
  }

  public static Card Compare(Card one, Card two, Card three, Card four, CardSuit trump){
      Card winner1 = Compare(one, two, trump);
      Card winner2 = Compare(three, four, trump);
      Card winner =  Compare(winner1, winner2, trump);
		return winner;
  }

	// The following comarison used for Sorting a Hand
  @Override
	public int compareTo(Card two) {
		if(this.mSuit == ((Card)two).mSuit)
		{
			return ((Card)two).mRank.indexOf() - this.mRank.indexOf();
		}
		else
		{
			return ((Card)two).mSuit.ordinal() - this.mSuit.ordinal();
		}
	}

  @Override
  public String toString(){
      return mSuit.toString() + ":" + mRank.toString();
  }

}
