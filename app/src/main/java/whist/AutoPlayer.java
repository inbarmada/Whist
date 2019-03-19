package whist;

import java.lang.String;

public class AutoPlayer extends Player
{
    public Contract Bid(Contract curContract){
  		mCurContract = mCurHand.Evaluate(curContract);
  		UI.Log(Severity.DEBUG, "Player::Bid", this + ": " + mCurHand + "(" + mCurContract + ")");
  		return mCurContract;
    }

    public Contract SetContract(CardSuit trump, int count){
			if(count != 0)
			{
				int level = mCurHand.SetContract(trump, count);
        if(count + level != 13)
				  mCurContract = new Contract(trump, level);
        else
          mCurContract = new Contract(trump, level + 1);//Might want to adjust so it doesn't just add, but think if should add or subtract
			}

			UI.Log(Severity.DEBUG, "Player::SetContract", this.toString() + ", " + mCurContract);
			return mCurContract;
    }

    public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){
      if(roundCards[0] == null && roundCards[1] == null && roundCards[2] == null && roundCards[3] == null)
        return mCurHand.Choose(/*trump*/);
      if(mCurContract.Level() > mNumTakes)
  			return mCurHand.winChoose(roundCards, suit, trump);
  		else
  			return mCurHand.loseChoose(roundCards, suit, trump);
  	}

  	public AutoPlayer(){
  		super();
      }

  	public AutoPlayer(String name){
  		super(name);
      }

}
