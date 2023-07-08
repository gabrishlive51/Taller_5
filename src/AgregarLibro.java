import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class AgregarLibro extends JFrame{
    /**
     * ISBN de entrada por teclado
     */
    private JTextField campoISBN;
    /**
     * Titulo de entrada por teclado
     */
    private JTextField campoTitulo;
    /**
     * Autor de entrada por teclado
     */
    private JTextField campoAutor;
    /**
     * Categoria de entrada por teclado
     */
    private JTextField campoCategoria;
    /**
     * Paginas de entrada por teclado
     */
    private JTextField campoPaginas;
    /**
     * Stock de entrada por teclado
     */
    private JTextField campoStock;
    /**
     * Boton que agrega el libro
     */
    private JButton agregarButton;
    /**
     * Boton que devuelve al menu
     */
    private JButton volverButton;
    /**
     * Ventana interfaz de agregar libro
     */
    private JPanel agregarLibro;

    /**
     * Constructor de la clase interfaz "agregar libro"
     */
    public AgregarLibro(){
        setContentPane(agregarLibro);
        setTitle("Agregar libro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Funcionamiento boton "agregar libro"
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturaArchivos lectura = new LecturaArchivos();
                ArrayList<Libro> listaLibro = new ArrayList<>();
                lectura.leerArchivoLibros(listaLibro);
                AgregarLibro(listaLibro);
            }
        });

        // Funcionamiento boton volver a menu
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana MENU instanciandola y cierra esta ventana
                MenuGUI menuGUI = new MenuGUI("","","", new LinkedList<>());
                dispose();
            }
        });
    }
    /**
     * Metodo que verifica y agrega libros
     * @param listaLibro
     */
    public void AgregarLibro(ArrayList<Libro> listaLibro){
        try {
            if (campoISBN.getText().trim().length() == 13
                    && !campoTitulo.getText().trim().isEmpty()
                    && !campoAutor.getText().trim().isEmpty()
                    && !campoCategoria.getText().trim().isEmpty()
                    && Integer.parseInt(campoPaginas.getText()) > 0
                    && Integer.parseInt(campoStock.getText()) > 0) {
                for (Libro aux : listaLibro) {
                    if (aux.getISBN().trim().equals(campoISBN.getText().trim())) {
                        JOptionPane.showMessageDialog(agregarLibro, "ISBN ya en el sistema.");
                        return;
                    }
                }
                Libro libro = new Libro(campoISBN.getText().trim(),
                        campoTitulo.getText().trim(),
                        campoAutor.getText().trim(),
                        campoCategoria.getText().trim(),
                        Integer.parseInt(campoPaginas.getText().trim()),
                        Integer.parseInt(campoStock.getText().trim()));
                listaLibro.add(libro);
                new LecturaArchivos().agregarLibro(listaLibro);
                JOptionPane.showMessageDialog(agregarLibro, "Libro agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(agregarLibro, "1 o más campos inválidos.");
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(agregarLibro, "1 o más campos inválidos.");
        }
    }
}
