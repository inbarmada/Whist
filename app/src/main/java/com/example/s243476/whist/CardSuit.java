package com.example.s243476.whist;

enum CardSuit 
{
	CL, DI, HE, SP, NT; 
}
/*
public class CardSuit implements Comparable<CardSuit>
{
	final String[] mStr = { "CL", "DI", "HE", "SP", "NT" };
	int mValue;

	public CardSuit(int value)
	{
        mValue = value;
    }
		
	public int indexOf()
	{
		return mValue;
	}

	@Override
	public int compareTo(CardSuit two) 
	{
		return this.mValue - ((CardSuit)two).mValue;
	}
	
    public String toString(){
        return mStr[mValue];
    }
}
*/