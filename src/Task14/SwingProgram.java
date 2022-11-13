package Task14;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class SwingProgram extends JFrame {

    private static String pFile = "src/Task14/SwingSettings.properties";

    JPanel backPanel = new JPanel();


    public SwingProgram(){
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(pFile));
        }catch (Exception e){
            e.printStackTrace();
        }

        String mess = p.getProperty("mess","Default");
        String fStyle = p.getProperty("FontStyle", "PLAIN");
        String fName = p.getProperty("fontName", "SansSerif");

        int fSize = Integer.parseInt(p.getProperty("fontSize", "24"));
        int style = 0;
        if (fStyle.equals("BOLD")){
            style = Font.BOLD;
        }

        add(backPanel);
        backPanel.setLayout(new BorderLayout());
        JLabel message = new JLabel(mess,JLabel.CENTER);
        message.setFont(new Font(fName,style,fSize));
        backPanel.add(message);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    public static void main(String[] args) {
        SwingProgram sp = new SwingProgram();
    }
}
