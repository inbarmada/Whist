package whist;

import java.lang.String;

public class RealPlayer extends Player
{
    public Contract Bid(Contract curContract){
      UI.showHand(mCurHand);
      int bid = UI.getBid();
      mCurContract = curContract;
      if(bid > 0){
    		//UI.Log(Severity.INFO, "Player::Bid", this + ": Choose suit (CL-0; DI-1; He-2; SP-3; NT-4):: ");
        int suit = bid - 1;

        int takes = UI.getBidLevel();
        mCurContract = new Contract(CardSuit.values()[suit], takes);
      }
      return mCurContract;
    }

    public Contract SetContract(CardSuit trump, int count){
			if(count != 0)
			{
        UI.Log(Severity.INFO, "Player::Bid", this + ": hand:: " + mCurHand);
        UI.Log(Severity.INFO, "Player::Bid", this + ": Choose takes:: ");
        int takes = UI.readInt();
        while(count + takes == 13){
          UI.Log(Severity.INFO, "Player::Bid", this + "Invalid number - total cannot add up to 13. Please choose again:: ");
          takes = UI.readInt();
        }
				mCurContract = new Contract(trump, takes);
			}

			UI.Log(Severity.DEBUG, "Player::SetContract", this.toString() + ", " + mCurContract);
			return mCurContract;
    }

    public Card Choose(Card[] roundCards, CardSuit suit, CardSuit trump){
  		return mCurHand.realChoose(roundCards, suit);
  	}

  	public RealPlayer(){
  		super();
      }

  	public RealPlayer(String name){
  		super(name);
      }

}
