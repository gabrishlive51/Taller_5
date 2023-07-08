public class Usuario {
    /**
     *  Rut del usuario
     */
    private String rut;
    /**
     *  Nombre del usuario
     */
    private String nombre;
    /**
     *  Apellido del usuario
     */
    private String apellido;
    /**
     *  Contrasena del usuario
     */
    private String contrasena;

    /**
     * Constructor de la clase objeto usuario
     * @param rut
     * @param nombre
     * @param apellido
     * @param contrasena
     */
    public Usuario(String rut, String nombre, String apellido, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    /**
     * Retorna el rut del usuario
     * @return
     */
    public String getRut() {
        return rut;
    }
    /**
     * Retorna el nombre del usuario
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Retorna el apellido del usuario
     * @return
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Retorna la contrasena del usuario
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo para retornar todos los datos del nodo (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */
    @Override
    public String toString() { return rut + ", " + nombre + ", " + apellido + ", " + contrasena; }
}
