import app;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            boolean isInteractive = "-n".equals(args[0]);
            String path_nodes = args[1];
            String path_branches = args[2];
            String path_output = args.length > 3 ? args[3] : null;
        }
        new App();
    }
}