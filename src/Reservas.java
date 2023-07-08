import java.util.LinkedList;

public class Reservas {

    /**
     * Atributo de la reserva que representa el rut del usuario que hizo la transaccion
     */
    private String rutReservas;
    /**
     * Atributo de la reserva que representa el nombre del usuario que hizo la transaccion
     */
    private String nombreReservas;
    /**
     * Atributo de la reserva que representa el apellido del usuario que hizo la transaccion
     */
    private String apellidoReservas;
    /**
     * Atributo de la reserva que representa el ISBN del libro de la transaccion
     */
    private String ISBNReservas;
    /**
     * Atributo de la reserva que representa el nombre del libro de la transaccion
     */
    private String nombreLibroReservas;
    /**
     * Atributo de la reserva que representa el tipo de transaccion
     */
    private String tipoTransaccion;

    /**
     * Constructor clase objeto Reservas
     * @param rutReservas
     * @param nombreReservas
     * @param apellidoReservas
     * @param ISBNReservas
     * @param nombreLibroReservas
     * @param tipoTransaccion
     */
    public Reservas(String rutReservas, String nombreReservas, String apellidoReservas, String ISBNReservas, String nombreLibroReservas, String tipoTransaccion) {
        this.rutReservas = rutReservas;
        this.nombreReservas = nombreReservas;
        this.apellidoReservas = apellidoReservas;
        this.ISBNReservas = ISBNReservas;
        this.nombreLibroReservas = nombreLibroReservas;
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Retorna el rut del usuario que hizo la transaccion
     * @return
     */
    public String getRutReservas() {
        return rutReservas;
    }
    /**
     * Retorna el nombre del usuario que hizo la transaccion
     * @return
     */
    public String getNombreReservas() {
        return nombreReservas;
    }
    /**
     * Retorna el apellido del usuario que hizo la transaccion
     * @return
     */
    public String getApellidoReservas() {
        return apellidoReservas;
    }
    /**
     * Retorna ISBN del libro de la transaccion
     * @return
     */
    public String getISBNReservas() {
        return ISBNReservas;
    }
    /**
     * Retorna nombre del libro de la transaccion
     * @return
     */
    public String getNombreLibroReservas() {
        return nombreLibroReservas;
    }
    /**
     * Retorna el tipo de transaccion de la reserva
     * @return
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }
    /**
     * Metodo para retornar todos los datos del nodo (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */
    @Override
    public String toString() {
        return rutReservas + ", " + nombreReservas + ", " + apellidoReservas + ", " + ISBNReservas + ", " + nombreLibroReservas + ", " + tipoTransaccion;
    }
}
