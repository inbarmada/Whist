package com.example.s243476.whist;

import java.lang.String;

public class Player 
{
	// Player Profile
	int    mAuto;
	String mName;
	int    mTotalScore;
	static int mId = 0;
	// Player Profile
	Hand   mCurHand;
	Hand   mCurBet;

	static int mAutoId;

	public Player()
	{
		mAuto = 1;
        mName = "auto" + mId++;
        mTotalScore = 0;
    }
	
	public Player(String name)
	{
		mAuto = 0;
        mName = name;
        mTotalScore = 0;
    }

    public void SetHand(Hand h){
	    mCurHand = h;
    }

    public Card choose(Card c){
		return mCurHand.choose(c);
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
		return mTotalScore += gameScore;
    }

    public int Declare()
	{
		return 0;
    }
	
    public int DebugInfo()
	{
		UI.log("Player::Declare", this + ": " + mCurHand);
		return 0;
    }
	
    public String toString()
	{
		return mName + "(" + mTotalScore + ")";
    }
	
}
