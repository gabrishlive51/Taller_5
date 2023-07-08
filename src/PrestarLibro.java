import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class PrestarLibro extends JFrame{
    /**
     *  ISBN de entrada por teclado
     */
    private JTextField campoISBN;
    /**
     *  Boton que pide el libro
     */
    private JButton pedirButton;
    /**
     * Ventana interfaz de agregar libro
     */
    private JPanel prestarLibro;
    /**
     * Boton que devuelve al menu
     */
    private JButton volverButton;
    /**
     * Constructor de la clase interfaz "prestar libro"
     * @param rutActivo
     * @param nombreActivo
     * @param apellidoActivo
     * @param listaReservas
     */
    public PrestarLibro(String rutActivo, String nombreActivo, String apellidoActivo, LinkedList<Reservas> listaReservas) {

        setContentPane(prestarLibro);
        setTitle("Prestar Libro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "pedir libro"
        pedirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturaArchivos lectura = new LecturaArchivos();
                ArrayList<Libro> listaLibro = new ArrayList<>();
                lectura.leerArchivoLibros(listaLibro);
                buscarLibro(listaLibro, rutActivo, nombreActivo, apellidoActivo, listaReservas);
            }
        });

        // Funcionamiento boton volver a menu
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGUI menuGUI = new MenuGUI(rutActivo, nombreActivo, apellidoActivo, listaReservas);
                dispose();
            }
        });
    }

    /**
     * Metodo que se encarga de buscar y prestar libros
     * @param listaLibro
     * @param rutActivo
     * @param nombreActivo
     * @param apellidoActivo
     * @param listaReservas
     */
    public void buscarLibro(ArrayList<Libro> listaLibro,String rutActivo, String nombreActivo, String apellidoActivo, LinkedList<Reservas> listaReservas){
        // Recorre la lista de entrada por parametro
        for (Libro aux : listaLibro) {
            // Si encuentra un ISBN igual al de entrada por teclado
            if (aux.getISBN().equals(campoISBN.getText().trim())) {
                // Si aun queda stock, lo presta y termina el metodo
                if (aux.getStock() > 0) {
                    JOptionPane.showMessageDialog(prestarLibro, "Libro '" + aux.getNombre() + "' prestado correctamente.");
                    // Actualiza stock
                    aux.setStock(aux.getStock() - 1);
                    new LecturaArchivos().agregarLibro(listaLibro);

                    // Agrega el prestamo a la lista de reservas
                    Reservas r = new Reservas(rutActivo, nombreActivo, apellidoActivo, aux.getISBN().trim(), aux.getNombre().trim(), "Préstamo");
                    listaReservas.add(r);

                    // Devuelve al menu
                    Limpiar();
                    MenuGUI menuGUI = new MenuGUI(rutActivo, nombreActivo, apellidoActivo, listaReservas);
                    dispose();
                    return;
                }
                // Si no queda stock de ese libro limpia el campo de texto y termina el metodo
                else {
                    JOptionPane.showMessageDialog(prestarLibro, "No hay stock de este libro.");
                    Limpiar();
                    return;
                }
            }
        }
        // Si no existe el ISBN de entrada de texto abre una ventana de error
        JOptionPane.showMessageDialog(prestarLibro, "Ingrese ISBN válido.");
        Limpiar();
    }
    /**
     * Metodo que limpia el campo de texto de entrada
     */
    private void Limpiar(){ campoISBN.setText(""); }
}
