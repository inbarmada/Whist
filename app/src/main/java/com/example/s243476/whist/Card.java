package com.example.s243476.whist;
import java.util.ArrayList;
public class Card implements Comparable<Card> 
{
    int mValue;
    int mType;
	String[] mTypesStr = { "CL", "DI", "HE", "SP"};
	String[] mValueStr = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	public Card(int number){
        mType = number / 13;
        mValue = (number % 13);
    }
	
	
	public int Type()
	{
		return mType;
	}
	public int Value()
	{
		return mValue;
	}
	

	// The following comarison used for evaluating a Whist Winner
    static Card Compare(Card one, Card two, int ruler)
    {
        Card winner = one;
        if(one.mType == two.mType)
        {
            if(one.mValue < two.mValue)
                winner = two;
        }
        else
        {
            if(two.mType == ruler)
			{
                winner = two;
			}
        }
        UI.log("Card::Compare", "Comparing " + one + " to " + two + ", and the winner is..." + winner);
		return winner;
	}
	
    public static Card Compare(Card one, Card two, Card three, Card four, int ruler)
    {
        Card winner1 = Compare(one, two, ruler);
        Card winner2 = Compare(three, four, ruler);
        Card winner =  Compare(winner1, winner2, ruler);
		return winner;
    }

	// The following comarison used for Sorting a Hand
    @Override
	public int compareTo(Card two) 
	{
		if(this.mType == ((Card)two).mType)
		{
			return this.mValue - ((Card)two).mValue;
		}
		else
		{
			return this.mType - ((Card)two).mType;
		}
	}
	


    public String toString(){
        return mTypesStr[mType] + ":" + mValueStr[mValue];
    }

}
