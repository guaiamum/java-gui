import AppUtils;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author guaiamum
 */
public class App implements ActionListener {
    private boolean _isInteractive = true;
    private String _path_nodes;
    private String _path_branches;
    private String _path_output;

    JFrame frame;
    JPanel mainPanel;
    JButton nodesFileButton, branchesFileButton;
    JTextArea log;
    final JFileChooser fileChooser;
    String[] navigationStack;
    int currentPage;

    AppUtils utils;

    public App(boolean isInteractive, String path_nos, String path_branches, String path_output) {
        _isInteractive = isInteractive;
        _path_nodes = path_nos;
        _path_branches = path_branches;
        _path_output = path_output;
        utils = new AppUtils();

        fileChooser = new JFileChooser();
        frame = this.createFrame();
        mainPanel = new JPanel();

        frame.add(mainPanel, BorderLayout.PAGE_START);
        frame.add(this.createLogger(), BorderLayout.CENTER);

        this.initNavigationStack();
        this.navigateTo(navigationStack[0]);
    }

    private void initNavigationStack() {
        navigationStack = new String[2];
        navigationStack[0] = "main";
        navigationStack[1] = "medidas";
    }

    private void navigateTo(String panel) {
        mainPanel.removeAll();

        switch (panel) {
            case "medidas":
                currentPage = 1;
                mainPanel.add(createMedidasMenu());
                break;
            default:
                currentPage = 0;
                mainPanel.add(createMainMenu());
                break;
        }

        mainPanel.validate();
        mainPanel.repaint();
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure the program exits when the frame closes
        frame.setTitle("Grupo 6");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // This will center the JFrame in the middle of the screen

        frame.setVisible(true);
        return frame;
    }

    private Component createLogger() {
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        log.setFont(new Font("Monospaced", Font.BOLD, 14));
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);

        return new JScrollPane(log);
    }

    private JPanel createMedidasMenu() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("ESCOLHA O TIPO DE MEDIDA A SE FAZER"));
        buttonPanel.add(new JButton("RAMOS"));
        buttonPanel.add(new JButton("NOS"));

        return buttonPanel;
    }

    private JPanel createMainMenu() {
        // Nodes File Button
        nodesFileButton = new JButton("Add nodes file");
        nodesFileButton.addActionListener(this);

        // Branches File Button
        branchesFileButton = new JButton("Add branches file");
        branchesFileButton.addActionListener(this);

        // NEXT STEP
        JButton butt = new JButton("NEXT");
        butt.addActionListener(this);

        // Panel to contain buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nodesFileButton);
        buttonPanel.add(branchesFileButton);

        buttonPanel.add(butt);

        // Add the openButton and the log to this panel.
        // frame.add(buttonPanel, BorderLayout.PAGE_START);
        return buttonPanel;
    }

    private String getNextPage() {
        try {
            return this.navigationStack[currentPage + 1];
        } catch (Error err) {
            return "main";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle open button action.
        if (e.getSource() == nodesFileButton) {
            this._path_nodes = utils.getFile(fileChooser, nodesFileButton);
            log.append("Node file selected: " + this._path_nodes + ".\n");
        } else if (e.getSource() == branchesFileButton) {
            this._path_branches = utils.getFile(fileChooser, nodesFileButton);
            log.append("Branches file selected: " + this._path_branches + ".\n");
        } else if (e.getActionCommand() == "NEXT") {
            this.navigateTo(getNextPage());
        }
    }
}
