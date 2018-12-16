
//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {
    private boolean _isInteractive = true;
    private String _path_nos = "";
    private String _path_branches = "";
    private String _path_output = "";

    public App(boolean isInteractive, String path_nos, String path_branches, String path_output) {
        _isInteractive = isInteractive;
        _path_nos = path_nos;
        _path_branches = path_branches;
        _path_output = path_output;

        this.OpenWindow();
    }

    public void OpenWindow () {
        JFrame guiFrame = new JFrame();

        // make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Grupo 6");
        guiFrame.setSize(500, 500);
        guiFrame.setLocationRelativeTo(null); // This will center the JFrame in the middle of the screen

        // Options for the JComboBox
        String[] mainOptions = { "Nodes", "Network" };
        // The first JPanel contains a JLabel and JCombobox
        final JPanel comboPanel = new JPanel();
        JLabel comboLbl = new JLabel("Fruits:");
        JComboBox fruits = new JComboBox(mainOptions);
        comboPanel.add(comboLbl);
        comboPanel.add(fruits);
        // Create the second JPanel. Add a JLabel and JList and
        // make use the JPanel is not visible.
        final JPanel listPanel = new JPanel();
        listPanel.setVisible(false);
        JLabel listLbl = new JLabel("Vegetables:");
        listPanel.add(listLbl);
        JButton vegFruitBut = new JButton("Fruit or Veg");
        // JList vegs = new JList(vegOptions);
        // vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        // listPanel.add(vegs);

        // The ActionListener class is used to handle the
        // event that happens when the user clicks the button.
        // As there is not a lot that needs to happen we can
        // define an anonymous inner class to make the code simpler.
        vegFruitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // When the fruit of veg button is pressed
                // the setVisible value of the listPanel and
                // comboPanel is switched from true to
                // value or vice versa.
                listPanel.setVisible(!listPanel.isVisible());
                comboPanel.setVisible(!comboPanel.isVisible());
            }
        });
        // The JFrame uses the BorderLayout layout manager.
        // Put the two JPanels and JButton in different areas.
        guiFrame.add(comboPanel, BorderLayout.NORTH);
        guiFrame.add(listPanel, BorderLayout.CENTER);
        guiFrame.add(vegFruitBut, BorderLayout.SOUTH);
        // make sure the JFrame is visible
        guiFrame.setVisible(true);
    }
}
