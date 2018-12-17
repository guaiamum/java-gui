import java.awt.Component;
import javax.swing.JFileChooser;
import java.io.File;

/**
 * AppUtils
 */
public class AppUtils {

    public String getFile (JFileChooser fileChooser, Component button) {
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int returnVal = fileChooser.showOpenDialog(button);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                return file.getAbsolutePath();
            } else {
                throw new Error("Open command cancelled by user.\n");
            }
    }
}
