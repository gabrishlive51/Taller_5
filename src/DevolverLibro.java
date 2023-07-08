import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class DevolverLibro extends JFrame {
    /**
     *  ISBN de entrada por teclado
     */
    private JTextField campoISBN;
    /**
     *  Boton que devuelve el libro
     */
    private JButton devolverButton;
    /**
     *  Boton que devuelve al menu
     */
    private JButton volverButton;
    /**
     *  Ventana interfaz de devolver libro
     */
    private JPanel devolverLibro;
    /**
     * Constructor de clase interfaz "devolver libro"
     * @param rutActivo
     * @param nombreActivo
     * @param apellidoActivo
     * @param listaReservas
     */
    public DevolverLibro(String rutActivo, String nombreActivo, String apellidoActivo, LinkedList<Reservas> listaReservas) {

        setContentPane(devolverLibro);
        setTitle("Devolver Libro");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "devolver libro"
        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturaArchivos lectura = new LecturaArchivos();
                ArrayList<Libro> listaLibro = new ArrayList<>();
                lectura.leerArchivoLibros(listaLibro);
                DevolverLibro(listaLibro, rutActivo, nombreActivo, apellidoActivo, listaReservas);
            }
        });

        // Funcionamiento boton volver a menu
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana MENU instanciandola y cierra esta ventana
                MenuGUI menuGUI = new MenuGUI(rutActivo,nombreActivo,apellidoActivo, listaReservas);
                dispose();
            }
        });
    }

    /**
     * Metodo que verifica y devuelve libros
     * @param listaLibro
     * @param rutActivo
     * @param nombreActivo
     * @param apellidoActivo
     */
    public void DevolverLibro(ArrayList<Libro> listaLibro, String rutActivo, String nombreActivo, String apellidoActivo, LinkedList<Reservas> listaReservas){
        for (Libro aux : listaLibro) {
            if (aux.getISBN().trim().equals(campoISBN.getText().trim())) {
                JOptionPane.showMessageDialog(devolverLibro, "Devolución del libro '" + aux.getNombre() + "' exitosa");
                // Actualiza stock
                aux.setStock(aux.getStock() + 1);
                new LecturaArchivos().agregarLibro(listaLibro);

                // Agregar lo que se hizo a una lista para despues agregarlo en el registro
                Reservas r = new Reservas(rutActivo, nombreActivo, apellidoActivo, aux.getISBN().trim(), aux.getNombre().trim(), "Devolución");
                listaReservas.add(r);

                // Devuelve al menu
                MenuGUI menuGUI = new MenuGUI(rutActivo, nombreActivo, apellidoActivo, listaReservas);
                dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(devolverLibro, "ISBN inválido");
    }
}
