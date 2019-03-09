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
			if(sev.ordinal() >= Severity.DEBUG.ordinal())
			{
				System.out.println(str1 + " " + str2);
			}
		}

		static int readInt(){
			Scanner kb = new Scanner(System.in);
			return kb.nextInt();
		}
}
