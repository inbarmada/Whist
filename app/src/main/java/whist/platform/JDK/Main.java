package whist;


public class Main {


    public static void main(String[] args) {
		Game mGame;
    UI.Log(Severity.DEBUG, "MainSDK::main", "Starting...");
 		Player p1 = new RealPlayer(UI.readStng());
		Player p2 = new AutoPlayer();
		Player p3 = new AutoPlayer();
		Player p4 = new AutoPlayer();

        UI.Log(Severity.DEBUG, "MainSDK::main", "Have Created Players");

        mGame = new Game(p1, p2, p3, p4);
        UI.Log(Severity.DEBUG, "MainSDK::main", "Have Created Game");

        UI.Log(Severity.INFO, "Ready to Start", "How many rounds would you like to play?");

        mGame.Play(UI.readInt());
        UI.Log(Severity.DEBUG, "MainSDK::main", "Have game.play-ed");

    }

}
