package com.example.s243476.whist;

public class Bet 
{
    int mValue;
    int mRuler;

	public Bet(int ruler, int value)
	{
        mRuler = ruler;
        mValue = value;
    }
		
	public int Ruler()
	{
		return mRuler;
	}
	
	public int Value()
	{
		return mValue;
	}
	



    public String toString(){
        return "Bet::Ruler " + mRuler + " (" + mValue + ")";
    }

}
