package password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventana extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField cajaTexto;
    private static JTextField cajaTexto2;
    private JButton boton1;
    private static JRadioButton radioBoton1 = new JRadioButton();
    private static JRadioButton radioBoton2 = new JRadioButton();
    private static JRadioButton radioBoton3 = new JRadioButton();
    private static JRadioButton radioBoton4 = new JRadioButton();


    public ventana() {
        this.setSize(500, 250);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setTitle("Generador de Contraseñas");

        this.setLocationRelativeTo(null);

        iniciarcomponetes();//llamar los demas componentes

    }

    private void iniciarcomponetes() {
        colocarPaneles();

        colocarEtiquetas();

        colocarBotones();

        colocarCajaDeTexto();

        colocarRadioBotones();
    }

    private void colocarPaneles() {
        panel = new JPanel();

        this.getContentPane().add(panel);

        panel.setLayout(null);
    }

    private void colocarEtiquetas() {
        JLabel etiqueta = new JLabel();

        etiqueta.setText("Contraseña");

        etiqueta.setFont(new Font("", Font.BOLD, 16));

        etiqueta.setBounds(5, 20, 200, 30);

        panel.add(etiqueta);

        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

        /*      ******************      */


        JLabel etiqueta2 = new JLabel();

        etiqueta2.setText("Longitud");

        etiqueta2.setFont(new Font("", Font.BOLD, 14));

        etiqueta2.setBounds(30, 90, 70, 30);

        panel.add(etiqueta2);

        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void colocarBotones() {
        boton1 = new JButton();

        boton1.setText("Generar contraseña");

        boton1.setEnabled(true);

        boton1.setBounds(30, 170, 180, 30);

        boton1.setFont(new Font("arial", Font.BOLD, 14));

        panel.add(boton1);

        boton1.addActionListener(this);
    }

    private void colocarCajaDeTexto() {
        cajaTexto = new JTextField();
        cajaTexto.setBounds(30, 50, 300, 30);
        panel.add(cajaTexto);

        cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(30, 117, 55, 20);
        panel.add(cajaTexto2);
    }

    private void colocarRadioBotones() {
        radioBoton1.setBounds(120, 100, 95, 45);
        radioBoton1.setText("Mayusculas");
        radioBoton1.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(radioBoton1);

        radioBoton2.setBounds(217, 100, 87, 45);
        radioBoton2.setText("Minisculas");
        radioBoton2.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(radioBoton2);

        radioBoton3.setBounds(308, 100, 80, 45);
        radioBoton3.setText("Numeros");
        radioBoton3.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(radioBoton3);

        radioBoton4.setBounds(385, 100, 80, 45);
        radioBoton4.setText("Simbolos");
        radioBoton4.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(radioBoton4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cajaTexto.setText(password());
    }

    public static String password() {
        int cantidadContrasena2 = 0;
        StringBuilder contrasena = new StringBuilder();

        try {
            // crear los elementos
            char[] mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            char[] minisculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            char[] simbolos = {'!', '#', '$', '%', '&', '/', '(', ')', '=', '?', '¡', '+', '*', '{', '}', '[', ']', '-', '.', '_', ';', ',', ':'};

            // unir los arrays
            StringBuilder caracteres = new StringBuilder();

            if (radioBoton1.isSelected()) {
                caracteres.append(mayusculas);
            }
            if (radioBoton2.isSelected()) {
                caracteres.append(minisculas);
            }
            if (radioBoton3.isSelected()) {
                caracteres.append(numeros);
            }
            if (radioBoton4.isSelected()) {
                caracteres.append(simbolos);
            }


            String cantidadContrasena = cajaTexto2.getText();
            cantidadContrasena2 = Integer.parseInt(cantidadContrasena);

            // Generar la contraseña
            for (int i = 0; i < cantidadContrasena2; i++) {
                int cantidad = caracteres.length();
                int numeroRandom = (int) (Math.random() * cantidad);

                contrasena.append((caracteres.toString()).charAt(numeroRandom));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return contrasena.toString();
    }


}