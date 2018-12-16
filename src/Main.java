import app;

/**
 * Main
 */
public class Main {
    /**
     * Example of entry: java -jar app.jar
     * -t - k XXXX rs_nomedarede_nos.csv rs_nomedarede_ramos.csv,
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            boolean isInteractive = true;
            String pathNodes = new String();
            String pathBranches = new String();
            String pathOutput = new String();
    
            if (args.length > 0) {
                isInteractive = "-n".equals(args[0]);
                pathNodes = args[1];
                pathBranches = args[2];
                pathOutput = args.length > 3 ? args[3] : null;
    
                if (!isInteractive) {
                    // argumentHandlerFunction(options, paths);
                    return;
                }
            }
            new App(isInteractive, pathNodes, pathBranches, pathOutput);
        }
        catch (Error err) {
            String suggetion = "Make sure you passed all the arguments in the right way." +
                " The app should be called like that: java -jar app.jar -n nos.csv ramos.csv";
            System.out.print(suggetion);
        }
    }
}