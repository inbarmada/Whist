package whist;
import java.util.*;

public class Game{

	Contract mCurContract;
	int mCurWinner;
  Player[] mPlayers = new Player[4];
	int mNextToPlay = 0;
	int mNextToBet = 0;

	public Game(Player p1, Player p2, Player p3, Player p4){
		mPlayers[0] = p1;
		mPlayers[1] = p2;
		mPlayers[2] = p3;
		mPlayers[3] = p4;
		mNextToPlay = 0;
		mNextToBet = 0;

	}

	public void Play(int numOfRounds){
	    for(int i=0; i < numOfRounds; i++)
		{
			Play1Round();
			for(int j = 0; j < 4; j++){
				mPlayers[j].UpdateGameScore();
			}
		}
		for(int i = 0; i < 4; i++){
			UI.Log(Severity.INFO, "Game::Final Scores", mPlayers[i].Name() + "'s GameScore is " + mPlayers[i].mGameScore);
		}
	}

	private void Debug(){
		int i;
		for(i=0; i<4; i++)
		{
			mPlayers[i].DebugInfo();
		}

	}

	private void Play1Round(){
		int i;
		UI.Log(Severity.INFO, "Game::PlayRound", "Starting...");
    Deck deck = new Deck();
	  Hand[] Hands = new Hand[4];

		for(i=0; i<4; i++){
			Hands[i] = new Hand();
			mPlayers[i].SetHand(Hands[i]);
		}
        //Deal the cards
        deck.Deal(Hands);
				//Debug();

				//Bid
        UI.Log(Severity.INFO, "Game::PlayRound", "Time to bid (for the Trump Suit)...");
        Bidding();


				//Set contract
        UI.Log(Severity.INFO, "Game::PlayRound", "Time to set the Contracts...");
        ContractsSetting();

				//UI.show(mPlayers);


				//Play rounds!
        UI.Log(Severity.INFO, "Game::PlayRound", "Let's start playing!..");
				playing();

    }
		/*public int[][] getPlayerInfo()
		{
			int[][] playerInfo = new int[4][2];
			String[] suits = new int["CL", "DI", "HE", "SP", "NT"]
			int num = 0;
			for(Player pl : mPlayer)
			{
				playerInfo[num][0] = player.curContract.
			}
			return playerInfo;
		}*/

	private void Bidding(){
		int i = mNextToBet % 4;
		mNextToBet ++;
		int passCount = 0;
		int[] passTable = {0,0,0,0};
		Contract curContract = new Contract (CardSuit.NT,3);
		Contract newContract;
		int winner = -1;

		do
		{
			if(passTable[i%4] == 0)
			{
				Player player = mPlayers[i%4];
				newContract = player.Bid(curContract);
				UI.Log(Severity.INFO, "Game:Bidding", "cur: " + curContract + ", New: " + newContract);
				if(newContract.equals(curContract))
				{
					UI.Log(Severity.INFO, "Game:Bidding", "Player " + player + " Passed (" + passCount + ")");
					passTable[i%4] = 1;
					passCount ++;
				}
				else
				{
					curContract = newContract;
					winner = i%4;
					UI.Log(Severity.INFO, "Game:Bidding", "Player " + player + " Bid: " + curContract);
				}
			}
			i++;
		} while(passCount < 4);
		if(winner >= 0)
		{
			UI.Log(Severity.INFO, "Game:Bidding", "Winner: " + mPlayers[winner] + ", Contract: " + curContract);
			mCurWinner = winner;
			mCurContract = curContract;
		}
		else
		{
			UI.Log(Severity.INFO, "Game:Bidding", "No Winner");
		}
	}

	private void ContractsSetting(){
		CardSuit trump = mCurContract.Trump();
		int count = 0;
		for(int i=0; i<4; i++)
		{
			Contract contract = mPlayers[(mCurWinner+i)%4].SetContract(trump, count);
			count += contract.Level();
			UI.Log(Severity.INFO, "Game::SetContract", mPlayers[(mCurWinner+i)%4].toString() + " contract: " + contract + " (Total=" + count + ")");
		}
	}

	private void playing(){
				UI.Log(Severity.INFO, "Game::Playing", "in playing");
				mCurWinner = 0;
				//Play 13 rounds
				for(int i = 0; i < 13; i++){
					UI.showPlay(mPlayers);

					//Each person chooses a card and adds it to roundCards
					Card[] roundCards = new Card[4];
					CardSuit trump = mCurContract.Trump();
					//UI.Log(Severity.INFO, "Game::Playing", "trump " + trump + trump.ordinal());

					int j = mCurWinner;
					CardSuit start = null;
					do{

						if(j%4 == 0){
							//Card c = mPlayers[0].Choose(trump);
							Card c = mPlayers[0].mCurHand.realChoose(roundCards, start);
							UI.Log(Severity.INFO, "Game", "You chose " + c);
							roundCards[0] = c;
						}
						else{
							if(start == null){
								roundCards[j%4] = mPlayers[j%4].Choose(roundCards, start, trump);

							}
							else{
								roundCards[j%4] = mPlayers[j%4].Choose(roundCards, start, trump);

							}
						}
						if(j == mCurWinner)
							start = roundCards[j%4].Suit();
							//roundCards has been filled
							//UI.Log(Severity.INFO, "Game::Playing", "hand:" + mPlayers[j%4].mCurHand + " - " + roundCards[j%4]);

							j++;
					}while(j%4 != (mCurWinner));

					//Choose winner and update scores
					getRoundCards(roundCards[0], roundCards[1], roundCards[2], roundCards[3], trump, start);
					UI.Log(Severity.INFO, "Game::Playing", "Chosen cards are:" + Arrays.toString(roundCards));

					//Print scores
					for(Player player : mPlayers){
						UI.Log(Severity.INFO, "Game::Player", player.Name() + "'s Total score is: " + player.NumTakes());
					}
				}
				winner();


	}

  public void getRoundCards(Card one, Card two, Card three, Card four, CardSuit trump, CardSuit start){
		UI.Log(Severity.INFO, "Game::getRoundCards", "In getRoundCards");

		Card winner = Card.Compare(one, two, three, four, trump, start);
		if(winner.equals(one)){
			mPlayers[0].UpdateScore(1);
			mCurWinner = 0;
		}else if(winner.equals(two)){
		   mPlayers[1].UpdateScore(1);
			 mCurWinner = 1;
		}else if(winner.equals(three)){
		   mPlayers[2].UpdateScore(1);
			 mCurWinner = 2;
		}else if(winner.equals(four)){
		   mPlayers[3].UpdateScore(1);
			 mCurWinner = 3;
		 }
  }

	public void winner(){
		int index = -1;
		int maxPoints = 0;
		for(int i = 0; i < 4; i++){
			if(mPlayers[i].NumTakes() > maxPoints){
				maxPoints = mPlayers[i].NumTakes();
				index = i;
			}
		}
		UI.Log(Severity.INFO, "Round over. ", "Winner is: " + mPlayers[index].Name());

	}
}
