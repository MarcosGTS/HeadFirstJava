import java.util.ArrayList;

public class StartupBust {
    GameHelper helper = new GameHelper();
    ArrayList<Startup> startups = new ArrayList<Startup>();
    int numberOfGuesses = 0;

    public void setupGame() {
        Startup s1 = new Startup();
        Startup s2 = new Startup();
        Startup s3 = new Startup();

        s1.setName("Facebook");
        s2.setName("Google");
        s3.setName("Uber");

        startups.add(s1);
        startups.add(s2);
        startups.add(s3);

        for (Startup startup: startups) {
            ArrayList<String> positions = helper.placeStartup(3);
            startup.setLocationCells(positions);
        }
    }

    public void startPlaying() {
        while (!startups.isEmpty()) {
            String guess = helper.getUserInput("Guess: ");
           checkUserGuess(guess);
        }
        finishGame();
    }

    public void checkUserGuess(String guess) {
        String result = "miss";
        numberOfGuesses++;

        for (Startup startup : startups) {
            result = startup.checkYourself(guess);

            if (result.equals("hit")) break;

            if (result.equals("kill")) {
                startups.remove(startup);
                break;
            }
        }

        System.out.println(result);
    }

    public void finishGame() {
        String msg = "";

        if (numberOfGuesses < 10)
            msg = "not so bad";
        else
            msg = "my gramdma can do better";

        System.out.println("Game Over");
        System.out.println(msg);
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setupGame();
        game.startPlaying();
    }
}
