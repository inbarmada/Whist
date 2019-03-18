package whist;
import java.util.ArrayList;

public class Card implements Comparable<Card>
{
  CardSuit mSuit;
	CardRank mRank;

	public Card(int number){
		CardSuit arr[] = CardSuit.values();
        mSuit = arr[number / 13];
       mRank = new CardRank (number % 13);
    }


	public CardSuit Suit(){
		return mSuit;
	}

	public int Rank(){
		return mRank.indexOf();
	}


	// The following comarison used for evaluating a Whist Winner
  static Card Compare(Card one, Card two, CardSuit trump, CardSuit start){
      //Check if anything is null
      if(one == null)
        return two;
      if(two == null)
        return one;
      //Now compare
      Card winner = one;
      if(one.mSuit == two.mSuit){
          if(one.mRank.indexOf() < two.mRank.indexOf())
              winner = two;
      }
      else{
          if(one.mSuit == trump){
            winner = one;
          }else if(two.mSuit == trump){
              winner = two;
		      }else if(two.mSuit != start){
            if(one.mSuit != start)
              winner = null;
            else
              winner = one;
          }else{
            winner = two;
          }
      }
      UI.Log(Severity.DEBUG, "Card::Compare", "Comparing " + one + " to " + two + ", and the winner is..." + winner);
	    return winner;
  }

  public static Card Compare(Card one, Card two, Card three, Card four, CardSuit trump, CardSuit start){
      Card winner1 = Compare(one, two, trump, start);
      Card winner2 = Compare(three, four, trump, start);
      Card winner =  Compare(winner1, winner2, trump, start);
		return winner;
  }

	// The following comarison used for Sorting a Hand
  @Override
	public int compareTo(Card two) {
		if(this.mSuit == ((Card)two).mSuit)
		{
			return ((Card)two).mRank.indexOf() - this.mRank.indexOf();
		}
		else
		{
			return ((Card)two).mSuit.ordinal() - this.mSuit.ordinal();
		}
	}

  @Override
  public String toString(){
      return mSuit.toString() + ":" + mRank.toString();
  }

}
