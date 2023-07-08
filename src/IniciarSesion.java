import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class IniciarSesion extends JFrame {
    /**
     * Rut de entrada por teclado
     */
    private JTextField campoRutTextField;
    /**
     * Contrasena de entrada por teclado
     */
    private JPasswordField contrasenaPasswordField;
    /**
     * Boton de iniciar sesion
     */
    private JButton iniciarSesionButton;
    /**
     * Ventana interfaz de iniciar sesion
     */
    private JPanel iniciarSesion;
    /**
     * Boton de cerrar el programa
     */
    private JButton cerrarButton;
    private JLabel imagenIniciarSesion;

    /**
     * Constructor de la clase interfaz "iniciar sesion"
     * @param listaReservas
     */
    public IniciarSesion(LinkedList<Reservas> listaReservas) {

        setContentPane(iniciarSesion);
        setTitle("Iniciar Sesion");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "iniciar sesion"
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturaArchivos lectura = new LecturaArchivos();
                LinkedList<Usuario> listaUsuario = new LinkedList<>();
                lectura.leerArchivoUsuarios(listaUsuario);
                Ingresar(listaUsuario);
            }
        });
        // Funcionamiento boton cerrar programa
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EscrituraRegistro(listaReservas);
                dispose();
            }
        });
    }

    /**
     * Metodo que verifica e inicia el usuario al sistema
     * @param listaUsuario
     */
    public void Ingresar(LinkedList<Usuario> listaUsuario) {
        try {
            // Rut y contrasena de entrada por teclado
            String rut = campoRutTextField.getText();
            String contrasena = new String(contrasenaPasswordField.getPassword());

            // Si el rut y contrasena de entrada por teclado estan en la lista de entrada por parametro, entonces inicia sesion
            if (!rut.isEmpty() && !contrasena.isEmpty()) {
                for (Usuario aux : listaUsuario) {
                    if (aux.getRut().equals(rut) && aux.getContrasena().equals(contrasena)) {

                        // Abre la ventana MENU instanciandola y cierra esta ventana
                        LinkedList<Reservas> listaReservas = new LinkedList<>();
                        MenuGUI menu = new MenuGUI(aux.getRut(), aux.getNombre(), aux.getApellido(), listaReservas);
                        dispose();
                        return;
                    }
                }
                // Si el rut y contrasena de entrada por teclado no estan en la lista de entrada por parametro, entonces abre ventana de error
                JOptionPane.showMessageDialog(iniciarSesion, "Rut o contraseña inválido.");
                Limpiar();
            } else {
                // Si los campos de textos estan vacios, abre ventana de error
                JOptionPane.showMessageDialog(iniciarSesion, "Por favor complete los campos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(iniciarSesion, "Campos invalidos, por favor vuelva a intentarlo");
            Limpiar();
        }
    }

    /**
     * Metodo que escribe las transacciones del usuario en reservas.txt
     * @param listaReservas
     */
    public void EscrituraRegistro(LinkedList<Reservas> listaReservas) {
        LecturaArchivos escrituraReservas = new LecturaArchivos();
        escrituraReservas.agregarReservas(listaReservas);
    }

    /**
     * Metodo que limpia los campos de texto de entrada
     */
    public void Limpiar() {
        campoRutTextField.setText("");
        contrasenaPasswordField.setText("");
    }
}
