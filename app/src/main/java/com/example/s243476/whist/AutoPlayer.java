package com.example.s243476.whist;

import java.lang.String;

public class AutoPlayer extends Player
{
    public Contract Bid(Contract curContract){
  		mCurContract = mCurHand.Evaluate(curContract);
  		UI.Log(Severity.DEBUG, "Player::Bid", this + ": " + mCurHand + "(" + mCurContract + ")");
  		return mCurContract;
    }

  	public AutoPlayer(){
  		super();
      }

  	public AutoPlayer(String name){
  		super(name);
      }

}
