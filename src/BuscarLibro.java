import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class BuscarLibro extends JFrame{
    /**
     *  Boton que comienza la busqueda del libro
     */
    private JButton buscarButton;
    /**
     *  ISBN de entrada por teclado
     */
    private JTextField campoISBN;
    /**
     *  Texto que despliega la informacion del libro
     */
    private JTextArea desplegarLibro;
    /**
     * Ventana interfaz de buscar libro
     */
    private JPanel buscarLibro;
    /**
     *  Boton que devuelve al menu
     */
    private JButton volverButton;
    /**
     *  Constructor de la clase interfaz "buscar libro"
     */
    public BuscarLibro(){

        setContentPane(buscarLibro);
        setTitle("Buscar Libro");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "buscar libro"
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LecturaArchivos lectura = new LecturaArchivos();
                ArrayList<Libro> listaLibro = new ArrayList<>();
                lectura.leerArchivoLibros(listaLibro);
                BuscarLibro(listaLibro);
            }
        });

        // Funcionamiento boton volver a menu
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana MENU instanciandola y cierra esta ventana
                MenuGUI menu = new MenuGUI("","","", new LinkedList<>());
                dispose();
            }
        });
    }
    /**
     * Metodo que busca libros
     * @param listaLibro
     */
    public void BuscarLibro(ArrayList<Libro> listaLibro){
        // Recorre cada elemento de la lista de parametro
        for (Libro aux : listaLibro) {
            // Si el ISBN es el mismo al de texto de entrada, entonces despliega el libro y termina el metodo
            if (aux.getISBN().trim().equals(campoISBN.getText().trim())) {
                desplegarLibro.setText("Titulo: " + aux.getNombre()
                        +  "\nAutor: " + aux.getAutor()
                        + "\nCategoría: " + aux.getCategoria()
                        + "\nNúmero de copias: " + aux.getStock()
                        + "\nNúmero de páginas: " + aux.getCantPaginas());
                return;
            }
        }
        // Si no encuentra el libro, abre una ventana de error
        JOptionPane.showMessageDialog(buscarLibro, "Ingrese ISBN válido.");
    }
}
