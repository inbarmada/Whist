package com.example.s243476.whist;

import java.lang.String;

public class AutoPlayer extends Player
{

	  static int mAutoId;

    public Contract Bid(Contract curContract){
  		mCurContract = mCurHand.Evaluate(curContract);
  		UI.Log(Severity.DEBUG, "Player::Bid", this + ": " + mCurHand + "(" + mCurContract + ")");
  		return mCurContract;
    }
}
