package myProject;

;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JButton lanzar, ayuda, salir;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10, textoAyuda;
    private JPanel dadosInactivos, dadosActivos, dadosUsados, tablero;
    private ImageIcon imageDado;
    private Escucha escucha;
    private Model model;
    private JFrame ventanaAyuda;


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

        ayuda = new JButton("?");
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx=0;
        gbc1.gridy=1;
        gbc1.gridwidth=1;
        gbc1.fill=GridBagConstraints.NONE;
        gbc1.anchor=GridBagConstraints.LINE_START;
        this.getContentPane().add(ayuda, gbc1);

        salir = new JButton("Salir");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx=3;
        gbc2.gridy=1;
        gbc2.gridwidth=1;
        gbc2.fill=GridBagConstraints.NONE;
        gbc2.anchor=GridBagConstraints.LINE_END;
        this.getContentPane().add(salir, gbc2);

        dadosInactivos = new JPanel();
        dadosInactivos.setPreferredSize(new Dimension(400,200));
        dadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx=0;
        gbc3.gridy=2;
        gbc3.gridwidth=2;
        gbc3.fill=GridBagConstraints.BOTH;
        gbc3.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosInactivos,gbc3);

        dadosActivos = new JPanel();
        dadosActivos.setPreferredSize(new Dimension(200,200));
        dadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx=2;
        gbc4.gridy=2;
        gbc4.gridwidth=2;
        gbc4.gridheight=2;
        gbc4.fill=GridBagConstraints.BOTH;
        gbc4.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosActivos,gbc4);

        dadosUsados = new JPanel();
        dadosUsados.setPreferredSize(new Dimension(300,200));
        dadosUsados.setBorder(BorderFactory.createTitledBorder("Dados Usados"));
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx=0;
        gbc5.gridy=3;
        gbc5.gridwidth=2;
        gbc5.fill=GridBagConstraints.BOTH;
        gbc5.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(dadosUsados,gbc5);

        lanzar = new JButton("Lanzar");
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx=1;
        gbc6.gridy=4;
        gbc6.gridwidth=2;
        gbc6.weightx=0.5;
        gbc6.fill=GridBagConstraints.BOTH;
        gbc6.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(lanzar, gbc6);

        tablero = new JPanel();
        tablero.setPreferredSize(new Dimension(450,200));
        tablero.setBorder(BorderFactory.createTitledBorder("Tablero de Puntuación"));
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx=0;
        gbc7.gridy=5;
        gbc7.gridwidth=4;
        gbc7.fill=GridBagConstraints.BOTH;
        gbc7.anchor=GridBagConstraints.CENTER;
        this.getContentPane().add(tablero,gbc7);

        ventanaAyuda = new JFrame();
        ventanaAyuda.setTitle("Ayuda");
        ventanaAyuda.setSize(800,300);
        ventanaAyuda.setDefaultCloseOperation(HIDE_ON_CLOSE);
        ventanaAyuda.setLayout(new BorderLayout());
        ventanaAyuda.setLocationRelativeTo(null);

        textoAyuda = new JLabel("""
                <html><b>Dinamica del Juego</b><br>
                <br>
                De los 10 dados que trae el juego se toman 3 y se colocan en el sector de "Dados Inactivos".
                Los otros 7 dados se tiran y pasan a ser los "Dados Activos".
                Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector de "Dados Utilizados".
                                
                Si como último dado activo queda un Dragón, se perderán todos los puntos acumulados.
                                
                Este juego lo jugará un único jugador y ganará si logra sumar 30 puntos o más en 5 rondas consecutivas de juego.
                <br>
                <br><b>Dados</b><br>
       
                <br><b>El Meeple </b> permite relanzar otro dado en juego, es decir, de la sección dados activos.         
                <br><b>La Nave Espacial</b> envía un dado no usado (de la sección dados activos) a la sección de dados inactivos.        
                <br><b>El Superhéroe permite</b> que cualquier dado no usado (sección dados activos) sea volteado y colocado en su cara opuesta.              
                <br><b>El corazón</b> permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo.  
                <br><b>El Dragón</b> es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados y acumulados.     
                <br><b>42</b> es la cara que permite sumar puntos al final de la ronda.
                </html>
                """);
        ventanaAyuda.add(textoAyuda,BorderLayout.CENTER);

        imageDado = new ImageIcon(getClass().getResource("/resources/6.png"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);
        dado3 = new JLabel(imageDado);
        dado4 = new JLabel(imageDado);
        dado5 = new JLabel(imageDado);
        dado6 = new JLabel(imageDado);
        dado7 = new JLabel(imageDado);
        dado8 = new JLabel(imageDado);
        dado9 = new JLabel(imageDado);
        dado10 = new JLabel(imageDado);

        model = new Model();
        escucha = new Escucha();
        lanzar.addActionListener(escucha);
        ayuda.addActionListener(escucha);

        dadosActivos.add(dado1);
        dadosActivos.add(dado2);
        dadosActivos.add(dado3);
        dadosActivos.add(dado4);
        dadosActivos.add(dado5);
        dadosActivos.add(dado6);
        dadosActivos.add(dado7);
        dadosInactivos.add(dado8);
        dadosInactivos.add(dado9);
        dadosInactivos.add(dado10);

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
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==lanzar){
                model.calcularTiro();
                int[] caras = model.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[0]+".png"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado2.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[2]+".png"));
                dado3.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[3]+".png"));
                dado4.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[4]+".png"));
                dado5.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[5]+".png"));
                dado6.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[6]+".png"));
                dado7.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[7]+".png"));
                dado8.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[8]+".png"));
                dado9.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[9]+".png"));
                dado10.setIcon(imageDado);
            } else if (e.getSource()==ayuda) {
                ventanaAyuda.setVisible(true);
            }
        }
    }
}