package whist;

public class CardRank
{
	final String[] mStr = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	int mValue;

	public CardRank(int value){
  	mValue = value;
  }

	public int indexOf(){
		return mValue;
	}

  public String toString(){
    return mStr[mValue];
  }
}
