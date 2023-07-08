import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Marcelo Céspedes.
 */
public class LecturaArchivos {
    /**
     * Método encargado de leer el archivo de "libros.txt".
     * @param arrayLibro
     * @return arrayLibro con datos leidos
     */
    public ArrayList leerArchivoLibros(ArrayList<Libro> arrayLibro) {
        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // si la linea no tiene caracteres, se omite
                if (line.trim().isEmpty()) { continue; }
                String[] chain = line.split(",");
                // limpia los espacios
                for (int i = 0; i < chain.length; i++) { chain[i] = chain[i].trim(); }
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int stock = Integer.parseInt(chain[5]);

                // Instancia los libros al ejecutar la lectura
                Libro libro = new Libro(isbn, title, author, category, copies, stock);
                arrayLibro.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return arrayLibro;
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     * @param listaNexoUsuario
     * @return listaNexoUsuario con datos leidos
     */
    public LinkedList leerArchivoUsuarios(LinkedList<Usuario> listaNexoUsuario) {

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // si la linea no tiene caracteres, se omite
                if (line.trim().isEmpty()) { continue; }
                String[] chain = line.split(",");
                // limpia los espacios
                for (int i = 0; i < chain.length; i++) { chain[i] = chain[i].trim(); }
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];
                // Instancia los usuarios al ejecutar la lectura
                Usuario u = new Usuario(rut, name, lastname, password);
                listaNexoUsuario.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return listaNexoUsuario;
    }
    /**
     * Método encargado de modificar el archivo libros.txt
     * @param libroAgregar
     */
    public void agregarLibro(List<Libro> libroAgregar) {
        // Modifica el archivo "libros.txt"
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("libros.txt"));

            for (Libro aux : libroAgregar) {
                String linea = aux.getISBN() +
                        ", " + aux.getNombre() +
                        ", " + aux.getAutor() +
                        ", " + aux.getCategoria() +
                        ", " + aux.getCantPaginas() +
                        ", " + aux.getStock();
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.close();
        }
        catch (IOException e) {

            System.out.println("Error en escritura");
            e.printStackTrace();

        }
    }

    /**
     * Metodo encargado de escribir el archivo reservas.txt
     * @param listaReservas
     */
    public void agregarReservas(LinkedList<Reservas> listaReservas) {
        //lee el documento "reservas.txt"
        LinkedList<Reservas> listaReservasLeidas = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("reservas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // si la linea no tiene caracteres, se omite
                if (line.trim().isEmpty()) { continue; }
                String[] chain = line.split(",");
                // limpia los espacios
                for (int i = 0; i < chain.length; i++) { chain[i] = chain[i].trim(); }
                String rutReservas = chain[0];
                String nombreReservas = chain[1];
                String apellidoReservas = chain[2];
                String ISBNReservas = chain[3];
                String nombreLibroReservas = chain[4];
                String tipoTransaccion = chain[5];
                // Instancia los usuarios al ejecutar la lectura
                Reservas aux = new Reservas(rutReservas, nombreReservas, apellidoReservas, ISBNReservas, nombreLibroReservas, tipoTransaccion);
                listaReservasLeidas.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // Escribe un documento "reservas.txt"
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("reservas.txt"));

            for (Reservas aux : listaReservas) {
                listaReservasLeidas.add(aux);
            }
            for (Reservas aux : listaReservasLeidas) {
                String linea = aux.getRutReservas() +
                        "," + aux.getNombreReservas() +
                        "," + aux.getApellidoReservas() +
                        "," + aux.getISBNReservas() +
                        "," + aux.getNombreLibroReservas() +
                        "," + aux.getTipoTransaccion();
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.close();
        }
        catch (IOException e) {

            System.out.println("Error en escritura");
            e.printStackTrace();

        }
    }
}