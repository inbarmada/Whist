package whist;
import java.util.Scanner;

enum Severity {
	DEBUG, INFO, WARNING, ERROR, FATAL
}

public class UI
{
    static void Log(Severity sev, String str1, String str2)
    {
			if(sev.ordinal() >= Severity.INFO.ordinal())
			{
				System.out.println("["+sev.toString()+"] " + str1 + " " + str2);
			}
		}
		static String getPlayerName()
		{
			System.out.print("\033[H\033[2J");
			System.out.println("What's your name?");
			String namn;
			Scanner kb = new Scanner(System.in);
			namn = kb.nextLine();
			return namn;
		}

		static void instructions()
		{
			Scanner kb = new Scanner(System.in);
			System.out.flush();
			int answer;
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Welcome! Do you want instructions? [0]Pass, [1]Yes");
			answer = kb.nextInt();
			if(answer != 0)
			{
				System.out.println("This game is played by 4 players. Each player gets 13 cards, organized by suits and values, with ace being the highest");
				System.out.println("value available. The first thingdone is finding the Trump Suit. This suit is the one that will beat all other suits. ");
				System.out.println("You don't have to bid for the trump suit, but if you have in one suit than other, like 6 cards in one suit, it can help");
				System.out.println("you win rounds. You place a bid by deciding on the suit that you want to be the trum suit, and how many takes you can ");
				System.out.println("take using this suit. You 'take' a round by putting the highest number card in either the suit the first person to go");
				System.out.println("had, or the Trump Suit. After everyone placed theie bid, the game starts, with the person who bid on the Trump Suit. ");
				System.out.println("From there it's basically like a regular card game, where evyone put a card down and one wins the round. However, you");
				System.out.println("need to take only the number of rounds you bid on in order to win. In the end, the one with the closet number to his ");
				System.out.println("bid wins. You are now ready to start. Good luck!");
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		}

		static int getNumOfRounds()
		{
			int nRounds;
	        System.out.println("How many rounds would you like to play?");

			do
			{
				nRounds = UI.readInt();
			} while(nRounds <= 0);
			return nRounds;
		}

		static void showHand(Hand hand)
		{
			System.out.println(hand);
		}
		static int getBid()
		{
			int bid;
			System.out.println("Place your bet:");
			do{
				System.out.println("[0]Pass or Choose suit: [1]CL, [2]DI [3]HE [4]SP [5]NT");
				bid = UI.readInt();
			} while (bid<0 || bid >6);
			return bid;
        }

		static int getBidLevel()
		{
			int level;
			do{
				System.out.println("Choose number of takes");
				level = UI.readInt();
			} while (level<4 || level >13);
			return level;
		}

		static void showPlay(Player[] mPlayers)
		{
			{
				// Clear the screen
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("***************************************************************************************************************************");
				System.out.println("                                                            "+mPlayers[2].Name());
				System.out.println("                                                               " + mPlayers[2].GameScore());
				System.out.println("                                                              " + mPlayers[2]);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println(" "+ mPlayers[1].Name() + "                                                      Trump Suit                                             " + mPlayers[3].Name());
				System.out.println("   " + mPlayers[1].GameScore()+ "                                                                                                                 " + mPlayers[3].GameScore());
				System.out.print("  " + mPlayers[1]+ "                                                         " + mPlayers[0].mCurContract.Trump()+ "                                                   " + mPlayers[3]);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("                                                               " + mPlayers[0].Name());
				System.out.println("                                                                " + mPlayers[0].GameScore());
				System.out.println("                                                               " + mPlayers[0]);
				System.out.println(mPlayers[0].mCurHand);
				//end of game
				System.out.println("***************************************************************************************************************************");
			}
		}

		/*public void winning()
		{
			System.out.println("***************************************************************************************************************************");
			winner();
			System.out.println("***************************************************************************************************************************");
		}*/

		static int readInt(){
			Scanner kb = new Scanner(System.in);
			return kb.nextInt();
		}
}
