public class SimpleStartupTestDrive {
    public static void main(String args[]) {
        SimpleStartup dot = new SimpleStartup();

        int[] locations = {2, 3, 4};
        dot.setLocationsCells(locations);

        int userGuess = 2;
        String result = dot.checkYouself(userGuess);

        String testResult = "Failed";
        if (result.equals("hit")) {
            testResult = "Passed";
        }

        System.out.println(testResult);
    
    }
}
