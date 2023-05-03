package myProject;

;

import javax.swing.*;
import java.awt.*;


public class Header extends JLabel {
    /**
     * Constructor of the myProject.Header class
     * @param title String that contains myProject.Header text
     * @param colorBackground Color object to be assigned for the myProject.Header background
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(255,255,255));
        this.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
