import java.util.LinkedList;

public class SistemaImpl implements Sistema{
    @Override
    public void IniciarSesion() {
        IniciarSesion iniciarSesion = new IniciarSesion(new LinkedList<>());
    }
}
