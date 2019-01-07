package com.example.s243476.whist;


public class Main {


    public static void main(String[] args) {
		Game mGame;
        UI.log("MainSDK::main", "Starting...");

 		Player p1 = new Player("Johnson");
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();

        UI.log("MainSDK::main", "Have Created Players");

        mGame = new Game(p1, p2, p3, p4);
        UI.log("MainSDK::main", "Have Created Game");
		

        mGame.Play(13);
        UI.log("MainSDK::main", "Have game.play-ed");

    }

}
