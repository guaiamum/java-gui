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
    JButton nodesFileButton, branchesFileButton;
    JTextArea log;
    final JFileChooser fileChooser = new JFileChooser();
    
    AppUtils utils = new AppUtils();

    public App (boolean isInteractive, String path_nos, String path_branches, String path_output) {
        _isInteractive = isInteractive;
        _path_nodes = path_nos;
        _path_branches = path_branches;
        _path_output = path_output;

        this.createFrame();
        this.navigateTo("main");
    }

    private void navigateTo (String panel) {
        frame.getContentPane().removeAll();

        switch (panel) {
            case "medidas":
                // createMedidasMenu();
                break;
            default:
                createMainMenu();
                break;
        }

        
        frame.getContentPane().repaint();
        frame.setVisible(true);
    }
    private void createFrame() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure the program exits when the frame closes
        frame.setTitle("Grupo 6");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // This will center the JFrame in the middle of the screen
    }

    private void createMainMenu() {
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        log.setFont(new Font("Monospaced", Font.BOLD, 14));
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        JScrollPane logScrollPane = new JScrollPane(log);

        // Nodes File Button
        nodesFileButton = new JButton("Add nodes file");
        nodesFileButton.addActionListener(this);

        // Branches File Button
        branchesFileButton = new JButton("Add branches file");
        branchesFileButton.addActionListener(this);

        // Panel to contain buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nodesFileButton);
        buttonPanel.add(branchesFileButton);

        // Add the openButton and the log to this panel.
        frame.add(buttonPanel, BorderLayout.PAGE_START);
        frame.add(logScrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle open button action.
        if (e.getSource() == nodesFileButton) {
            this._path_nodes = utils.getFile(fileChooser, nodesFileButton);
            log.append("Opening: " + this._path_nodes + ".\n");
        }
        if (e.getSource() == branchesFileButton) {
            this._path_branches = utils.getFile(fileChooser, nodesFileButton);
            log.append("Opening: " + this._path_branches + ".\n");
        }
    }
}
