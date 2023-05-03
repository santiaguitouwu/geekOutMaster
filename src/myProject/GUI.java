package myProject;

;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JButton lanzar, ayuda, salir;
    private JPanel dadosInactivos, dadosActivos, dadosUsados, tablero;

    /**
     * Constructor of myProject.GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Master");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new GridBagLayout());
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the myProject.GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        //Create Listener Object and Control Object
        //Set up JComponent
        //JPanel panelHeader = new JPanel();
        //panelHeader.setLayout(new GridBagLayout());
        headerProject = new Header("GeekMaster Game", Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridwidth=4;

        this.getContentPane().add(headerProject,gbc);

        JButton help = new JButton("?");
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx=0;
        gbc1.gridy=1;
        gbc1.gridwidth=1;
        gbc1.fill=GridBagConstraints.NONE;
        gbc1.anchor=GridBagConstraints.LINE_START;
        this.getContentPane().add(help, gbc1);

        JButton salir = new JButton("Salir");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx=3;
        gbc2.gridy=1;
        gbc2.gridwidth=1;
        gbc2.fill=GridBagConstraints.NONE;
        gbc2.anchor=GridBagConstraints.LINE_END;
        this.getContentPane().add(salir, gbc2);

        JPanel dadosInactivos = new JPanel();
        dadosInactivos.setPreferredSize(new Dimension(300,200));
        dadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx=0;
        gbc3.gridy=2;
        gbc3.gridwidth=2;
        gbc3.fill=GridBagConstraints.BOTH;
        gbc3.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosInactivos,gbc3);

        JPanel dadosActivos = new JPanel();
        dadosActivos.setPreferredSize(new Dimension(300,200));
        dadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx=2;
        gbc4.gridy=2;
        gbc4.gridwidth=2;
        gbc4.gridheight=2;
        gbc4.fill=GridBagConstraints.BOTH;
        gbc4.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosActivos,gbc4);

        JPanel dadosUsados = new JPanel();
        dadosUsados.setPreferredSize(new Dimension(300,200));
        dadosUsados.setBorder(BorderFactory.createTitledBorder("Dados Usados"));
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx=0;
        gbc5.gridy=3;
        gbc5.gridwidth=2;
        gbc5.fill=GridBagConstraints.BOTH;
        gbc5.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosUsados,gbc5);

        JButton lanzar = new JButton("Lanzar");
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx=1;
        gbc6.gridy=4;
        gbc6.gridwidth=2;
        gbc6.weightx=0.5;
        gbc6.fill=GridBagConstraints.BOTH;
        gbc6.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(lanzar, gbc6);

        JPanel tablero = new JPanel();
        tablero.setPreferredSize(new Dimension(450,200));
        tablero.setBorder(BorderFactory.createTitledBorder("Tablero de Puntuación"));
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx=0;
        gbc7.gridy=5;
        gbc7.gridwidth=4;
        gbc7.fill=GridBagConstraints.BOTH;
        gbc7.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(tablero,gbc7);





        //Change this line if you change JFrame Container's Layout


    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by myProject.GUI class
     */
    private class Escucha {

    }
}