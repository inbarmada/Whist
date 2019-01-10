package com.example.s243476.whist;
import java.util.ArrayList;




public class Card implements Comparable<Card> 
{
    CardSuit mSuit;
	CardRank mRank;

	public Card(int number){
        mSuit = new CardSuit(number / 13);
        mRank = new CardRank (number % 13);
    }
	
	
	public int Suit()
	{
		return mSuit.indexOf();
	}
	
	public int Rank()
	{
		return mRank.indexOf();
	}
	

	// The following comarison used for evaluating a Whist Winner
    static Card Compare(Card one, Card two, int trunmp)
    {
        Card winner = one;
        if(one.mSuit.indexOf() == two.mSuit.indexOf())
        {
            if(one.mRank.indexOf() < two.mRank.indexOf())
                winner = two;
        }
        else
        {
            if(two.mSuit.indexOf() == trunmp)
			{
                winner = two;
			}
        }
        UI.log("Card::Compare", "Comparing " + one + " to " + two + ", and the winner is..." + winner);
		return winner;
	}
	
    public static Card Compare(Card one, Card two, Card three, Card four, int trunmp)
    {
        Card winner1 = Compare(one, two, trunmp);
        Card winner2 = Compare(three, four, trunmp);
        Card winner =  Compare(winner1, winner2, trunmp);
		return winner;
    }

	// The following comarison used for Sorting a Hand
    @Override
	public int compareTo(Card two) 
	{
		if(this.mSuit.indexOf() == ((Card)two).mSuit.indexOf())
		{
			return ((Card)two).mRank.indexOf() - this.mRank.indexOf();
		}
		else
		{
			return ((Card)two).mSuit.indexOf() - this.mSuit.indexOf();
		}
	}
	


    @Override
    public String toString(){
        return mSuit.toString() + ":" + mRank.toString();
    }

}
