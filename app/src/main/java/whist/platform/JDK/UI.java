package whist;
import java.util.Scanner;

enum Severity {
	DEBUG, INFO, WARNING, ERROR, FATAL
}

public class UI
{
    /*static void createCardButton(final Player one, final Card i){
		Log(Severity.DEBUG, "MainSDK::createCardButton", "...");
	}*/

    static void Log(Severity sev, String str1, String str2)
    {
			if(sev.ordinal() >= Severity.INFO.ordinal())
			{
				System.out.println("["+sev.toString()+"] " + str1 + " " + str2);
			}
		}
		static String getPlayerName()
		{
			String name;
			System.out.println("What's your name?");
			Scanner kb = new Scanner(System.in);
			name = kb.nextLine();
			return name;
		}

		String void instructions()
		{
			String answer;
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Hey " + getPlayerName() + ", do you want instructions? [0]Yes, [1]Pass");
			Scanner kb = new Scanner(System.in);
			answer = kb.nextInt();
			if(answer == 1)
			{
				break;
			}
			else
			{
				System.out.println();
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
