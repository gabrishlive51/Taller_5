import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class MenuGUI extends JFrame{
    /**
     *  Boton que abre la ventana "buscar libro"
     */
    private JButton buscarLibroButton;
    /**
     *  Boton que abre la ventana "devolver libro"
     */
    private JButton devolverLibroButton;
    /**
     *  Boton que abre la ventana "prestar libro"
     */
    private JButton prestarLibroButton;
    /**
     *  Boton que abre la ventana "agregar nuevo libro"
     */
    private JButton agregarNuevoLibroButton;
    /**
     *  Ventana interfaz de menu
     */
    private JPanel menuBiblioteca;
    /**
     *  Boton que abre la ventana "iniciar sesion"
     */
    private JButton cerrarSesionButton;
    /**
     * Constructor de la clase interfaz "menu"
     * @param rutActivo
     * @param nombreActivo
     * @param apellidoActivo
     * @param listaReservas
     */
    public MenuGUI(String rutActivo, String nombreActivo, String apellidoActivo, LinkedList<Reservas> listaReservas){

        setContentPane(menuBiblioteca);
        setTitle("Menu de Biblioteca");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "buscar libro"
        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarLibro buscarLibro = new BuscarLibro();
                dispose();
            }
        });

        // Funcionamiento boton "prestar libro"
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrestarLibro prestarLibro = new PrestarLibro(rutActivo, nombreActivo, apellidoActivo, listaReservas);
                dispose();
            }
        });

        // Funcionamiento boton "agregar libro"
        agregarNuevoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarLibro agregarLibro = new AgregarLibro();
                dispose();
            }
        });

        // Funcionamiento boton "devolver libro"
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DevolverLibro devolverLibro = new DevolverLibro(rutActivo, nombreActivo, apellidoActivo, listaReservas);
                dispose();
            }
        });

        // Funcionamiento boton "cerrar sesion"
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IniciarSesion iniciarSesion = new IniciarSesion(listaReservas);
                dispose();
            }
        });
    }
}
