import app;

/**
 * Main
 */
public class Main {
    /**
     * Example of entry: java -jar app.jar
     *     ------------ args --------------
     * -t -k XXXX nos.csv ramos.csv output.txt
     * 0  1   2     3         4        5
     * @param args
     */
    public static void main(String[] args) {
        try {
            boolean isInteractive = true;
            String pathNodes = new String();
            String power = new String();
            String pathBranches = new String();
            String pathOutput = new String();
    
            if (args.length > 0) {
                isInteractive = "-n".equals(args[0]);
                if (!isInteractive) {
                    // arg[1] is stupid
                    power = args[2];
                    pathNodes = args[3];
                    pathBranches = args[4];
                    pathOutput = args.length > 3 ? args[5] : null;
                    
                    // argumentHandler(options, paths);
                    return;
                }
                pathNodes = args[1];
                pathBranches = args[2];
                pathOutput = args.length > 3 ? args[3] : null;
            }
            new App(isInteractive, pathNodes, pathBranches, pathOutput);
        }
        catch (Error err) {
            System.out.println(err.getMessage());
            String suggetion = "Make sure you passed all the arguments in the right way." +
                " The app should be called like that: java -jar app.jar -n nos.csv ramos.csv";
            System.out.println(suggetion);
        }
    }
}