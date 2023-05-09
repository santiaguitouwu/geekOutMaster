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
    private static final String MENSAJE_INICIO = "Inicia el juego, con el boton 'Activar' podras activar el dado seleccionado"
            + "Oprime el boton 'Cambiar' para cambiar el dado seleccionado"
            + "\nEl Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos."
            + "\nLa Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de dados\n" +
            "inactivos."
            + "\nEl Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y\n" +
            "colocado en su cara opuesta."
            + "\nEl Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un\n" +
            "nuevo dado activo."
            + "\nEl Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que\n" +
            "queda se habrán perdido todos los puntos ganados y acumulados."
            + "\n42 es cara que permite sumar puntos al final de la ronda."
            + "\nEste juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas consecutivas de juego.";

    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10, puntos;
    private JButton activar, cambiar, ayuda, escoger;
    private JPanel panelRondas, panelActivos, panelInactivos, panelUtilizados, panelPuntuacion, panelSeleccion, panelInteraccion, panelPuntos;
    private ImageIcon imageDados, imagePuntuacion;
    private JTextArea seleccionDado, tarjetaPuntuacion, tarjetaRonda, mensajeFinal;
    private Escucha escucha;
    private Model modelGame;
    private int dadoSeleccionado, flag, controlLabel, dadoSecundario, dadoPrincipal;


    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();
        setIconImage(new ImageIcon(getClass().getResource("/resources/dado.png")).getImage());
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dadoSeleccionado = 0;
        dadoSecundario = 10;
        flag = 0;
        controlLabel = 1;
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constrains = new GridBagConstraints();
        GridBagConstraints GBCInterno = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelGame = new Model();
        //Set up JComponents
        seleccionDado = new JTextArea(2, 6);
        tarjetaPuntuacion = new JTextArea(2, 5);
        mensajeFinal = new JTextArea(2, 5);
        tarjetaRonda = new JTextArea(1, 5);


        headerProject = new Header("Mesa de Juego Geek Out Masters", Color.BLACK);
        constrains.gridx = 0;
        constrains.gridy = 0;
        constrains.gridwidth = 2;
        constrains.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constrains);

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constrains.gridx = 0;
        constrains.gridy = 1;
        constrains.gridwidth = 1;
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constrains);

        imageDados = new ImageIcon(getClass().getResource("/resources/dado.png"));
        dado1 = new JLabel(imageDados);
        dado2 = new JLabel(imageDados);
        dado3 = new JLabel(imageDados);
        dado4 = new JLabel(imageDados);
        dado5 = new JLabel(imageDados);
        dado6 = new JLabel(imageDados);
        dado7 = new JLabel(imageDados);
        dado8 = new JLabel(imageDados);
        dado9 = new JLabel(imageDados);
        dado10 = new JLabel(imageDados);

        imagePuntuacion = new ImageIcon(getClass().getResource("/resources/cartaDados.png"));
        puntos = new JLabel(imagePuntuacion);


        panelRondas = new JPanel();
        panelRondas.setPreferredSize(new Dimension(200, 26));
        panelRondas.setBackground(Color.lightGray);
        constrains.gridx = 0;
        constrains.gridy = 1;
        constrains.gridwidth = 1;
        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.anchor = GridBagConstraints.PAGE_END;
        this.add(panelRondas, constrains);
        panelRondas.add(tarjetaRonda);
        tarjetaRonda.setBackground(null);

        panelActivos = new JPanel();
        panelActivos.setPreferredSize(new Dimension(400, 450));
        panelActivos.setBorder(BorderFactory.createTitledBorder(" Dados Activos "));
        constrains.gridx = 0;
        constrains.gridy = 2;
        constrains.gridheight = 4;
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.CENTER;
        add(panelActivos, constrains);

        panelActivos.add(dado1);
        panelActivos.add(dado2);
        panelActivos.add(dado3);
        panelActivos.add(dado4);
        panelActivos.add(dado5);
        panelActivos.add(dado6);
        panelActivos.add(dado7);
        panelActivos.add(dado8);
        panelActivos.add(dado9);
        panelActivos.add(dado10);


        panelInactivos = new JPanel();
        panelInactivos.setPreferredSize(new Dimension(330, 230));
        panelInactivos.setBorder(BorderFactory.createTitledBorder(" Dados Inactivos "));
        constrains.gridx = 1;
        constrains.gridy = 1;
        constrains.gridheight = 2;
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.CENTER;
        add(panelInactivos, constrains);

        panelUtilizados = new JPanel();
        panelUtilizados.setPreferredSize(new Dimension(330, 230));
        panelUtilizados.setBorder(BorderFactory.createTitledBorder(" Dados Utilizados "));
        constrains.gridx = 1;
        constrains.gridy = 3;
        constrains.gridheight = 2;
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.CENTER;
        add(panelUtilizados, constrains);

        panelPuntuacion = new JPanel();
        panelPuntuacion.setPreferredSize(new Dimension(330, 242));
        panelPuntuacion.setBorder(BorderFactory.createTitledBorder(" Puntuacion "));
        constrains.gridx = 1;
        constrains.gridy = 5;
        constrains.gridheight = 2;
        constrains.fill = GridBagConstraints.BOTH;
        constrains.anchor = GridBagConstraints.CENTER;
        add(panelPuntuacion, constrains);

        panelPuntos = new JPanel();
        panelPuntos.setPreferredSize(new Dimension(330, 26));
        panelPuntos.setBackground(Color.lightGray);
        panelPuntuacion.add(panelPuntos, BorderLayout.NORTH);
        tarjetaPuntuacion.setBackground(null);
        tarjetaPuntuacion.setEditable(false);
        mensajeFinal.setBackground(null);
        mensajeFinal.setEditable(false);
        panelPuntos.add(tarjetaPuntuacion);

        panelPuntuacion.add(puntos, BorderLayout.SOUTH);


        panelInteraccion = new JPanel(new GridBagLayout());
        panelInteraccion.setPreferredSize(new Dimension(300, 110));
        panelInteraccion.setBackground(Color.CYAN);
        constrains.gridx = 0;
        constrains.gridy = 6;
        constrains.gridheight = 1;
        constrains.fill = GridBagConstraints.BOTH;
        constrains.anchor = GridBagConstraints.CENTER;
        add(panelInteraccion, constrains);


        panelSeleccion = new JPanel();
        panelSeleccion.setPreferredSize(new Dimension(260, 52));
        panelSeleccion.setBackground(Color.LIGHT_GRAY);
        GBCInterno.gridx = 0;
        GBCInterno.gridy = 0;
        GBCInterno.gridheight = 2;
        GBCInterno.gridwidth = 1;
        GBCInterno.fill = GridBagConstraints.NONE;
        GBCInterno.anchor = GridBagConstraints.CENTER;
        panelSeleccion.setVisible(false);
        panelInteraccion.add(panelSeleccion, GBCInterno);


        cambiar = new JButton("Iniciar Juego");
        cambiar.addActionListener(escucha);
        panelInteraccion.add(cambiar, GBCInterno);

        activar = new JButton("activar");
        activar.addActionListener(escucha);
        GBCInterno.gridx = 1;
        GBCInterno.gridy = 1;
        GBCInterno.ipadx = 6;
        GBCInterno.gridheight = 1;
        GBCInterno.gridwidth = 1;
        GBCInterno.weighty = 50.0;
        GBCInterno.fill = GridBagConstraints.NONE;
        GBCInterno.anchor = GridBagConstraints.FIRST_LINE_END;
        activar.setVisible(false);
        panelInteraccion.add(activar, GBCInterno);

        escoger = new JButton("escoger");
        escoger.addActionListener(escucha);
        GBCInterno.gridx = 1;
        GBCInterno.gridy = 1;
        GBCInterno.ipadx = 8;
        //GBCInterno.gridheight = 1;
        GBCInterno.gridwidth = 1;
        GBCInterno.weighty = 50.0;
        GBCInterno.fill = GridBagConstraints.NONE;
        GBCInterno.anchor = GridBagConstraints.FIRST_LINE_END;
        escoger.setVisible(false);
        panelInteraccion.add(escoger, GBCInterno);

    }


    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI myProject = new GUI();
        });
    }
    private class Escucha implements ActionListener {
        String[] zonaActivos, zonaUtilizados,zonaInactivos;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cambiar) {
                if (flag != 1) {
                    cambiar.setText("cambiar");
                    GridBagConstraints GBCInterno = new GridBagConstraints();
                    GBCInterno.gridx = 1;
                    GBCInterno.gridy = 0;
                    GBCInterno.gridheight = 1;
                    GBCInterno.gridwidth = 1;
                    GBCInterno.weighty = 50.0;
                    GBCInterno.fill = GridBagConstraints.NONE;
                    GBCInterno.anchor = GridBagConstraints.LAST_LINE_END;
                    panelInteraccion.add(cambiar, GBCInterno);

                    if (flag == 2) {
                        panelPuntos.remove(mensajeFinal);
                        panelPuntos.add(tarjetaPuntuacion);
                    } else {
                        seleccionDado.setBackground(null);
                        seleccionDado.setEditable(false);
                        seleccionDado.setFont(new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 12));
                        panelSeleccion.add(seleccionDado);
                    }

                    panelSeleccion.setVisible(true);
                    activar.setVisible(true);
                    flag = 1;


                    imagePuntuacion = new ImageIcon(getClass().getResource("/resources/ImagePuntuacion.jpeg"));
                    puntos.setIcon(imagePuntuacion);
                    //actualizarInterfaz();
                }

            }
        }
    }
}


