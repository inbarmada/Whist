package whist;
import java.util.Scanner;

enum Severity {
	DEBUG, INFO, WARNING, ERROR, FATAL
}

public class UI
{
	static String name = "";
    /*static void createCardButton(final Player one, final Card i){
		Log(Severity.DEBUG, "MainSDK::createCardButton", "...");
	}*/

    static void Log(Severity sev, String str1, String str2)
    {
			if(sev.ordinal() >= Severity.INFO.ordinal())
			{
				System.out.println(str1 + " " + str2);
			}
		}
		static String readStng(){
			System.out.println("What's your name?");
			Scanner kb = new Scanner(System.in);
			name = kb.nextLine();
			return name;
		}

		static void show(Player[] mPlayers)
		{
			{
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("***************************************************************************************************************************");
				System.out.println("                                                            Player 3");
				System.out.println("                                                              " + mPlayers[2]);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Player 2                                                   Trump Suit                                             Player 4");
				System.out.print("  " + mPlayers[1]+ "                                                                                                              " + mPlayers[3]);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("                                                                 " + name);
				System.out.println("                                                                 " + mPlayers[0]);
				System.out.println(mPlayers[0].mCurHand);
				//end of game
				System.out.println("***************************************************************************************************************************");
			}
		}

		static int readInt(){
			Scanner kb = new Scanner(System.in);
			return kb.nextInt();
		}
}
