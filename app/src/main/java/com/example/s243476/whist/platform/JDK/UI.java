package com.example.s243476.whist;
import java.util.Scanner;

enum Severity {
	DEBUG, INFO, WARNING, ERROR, FATAL
}

public class UI {

    static void createCardButton(final Player one, final Card i){
		Log(Severity.DEBUG, "MainSDK::createCardButton", "...");
    }

    static void Log(Severity sev, String str1, String str2)
    {
			if(sev.ordinal() >= Severity.INFO.ordinal())
			{
				System.out.println(str1 + " " + str2);
			}
		}

		static void show()
		{
			/*//beginning of instructions
			System.out.println("*************************************");
			Scanner read = new Scanner(System.in);
			System.out.println("Please enter your name:");
			String name = read.???
			System.out.println("Welcom " + name + ","); //actual instractions
			//end of instructions
			System.out.println("*************************************");*/
			//beginning of game
			System.out.println("*************************************");
			System.out.println("\t\t\tPlayer 3");
			System.out.println("\t\t\t[" + p3.UpdateScore + " / " + p3.Evaluate + "]");
			System.out.println("\n\n");
			System.out.print("Player 2");
			System.out.print("\t\tTrump Suit");
			System.out.println("\t\t\tPlayer 3");
			System.out.print("[" + p2.UpdateScore + " / " + p2.Evaluate + "]");
			if(trump == NT)
			{
			System.out.print("\t\t-");
		}
			else
			{
				System.out.print("\t\t" + Suit.);
			}
			System.out.println("\t\t\t[" + p3.UpdateScore + " / " + p3.Evaluate + "]");

			//end of game
			System.out.println("*************************************");
		}

		static int readInt(){
			Scanner kb = new Scanner(System.in);
			return kb.nextInt();
		}
}
