package com.example.s243476.whist;


public class Main {


    public static void main(String[] args) {
		Game mGame;
		UI.Log(Severity.DEBUG, "MainSDK::main", "Starting...");

 		Player p1 = new Player("Johnson");
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();

        UI.Log(Severity.DEBUG, "MainSDK::main", "Have Created Players");

        mGame = new Game(p1, p2, p3, p4);
        UI.Log(Severity.DEBUG, "MainSDK::main", "Have Created Game");
		

        mGame.Play(1);
        UI.Log(Severity.DEBUG, "MainSDK::main", "Have game.play-ed");

    }

}
