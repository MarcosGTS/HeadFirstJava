public class SimpleStartup {
    private int[] locationCells;
    private int numOfHits = 0;

    String checkYouself(int guess) {
        
        if (guess < 0 || guess > 6) return "INVALID GUESS";

        for (int i = 0; i < locationCells.length; i++) {
            int location = locationCells[i];

            if (location != guess) continue;

            locationCells[i] = -1; 
            numOfHits += 1;

            if (numOfHits == 3) return "kill";
            else return "hit";
        }

        return "miss";
    }

    void setLocationsCells(int[] locations) {
        locationCells = locations;
    }
}