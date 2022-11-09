package PropertiesLesson;

import javax.swing.*;
import java.awt.Font;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest extends JFrame {

    private static String pFile = "src/PropertiesLesson/DemoProperties.properties";

    public PropertiesTest(){
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(pFile));
        }catch (Exception e){
            e.printStackTrace();
        }
        String mess = p.getProperty("message", "Hello");
        JLabel l = new JLabel(mess, JLabel.CENTER);
        add(l);
        l.setOpaque(true);
        String fName = p.getProperty("fontName", "Serif");
        String fStyle = p.getProperty("fontStyle", "PLAIN");
        int ifStyle;
        if (fStyle.equals("BOLD")){
            ifStyle = Font.BOLD;
        }
        else if(fStyle.equals("ITALIC")){
            ifStyle = Font.ITALIC;
        }
        else ifStyle = Font.PLAIN;

        int fSize = Integer.parseInt(p.getProperty("fontSize", "24"));
        l.setFont(new Font(fName, ifStyle, fSize));
        setSize(400,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        PropertiesTest test = new PropertiesTest();
    }
}
