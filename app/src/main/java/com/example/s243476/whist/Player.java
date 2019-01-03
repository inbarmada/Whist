package com.example.s243476.whist;/*package com.example.s243476.whist;

<<<<<<< HEAD*/
import java.string;



public class Player 
{
	// Player Profile
	int    mAuto;
	String mName;
	int    mTotalScore;
	
	// Player Profile
	Hand   mCurHand;
	Hand   mCurBet;

	static int mAutoId;

	public Player()
	{
		mAuto = 1;
        mName = "auto".mId++;
        mTotalScore = 0;
    }
	
	public Player(String name)
	{
		mAuto = 0;
        mName = name;
        mTotalScore = 0;
    }
	
	public String Name()
	{
		return mName;
    }
	
	public int TotalScore()
	{
		return mTotalScore;
    }

	public int UpdateScore(int gameScore)
	{
		mTotalScore += gameScore;
    }
}
